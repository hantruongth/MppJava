package mum.project.group16;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import mum.project.group16.constant.Constants;

public class Start extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("LibrarySystem Welcome");
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		Text label = new Text("LibrarySystem Login");
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

		Label passwordLabel = new Label("Password:");
		grid.add(passwordLabel, 0, 2);

		PasswordField passwordField = new PasswordField();
		grid.add(passwordField, 1, 2);

		Button btn = new Button("Sign in");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btn);
		grid.add(hbBtn, 1, 4);

		final Text actiontarget = new Text();
		actiontarget.setFill(Color.RED);
		grid.add(actiontarget, 1, 6);
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {

				String username = userNameTextField.getText();
				String password = passwordField.getText();

				if (username.isEmpty() || password.isEmpty()) {
					actiontarget.setText("Username and password are required");
					return;
				}

				// TODO: handle login with role

				if (username.equalsIgnoreCase(Constants.USER_ADMIN) && password.equals(Constants.DEFAULT_PASSWORD)) {
					// TODO: handle login with Admin

					showMainWindow(primaryStage);

				} else if (username.equalsIgnoreCase(Constants.USER_LIBRARIAN) && password.equals(Constants.DEFAULT_PASSWORD)) {
					// TODO: login with librarian

					showMainWindow(primaryStage);

				} else
					actiontarget.setText("Login failed.");

			}
		});

		Scene scene = new Scene(grid, 400, 300);
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	
	private void showMainWindow(Stage stage) {
		MainWindow memberAddWindow = MainWindow.INSTANCE;
		memberAddWindow.setStage(stage);
		// memberAddWindow.setData(DefaultData.CATALOG_LIST_DATA);
		memberAddWindow.show();
		stage.hide();
	}



}
