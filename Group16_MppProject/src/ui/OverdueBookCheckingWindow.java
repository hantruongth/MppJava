package ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import business.CheckoutEntry;
import business.ControllerInterface;
import business.LibraryMember;
import business.SystemController;
import business.dto.MemberBookEntryDto;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class OverdueBookCheckingWindow extends Stage implements LibWindow {
	public static final OverdueBookCheckingWindow INSTANCE = new OverdueBookCheckingWindow();
	private TableView<MemberBookEntryDto> tableOverdueView = new TableView<MemberBookEntryDto>();
	private boolean isInitialized = false;

	public boolean isInitialized() {
		return isInitialized;
	}

	public void isInitialized(boolean val) {
		isInitialized = val;

	}

	@SuppressWarnings("unchecked")
	@Override
	public void init() {
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

		Label iSBNLabel = new Label("ISBN:");
		grid.add(iSBNLabel, 0, 1);

		TextField isbnTextField = new TextField();
		grid.add(isbnTextField, 1, 1);

		Button searchBookBtn = new Button("Overdue search");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(searchBookBtn);
		grid.add(hbBtn, 1, 2);

		TableColumn<MemberBookEntryDto, String> isbnCol = new TableColumn<>("ISBN");
		isbnCol.setMinWidth(150);
		isbnCol.setCellValueFactory(new PropertyValueFactory<MemberBookEntryDto, String>("isbn"));

		TableColumn<MemberBookEntryDto, String> titleCol = new TableColumn<>("Title");
		titleCol.setMinWidth(150);
		titleCol.setCellValueFactory(new PropertyValueFactory<MemberBookEntryDto, String>("bookTitle"));

		TableColumn<MemberBookEntryDto, Integer> nbCopyCol = new TableColumn<>("#Copies");
		nbCopyCol.setMinWidth(150);
		nbCopyCol.setCellValueFactory(new PropertyValueFactory<MemberBookEntryDto, Integer>("numberOfCopies"));

		TableColumn<MemberBookEntryDto, String> dueDateCol = new TableColumn<>("Due Date");
		dueDateCol.setMinWidth(150);
		dueDateCol.setCellValueFactory(new PropertyValueFactory<MemberBookEntryDto, String>("dueDate"));

		TableColumn<MemberBookEntryDto, String> memberIDCol = new TableColumn<>("Member ID");
		memberIDCol.setMinWidth(150);
		memberIDCol.setCellValueFactory(new PropertyValueFactory<MemberBookEntryDto, String>("memberId"));

		TableColumn<MemberBookEntryDto, String> memberFirstNameCol = new TableColumn<>("First name");
		memberFirstNameCol.setMinWidth(150);
		memberFirstNameCol.setCellValueFactory(new PropertyValueFactory<MemberBookEntryDto, String>("memberFirstName"));

		TableColumn<MemberBookEntryDto, String> memberLastNameCol = new TableColumn<>("First name");
		memberLastNameCol.setMinWidth(150);
		memberLastNameCol.setCellValueFactory(new PropertyValueFactory<MemberBookEntryDto, String>("memberLastName"));

		tableOverdueView.getColumns().clear();
		tableOverdueView.getColumns().addAll(isbnCol, titleCol, nbCopyCol, dueDateCol, memberIDCol, memberFirstNameCol,
				memberLastNameCol);
		grid.add(tableOverdueView, 1, 3);

		Scene scene = new Scene(grid);

		setScene(scene);

		searchBookBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				String isbn = isbnTextField.getText();
				if (isbn != null && !isbn.isEmpty()) {
					ControllerInterface ci = new SystemController();
					Map<LibraryMember, List<CheckoutEntry>> memberChecoutEntryMap = ci.getCheckoutEntryList(isbn);
					List<MemberBookEntryDto> memberBookEntryOverdueList = new ArrayList<MemberBookEntryDto>();
					for (Entry<LibraryMember, List<CheckoutEntry>> entry : memberChecoutEntryMap.entrySet()) {

						List<CheckoutEntry> checkoutEntries = entry.getValue();

						for (CheckoutEntry checkout : checkoutEntries) {
							memberBookEntryOverdueList.add(new MemberBookEntryDto(entry.getKey(), checkout));
						}
					}
					tableOverdueView.getItems().clear();
					tableOverdueView.getItems().setAll(memberBookEntryOverdueList);

				} else {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Input error");
					alert.setHeaderText("Please input ISBN to search");
					alert.show();

				}

			}
		});

	}

}
