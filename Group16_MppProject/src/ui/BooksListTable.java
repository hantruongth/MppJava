package ui;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

import business.Book;
import business.BookCopy;

import business.CheckoutRecord;
import business.ControllerInterface;
import business.LibraryMember;
import business.MemberCheckoutsFactory;
import business.SystemController;
import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;
import javafx.collections.ListChangeListener.Change;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;



public class BooksListTable {
	

    @FXML private TableView<Book> tableView;
    @FXML private TableColumn<Book, String> isbn = new TableColumn<>("isbn");
    @FXML private TableColumn<Book, String> title = new TableColumn<>("title");
    @FXML private TableColumn<Book, String> authors = new TableColumn<>("authors");
    @FXML private TableColumn<Book, String> numCopies = new TableColumn<>("numCopies");
    @FXML private TableColumn<Book, Boolean> available = new TableColumn<>("available");
    @FXML private TableColumn<Book, String> countavailable = new TableColumn<>("countAvailable");
    
    @FXML private Button btnCheckout;
    
    
    final Image availableImage = new Image("/ui/available.png");
    final Image unavailableImage = new Image("/ui/unavailable.png");
    
    DataAccess da = new DataAccessFacade();
    ControllerInterface ci = new SystemController();
    
    
    @FXML
    public void initialize() {
    	
    	tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    	
    	title.setCellValueFactory(new PropertyValueFactory<>("title"));
    	isbn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
    	authors.setCellValueFactory(new PropertyValueFactory<>("authors"));
    	numCopies.setCellValueFactory(new PropertyValueFactory<>("numCopies"));
    	available.setCellValueFactory(new PropertyValueFactory<>("available"));
    	countavailable.setCellValueFactory(new PropertyValueFactory<>("countAvailable"));
    	
    	
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
    	    TableRow<Book> row = new TableRow<Book>();
    	    
    	    row.setOnMouseClicked(event -> {
    	  
    	    	Book rowData = row.getItem();
    	    	
    	    	if (rowData.getAvailable() == false) {
    	    		System.out.println("estamos mirando que putas podemos hacer");
    	    		tableView.getSelectionModel().clearSelection(row.getIndex());
    	    	}
    	    	
    	        if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
    	            
    	            StringBuilder sb = new StringBuilder("The book: \n");
	        		sb.append("ISBN: " + rowData.getIsbn() + "\n");
	        		sb.append("Title: " + rowData.getTitle() + "\n");
	        		sb.append("Authors: " + rowData.getAuthors() + "\n");
	        		
    	            if (rowData.getAvailable() == false) {
    	            	
    	        		sb.append("is not Available");
    	        			
    	            	Alert alert = new Alert(AlertType.INFORMATION,
    	            			sb.toString());
    	            	
    	            	alert.show(); 
    	            }else {
    	            	
    	            	sb.append("is Available");
    	        	
    	        		List<LibraryMember> membersList = ci.allMemebers();    	        		
    	            	
    	            	ChoiceDialog<LibraryMember> dialog = new ChoiceDialog<LibraryMember>(null, membersList);
    	            	
    	            	dialog.setTitle("Checkout a Book");
    	            	dialog.setHeaderText(sb.toString());
    	            	dialog.setContentText("Select a Member:");
    	            	 
    	            	Optional<LibraryMember> result = dialog.showAndWait();
    	            	
    	            	if (result.isPresent()) {
    	            		result.ifPresent(member -> {
    	            			
    	            			BookCopy copy = rowData.getNextAvailableCopy();
    	            			
    	            			CheckoutRecord record = MemberCheckoutsFactory.createCheckoutRecord(member, LocalDate.now());
    	            			MemberCheckoutsFactory.createCheckoutEntry(record, copy, LocalDate.now());
    	            			copy.changeAvailability();
    	            			rowData.updateCopies(copy);
    	            			da.saveBook(rowData);
    	            			tableView.getItems().clear();
    	            			tableView.getItems().setAll(ci.allBooks());
    	            			System.out.println(rowData);
    	            			
        	                });
    	            	}else {
    	            		
    	            		System.out.println(result);
        	        		Label label = new Label("You must select a Member!!");

        	        		GridPane expContent = new GridPane();
        	        		expContent.setMaxWidth(Double.MAX_VALUE);
        	        		expContent.add(label, 0, 0);
        	        		dialog.getDialogPane().setExpandableContent(expContent);
        	        		dialog.getDialogPane().setExpanded(true);
        	        		dialog.show();
        	        		
    	            	}
    	            }
    	        }
    	    });
    	    return row ;
    	});
    	
    	tableView.getSelectionModel().getSelectedItems().addListener((Change<? extends Book> change) -> {
        	
    		System.out.println("estamos controlando:::" + tableView.getSelectionModel().getSelectedItems());
        	
        	ObservableList<Book> selectedItems = tableView.getSelectionModel().getSelectedItems();

	        ArrayList<Book> selectedIDs = new ArrayList<Book>();
	        for (Book row : selectedItems) {
	           selectedIDs.add(row);
	        }
	        
	        if (selectedIDs.size() > 0) {
	        	btnCheckout.setDisable(false);
	        }else {
	        	btnCheckout.setDisable(true);
	        }
        });
    	
        tableView.getItems().setAll(ci.allBooks());
        addButtonToTable();
    }
    
    
    private void addButtonToTable() {
        TableColumn<Book, Void> colBtn = new TableColumn("Actions");

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
                            
                            Optional<ButtonType> option = alert.showAndWait();
                       
                            if (option.get() == ButtonType.OK) {
                            	System.out.println("File deleted!");
                            	data.addCopy();
                            	da.saveBook(data);
                            	tableView.getItems().clear();
                            	tableView.getItems().setAll(ci.allBooks());	
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