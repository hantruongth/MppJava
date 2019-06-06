package ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import business.Address;
import business.ControllerInterface;
import business.LibraryMember;
import business.SystemController;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;


public class AddMemberWindow extends Stage implements LibWindow{

	public static final AddMemberWindow INSTANCE = new AddMemberWindow();
	private TableView<LibraryMember> tableMemberView = new TableView<LibraryMember>();
	TextField memberIDTextField;
	TextField firstNameTextField;
	TextField lastNameTextField;
	TextField streetTextField;
	TextField cityTextField;
	TextField stateTextField;
	TextField zipCodeTextField;
	TextField telePhoneTextField;

	private boolean isInitialized = false;
	private ControllerInterface c = new SystemController();
	public boolean isInitialized() {
		return isInitialized;
	}
	public void isInitialized(boolean val) {
		isInitialized = val;
	}
	
	public void setData(ObservableList<LibraryMember> prods) {
		tableMemberView.setItems(prods);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void init() {
		
		this.setTitle("Admin - Add Member");
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(5);
		grid.setVgap(5);
		grid.setPadding(new Insets(15, 15, 15, 15));

		Text label = new Text("Add LibraryMember");
		label.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 30));
		label.setFill(Color.DARKRED);
		HBox labelBox = new HBox(10);
		labelBox.setAlignment(Pos.CENTER);
		labelBox.getChildren().add(label);
		int row = 1;
		grid.add(labelBox, 0, 0, 2, row);

		Label isbnLabel = new Label("Member ID:");
		grid.add(isbnLabel, 0, 1);

		memberIDTextField = new NumberTextField();
		grid.add(memberIDTextField, 1, row);

		row++;
		Label firstNameLabel = new Label("First Name:");
		grid.add(firstNameLabel, 0, row);

		firstNameTextField = new TextField();
		grid.add(firstNameTextField, 1, row);
		
		row++;
		Label lastNameLabel = new Label("Last Name:");
		grid.add(lastNameLabel, 0, row);

		lastNameTextField = new TextField();
		grid.add(lastNameTextField, 1, row);
		
		row++;
		Label streetLabel = new Label("Street:");
		grid.add(streetLabel, 0, row);

		streetTextField = new TextField();
		grid.add(streetTextField, 1, row);
		
		row++;
		Label cityLabel = new Label("City:");
		grid.add(cityLabel, 0, row);

		cityTextField = new TextField();
		grid.add(cityTextField, 1, row);
		
		row++;
		Label stateLabel = new Label("State:");
		grid.add(stateLabel, 0, row);

		stateTextField = new TextField();
		grid.add(stateTextField, 1, row);
		
		row++;//7
		Label zipCodeLabel = new Label("Zip Code:");
		grid.add(zipCodeLabel, 0, row);

		zipCodeTextField = new NumberTextField();		
		grid.add(zipCodeTextField, 1, row);
		
		row++;//8
		Label telephoneLabel = new Label("Telephone:");
		grid.add(telephoneLabel, 0, row);

		telePhoneTextField = new NumberTextField();
		grid.add(telePhoneTextField, 1, row);
		
		Button saveBtn = new Button("Save");
		saveBtn.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent e) {
        		Address add = new Address(streetTextField.getText().trim(), cityTextField.getText().trim(), stateTextField.getText().trim(), zipCodeTextField.getText().trim());
        		LibraryMember newMember = new LibraryMember(memberIDTextField.getText().trim(), firstNameTextField.getText().trim(), lastNameTextField.getText().trim(), telePhoneTextField.getText().trim(), add);
        		addNewMember(newMember);
        		bindMemberToList(getLibraryMember());
        	}
        });
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(saveBtn);
		row++;//9
		grid.add(hbBtn, 1, row);
		
		HBox righttBox = new HBox(10);
		righttBox.setAlignment(Pos.TOP_RIGHT);
		
		Label membersLabel = new Label("Members:");
		righttBox.getChildren().add(membersLabel);
		
		TableColumn<LibraryMember, String> memberIDCol = new TableColumn<>("Member ID");
		memberIDCol.setMinWidth(150);
		memberIDCol.setCellValueFactory(new PropertyValueFactory<LibraryMember, String>("memberId"));
		memberIDCol.setCellFactory(TextFieldTableCell.forTableColumn());
		
		TableColumn<LibraryMember, String> memberFirstNameCol = new TableColumn<>("First Name");
		memberFirstNameCol.setMinWidth(150);
		memberFirstNameCol.setCellValueFactory(new PropertyValueFactory<LibraryMember, String>("firstName"));
		memberFirstNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
		
		TableColumn<LibraryMember, String> memberLastNameCol = new TableColumn<>("Last Name");
		memberLastNameCol.setMinWidth(150);
		memberLastNameCol.setCellValueFactory(new PropertyValueFactory<LibraryMember, String>("lastName"));
		memberLastNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
		
		TableColumn<LibraryMember, String> telephoneCol = new TableColumn<>("Telephone");
		telephoneCol.setMinWidth(150);
		telephoneCol.setCellValueFactory(new PropertyValueFactory<LibraryMember, String>("telephone"));
		telephoneCol.setCellFactory(TextFieldTableCell.forTableColumn());
		
		tableMemberView.getColumns().clear();
		tableMemberView.getColumns().addAll(memberIDCol, memberFirstNameCol, memberLastNameCol, telephoneCol);
		
		righttBox.getChildren().add(tableMemberView);
		row++;//10
		grid.add(tableMemberView, 1, row);
		
		tableMemberView.setOnMouseClicked((MouseEvent event) -> {
	        if(event.getButton().equals(MouseButton.PRIMARY)){
	        	doSelectMember();
	        }
	    });
		tableMemberView.setOnKeyReleased(new EventHandler<KeyEvent>() {
	        @Override
	        public void handle(KeyEvent ke)
	        {
	            if (ke.getCode().equals(KeyCode.UP) || ke.getCode().equals(KeyCode.DOWN)) {
		            doSelectMember();
	            }
	        }
	    });
		this.bindMemberToList(getLibraryMember());
		
		Screen screen = Screen.getPrimary();
		Rectangle2D bounds = screen.getVisualBounds();

		Scene scene = new Scene(grid, bounds.getWidth()*0.5, bounds.getHeight()*0.955);
        setScene(scene);
        //setMaximized(true);
	}
	private List<LibraryMember> getLibraryMember() {
		
		return c.allLibraryMembers();

	}
	private void bindMemberToList(List<LibraryMember> members) {
		this.tableMemberView.getItems().clear();
		this.tableMemberView.getItems().setAll(members);
	}
	private void addNewMember(LibraryMember newMember) {
		if(newMember.getMemberId().isEmpty())
			return;

		c.addLibraryMember(newMember);
	}
	private void doSelectMember() {
		LibraryMember selMember = tableMemberView.getSelectionModel().getSelectedItem();
        memberIDTextField.setText(selMember.getMemberId());
        firstNameTextField.setText(selMember.getFirstName());
        lastNameTextField.setText(selMember.getLastName());
        streetTextField.setText(selMember.getAddress().getStreet());
        cityTextField.setText(selMember.getAddress().getCity());
        stateTextField.setText(selMember.getAddress().getState());
        zipCodeTextField.setText(selMember.getAddress().getZip());
        telePhoneTextField.setText(selMember.getTelephone());
	}
}
