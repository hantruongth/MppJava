package ui;

import business.Author;
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

public class PrintCheckoutRecordWindow extends Stage implements LibWindow{
	public static final PrintCheckoutRecordWindow INSTANCE = new PrintCheckoutRecordWindow();
	private TableView<Author> tableMemberView = new TableView<Author>();
	private boolean isInitialized = false;
	public boolean isInitialized() {
		return isInitialized;
	}
	public void isInitialized(boolean val) {
		isInitialized = val;
	}
	@Override
	public void init() {
		this.setTitle("LibrarySystem Print Checkout Record");
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		Text label = new Text("Search member and print checkout records");
		label.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 30));
		label.setFill(Color.DARKRED);
		HBox labelBox = new HBox(10);
		labelBox.setAlignment(Pos.CENTER);
		labelBox.getChildren().add(label);
		grid.add(labelBox, 0, 0, 2, 1);
		
		
		Label memberIdLabel = new Label("Member Id:");
		grid.add(memberIdLabel, 0, 1);

		TextField memberIdTextField = new TextField();
		grid.add(memberIdTextField, 1, 1);
		
		Button searchMemberBtn = new Button("Search member");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(searchMemberBtn);
		grid.add(hbBtn, 1, 2);
		
		
		TableColumn<Author, String> memberFirstNameCol = new TableColumn<>("First name");
		memberFirstNameCol.setMinWidth(150);
		memberFirstNameCol.setCellValueFactory(new PropertyValueFactory<Author, String>("firstName"));
		memberFirstNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
		
		TableColumn<Author, String> memberLastNameCol = new TableColumn<>("Last name");
		memberLastNameCol.setMinWidth(150);
		memberLastNameCol.setCellValueFactory(new PropertyValueFactory<Author, String>("firstName"));
		memberLastNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
		
		tableMemberView.getColumns().clear();
		tableMemberView.getColumns().addAll(memberFirstNameCol, memberLastNameCol);
		grid.add(tableMemberView, 1, 3);
		

		Button printToConsoleBtn = new Button("Print to console");
		HBox hbBtnPrint = new HBox(10);
		hbBtnPrint.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtnPrint.getChildren().add(printToConsoleBtn);
		grid.add(hbBtnPrint, 1, 4);
		
		Scene scene = new Scene(grid);
	
        setScene(scene);
		
		
	}
	
}
