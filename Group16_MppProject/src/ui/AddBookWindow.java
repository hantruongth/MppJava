package ui;

import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import business.Author;
import business.Book;
import business.ControllerInterface;
import business.SystemController;
import business.constant.Constants;
import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class AddBookWindow extends Stage implements LibWindow{

public static final AddBookWindow INSTANCE = new AddBookWindow();
private TableView<Author> tableAuthorView = new TableView<Author>();

	private boolean isInitialized = false;
	public boolean isInitialized() {
		return isInitialized;
	}
	public void isInitialized(boolean val) {
		isInitialized = val;
	}
	
	public void setData(ObservableList<Author> prods) {
		tableAuthorView.setItems(prods);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void init() {
		
		this.setTitle("LibrarySystem Add book");
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		Text label = new Text("Add book");
		label.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 30));
		label.setFill(Color.DARKRED);
		HBox labelBox = new HBox(10);
		labelBox.setAlignment(Pos.CENTER);
		labelBox.getChildren().add(label);
		grid.add(labelBox, 0, 0, 2, 1);

		Label isbnLabel = new Label("ISBN number:");
		grid.add(isbnLabel, 0, 1);

		TextField isbnTextField = new TextField();
		grid.add(isbnTextField, 1, 1);

		
		Label titleLabel = new Label("Title:");
		grid.add(titleLabel, 0, 2);

		TextField titleTextField = new TextField();
		grid.add(titleTextField, 1, 2);
		
		
		Label checkoutLengthLabel = new Label("Max. checkout length:");
		grid.add(checkoutLengthLabel, 0, 3);

		TextField checkoutLengthTextField = new TextField();
		grid.add(checkoutLengthTextField, 1, 3);
		
		
		Label nbOfCopiesLabel = new Label("Number of copy:");
		grid.add(nbOfCopiesLabel, 0, 4);

		TextField nbCopiesTextField = new TextField();
		grid.add(nbCopiesTextField, 1, 4);
		
		Label authorLabel = new Label("Authors:");
		grid.add(authorLabel, 0, 5);

		
		TableColumn<Author, String> authortFirstNameCol = new TableColumn<>("First name");
		authortFirstNameCol.setMinWidth(150);
		authortFirstNameCol.setCellValueFactory(new PropertyValueFactory<Author, String>("firstName"));
		authortFirstNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
		
		TableColumn<Author, String> authortLastNameCol = new TableColumn<>("Last name");
		authortLastNameCol.setMinWidth(150);
		authortLastNameCol.setCellValueFactory(new PropertyValueFactory<Author, String>("firstName"));
		authortLastNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
		
		
		TableColumn<Author, String> authorPhoneNameCol = new TableColumn<>("Phone");
		authorPhoneNameCol.setMinWidth(150);
		authorPhoneNameCol.setCellValueFactory(new PropertyValueFactory<Author, String>("telephone"));
		authorPhoneNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
		
		tableAuthorView.getColumns().clear();
		tableAuthorView.getColumns().addAll(authortFirstNameCol, authortLastNameCol, authorPhoneNameCol);
		grid.add(tableAuthorView, 1, 5);
		
		Button saveBtn = new Button("Save");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(saveBtn);
		grid.add(hbBtn, 1, 6);
		
		Scene scene = new Scene(grid);
	
        setScene(scene);
        
        this.bindAuthorToList();
        
        saveBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				String isbn = isbnTextField.getText();
				String title = titleTextField.getText();
				String maxCheckoutLengthString = checkoutLengthTextField.getText();
				
				if(isbn.equals("") || title.equals("") || maxCheckoutLengthString.equals("")) {
					showErrorMessage("Please input all fields");
					return;
				}
				
				int maxLength = Constants.MAX_DAY_BOOK_BORROWING;
				if(maxCheckoutLengthString != null)
				{
					try {
						maxLength = Integer.parseInt(maxCheckoutLengthString);
					}catch (NumberFormatException e) {
						showErrorMessage("Max. Checkout Length is the number");
						return;
					}
					
				}
				String numberOfCopiesString = nbCopiesTextField.getText();
				int nbOfcopy = 1;
				if(numberOfCopiesString != null)
					nbOfcopy = Integer.parseInt(numberOfCopiesString);
				
				ControllerInterface c = new SystemController();
				Book book = new Book(isbn, title, maxLength, new ArrayList<>());
				for(int i=0; i< nbOfcopy; i++)
					book.addCopy();
				c.addBook(book);
				
				
				
			}
		});
        
        
		
	}
	
	private void showErrorMessage(String errorMsg) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Input error");
		alert.setHeaderText(errorMsg);
		alert.show();
	}
	

	private void bindAuthorToList() {
		ControllerInterface c = new SystemController();
		this.tableAuthorView.getItems().clear();
		this.tableAuthorView.getItems().setAll(c.allAuthors());
	}

}
