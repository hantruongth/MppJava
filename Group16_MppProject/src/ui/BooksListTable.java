package ui;

import java.util.ArrayList;
import java.util.Collection;

import java.util.List;
import java.util.Optional;

import business.Book;
import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;



public class BooksListTable {
	

    @FXML private TableView<Book> tableView;
    @FXML private TableColumn<Book, String> isbn = new TableColumn<>("isbn");
    @FXML private TableColumn<Book, String> title = new TableColumn<>("title");
    @FXML private TableColumn<Book, String> authors = new TableColumn<>("authors");
    @FXML private TableColumn<Book, String> numCopies = new TableColumn<>("numCopies");
    @FXML private TableColumn<Book, Boolean> available = new TableColumn<>("available");
    
    final Image availableImage = new Image("/ui/available.png");
    final Image unavailableImage = new Image("/ui/unavailable.png");
    
    DataAccess da = new DataAccessFacade();
    
    
    @FXML
    public void initialize() {
    	
    	title.setCellValueFactory(new PropertyValueFactory<>("title"));
    	isbn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
    	authors.setCellValueFactory(new PropertyValueFactory<>("authors"));
    	numCopies.setCellValueFactory(new PropertyValueFactory<>("numCopies"));
    	available.setCellValueFactory(new PropertyValueFactory<>("available"));
    	
    	
    	available.setCellFactory(col -> new TableCell<Book, Boolean>() {

    	    private final ImageView imageView = new ImageView();
    	    {
    	        imageView.setFitWidth(20);
    	        imageView.setFitHeight(20);
    	        setGraphic(imageView);
    	    }
    	    @Override
    	    protected void updateItem(Boolean item, boolean empty) {
    	        if (empty || item == null) {
    	            imageView.setImage(null);
    	        } else {
    	            imageView.setImage(item ? availableImage : unavailableImage);
    	        }
    	    }
    	});
    	
    	tableView.setRowFactory( tv -> {
    	    TableRow<Book> row = new TableRow<>();
    	    row.setOnMouseClicked(event -> {
    	        if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
    	            Book rowData = row.getItem();
    	            
    	            if (rowData.getAvailable() == true) {
    	            	
    	            	StringBuilder sb = new StringBuilder("The book: \n");
    	        		sb.append("ISBN: " + rowData.getIsbn() + "\n");
    	        		sb.append("Title: " + rowData.getTitle() + "\n");
    	        		sb.append("Authors: " + rowData.getAuthors() + "\n");
    	        		sb.append("is not Available");
    	        			
    	            	Alert alert = new Alert(AlertType.WARNING,
    	            			sb.toString());
    	            	
    	            	alert.show(); 
    	            }
    	        }
    	    });
    	    return row ;
    	});
    	
        tableView.getItems().setAll(parseUserList());
        addButtonToTable();
    }
    
    private List<Book> parseUserList(){
    	
		Collection<Book> books = da.readBooksMap().values();	
		List<Book> bs = new ArrayList<>();
		bs.addAll(books);
		
    	return bs;
	}
    
    private void addButtonToTable() {
        TableColumn<Book, Void> colBtn = new TableColumn("Button Column");

        Callback<TableColumn<Book, Void>, TableCell<Book, Void>> cellFactory = new Callback<TableColumn<Book, Void>, TableCell<Book, Void>>() {
            @Override
            public TableCell<Book, Void> call(final TableColumn<Book, Void> param) {
                final TableCell<Book, Void> cell = new TableCell<Book, Void>() {

                    private final Button btn = new Button("Make a Copy");

                    {
                        btn.setOnAction((ActionEvent event) -> {
                        	Book data = getTableView().getItems().get(getIndex());
                        	
                        	
                        	Alert alert = new Alert(AlertType.CONFIRMATION);
                            alert.setTitle("Make a Copy");
                            StringBuilder sb = new StringBuilder("The book is: \n");
        	        		sb.append("ISBN: " + data.getIsbn() + "\n");
        	        		sb.append("Title: " + data.getTitle() + "\n");
        	        		sb.append("Authors: " + data.getAuthors() + "\n");
        	        		alert.setHeaderText("Are you sure want to make a copy?");
        	        		
                            alert.setContentText(sb.toString());
                       
                            // option != null.
                            Optional<ButtonType> option = alert.showAndWait();
                       
                            if (option.get() == ButtonType.OK) {
                            	System.out.println("File deleted!");
                            	data.addCopy();
                            	da.saveBook(data);
                            	tableView.getItems().clear();
                            	tableView.getItems().setAll(parseUserList());	
                            	
                            }
                            
                            System.out.println("selectedData: " + data);
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };

        colBtn.setCellFactory(cellFactory);

        tableView.getColumns().add(colBtn);

    }
}