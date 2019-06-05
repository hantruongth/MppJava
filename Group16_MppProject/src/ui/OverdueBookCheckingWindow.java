package ui;

import business.Book;
import business.ControllerInterface;
import business.SystemController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
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

public class OverdueBookCheckingWindow extends Stage implements LibWindow {
	public static final OverdueBookCheckingWindow INSTANCE = new OverdueBookCheckingWindow();
	private TableView<Book> tableMemberView = new TableView<Book>();
	private boolean isInitialized = false;

	public boolean isInitialized() {
		return isInitialized;
	}

	public void isInitialized(boolean val) {
		isInitialized = val;

	}

	@Override
	public void init() {

		ControllerInterface c = new SystemController();
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		Text label = new Text("Search book and check overdue");
		label.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 30));
		label.setFill(Color.DARKRED);
		HBox labelBox = new HBox(10);
		labelBox.setAlignment(Pos.CENTER);
		labelBox.getChildren().add(label);
		grid.add(labelBox, 0, 0, 2, 1);

		Label iSBNLabel = new Label("Member Id:");
		grid.add(iSBNLabel, 0, 1);

		TextField memberIdTextField = new TextField();
		grid.add(memberIdTextField, 1, 1);

		Button searchBookBtn = new Button("Overdue search");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(searchBookBtn);
		grid.add(hbBtn, 1, 2);

		TableColumn<Book, String> isbnCol = new TableColumn<>("ISBN");
		isbnCol.setMinWidth(150);
		isbnCol.setCellValueFactory(new PropertyValueFactory<Book, String>("isbn"));
		isbnCol.setCellFactory(TextFieldTableCell.forTableColumn());

		TableColumn<Book, String> titleCol = new TableColumn<>("Title");
		titleCol.setMinWidth(150);
		titleCol.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));
		titleCol.setCellFactory(TextFieldTableCell.forTableColumn());

		TableColumn<Book, String> nbCopyCol = new TableColumn<>("#Copies");
		nbCopyCol.setMinWidth(150);
		nbCopyCol.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));
		nbCopyCol.setCellFactory(TextFieldTableCell.forTableColumn());

		tableMemberView.getColumns().clear();
		//tableMemberView.getColumns().addAll(memberIdCol, memberFirstNameCol, memberLastNameCol);
		grid.add(tableMemberView, 1, 3);

		// this.bindMemberToList(c.getAllLibraryMember());

		Text printToConsoleLabel = new Text("Hint: Double click on member to print checkout details");
		printToConsoleLabel.setFill(Color.RED);
		grid.add(printToConsoleLabel, 1, 4);

		Scene scene = new Scene(grid);

		setScene(scene);

		searchMemberBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				String memberId = memberIdTextField.getText();
				if (memberId != null && !memberId.isEmpty()) {
					// bindMemberToList(c.getLibraryMember(memberId));
				} else {
					// bindMemberToList(c.getAllLibraryMember());

				}

			}
		});

		tableMemberView.setRowFactory(tv -> {
			TableRow<Book> row = new TableRow<>();
			row.setOnMouseClicked(event -> {
				if (event.getClickCount() == 2 && (!row.isEmpty())) {
//    	        	Book member = row.getItem();
//    	        	ConsoleViewWindow.INSTANCE.setValue(member);
//    	        	ConsoleViewWindow.INSTANCE.init();
//    				ConsoleViewWindow.INSTANCE.show();
				}
			});
			return row;
		});

	}

}
