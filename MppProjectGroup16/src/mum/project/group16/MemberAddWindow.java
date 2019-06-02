package mum.project.group16;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MemberAddWindow extends Stage {
	public static final MemberAddWindow INSTANCE = new MemberAddWindow();
	Stage primaryStage;
	
	private MemberAddWindow() {
	}

	public void setStage(Stage ps) {
		this.primaryStage = ps;
		
		setTitle("LibrarySystem - Add a member");
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		
		Text label = new Text("Add member");
		label.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 30));
		label.setFill(Color.DARKRED);
		HBox labelBox = new HBox(10);
		labelBox.setAlignment(Pos.CENTER);
		labelBox.getChildren().add(label);
		grid.add(labelBox, 0, 0, 2, 1);

		Label userNameLabel = new Label("User Name:");
		grid.add(userNameLabel, 0, 1);
		TextField userNameTextField = new TextField();
		grid.add(userNameTextField, 1, 1);
		
		Label firstNameLabel = new Label("First Name:");
		grid.add(firstNameLabel, 0, 2);
		TextField firstNameTextField = new TextField();
		grid.add(firstNameTextField, 1, 2);
		
		Label lastNameLabel = new Label("Last Name:");
		grid.add(lastNameLabel, 0, 3);
		TextField lastNameTextField = new TextField();
		grid.add(lastNameTextField, 1, 3);

		Label streetLabel = new Label("Street:");
		grid.add(streetLabel, 0, 4);
		TextField streetTextField = new TextField();
		grid.add(streetTextField, 1, 4);
		
		Label stateLabel = new Label("State:");
		grid.add(stateLabel, 0, 5);
		TextField stateTextField = new TextField();
		grid.add(stateTextField, 1, 5);
		
		Label cityLabel = new Label("City:");
		grid.add(cityLabel, 0, 6);
		TextField cityTextField = new TextField();
		grid.add(cityTextField, 1, 6);
		
		Label phoneLabel = new Label("Phone:");
		grid.add(phoneLabel, 0, 7);
		TextField phoneTextField = new TextField();
		grid.add(phoneTextField, 1, 7);
		
		
		Button btnCancel = new Button("Cancel");
		HBox hbBtnCancel = new HBox(10);
		hbBtnCancel.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtnCancel.getChildren().add(btnCancel);
		grid.add(hbBtnCancel, 0, 8);
		
		btnCancel.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				MemberAddWindow.INSTANCE.hide();
				
			}
			
		});
		
		
		Button btn = new Button("Save");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btn);
		grid.add(hbBtn, 1, 8);
		
		btn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				String username = userNameTextField.getText();
				String firstName = firstNameTextField.getText();
				String lastName = lastNameTextField.getText();
				String street = streetTextField.getText();
				String state = stateTextField.getText();
				String city = cityTextField.getText();
				String phone = phoneTextField.getText();
				
				//TODO: handel saving
				
				
				
				
				
			}
		});
		
		
		Scene scene = new Scene(grid, 400, 400);
		setScene(scene);

		//this.primaryStage.show();
		
	}

}
