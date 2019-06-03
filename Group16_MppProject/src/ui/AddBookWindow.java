package ui;

import business.Author;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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

		
		TableColumn<Author, String> authortNameCol 
		  = new TableColumn<>("Author");
		authortNameCol.setMinWidth(250);
		authortNameCol.setCellValueFactory(new PropertyValueFactory<Author, String>("firstName"));
		authortNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
		
		tableAuthorView.getColumns().addAll(authortNameCol);
		grid.add(tableAuthorView, 1, 5);
		
		Button loginBtn = new Button("Save");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(loginBtn);
		grid.add(hbBtn, 1, 6);
		
		Scene scene = new Scene(grid);
	
        setScene(scene);
		
	}

}
