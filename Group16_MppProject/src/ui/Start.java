package ui;

import business.*;
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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Start extends Application {
	public static void main(String[] args) {
		launch(args);
	}
	private Text messageBar = new Text();
	public void clear() {
		messageBar.setText("");
	}
	private static Stage primStage = null;

	public static Stage primStage() {
		return primStage;
	}

	public static class Colors {
		static Color green = Color.web("#034220");
		static Color red = Color.FIREBRICK;
	}

	private static Stage[] allWindows = { AllMembersWindow.INSTANCE, AllBooksWindow.INSTANCE,
			MainWindow.INSTANCE, AddBookWindow.INSTANCE, PrintCheckoutRecordWindow.INSTANCE };

	public static void hideAllWindows() {
		primStage.hide();
		for (Stage st : allWindows) {
			st.hide();
		}
	}

	@Override
	public void start(Stage primaryStage) {
		primStage = primaryStage;
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

		Label userName = new Label("User Name:");
		grid.add(userName, 0, 1);

		TextField userTextField = new TextField();
		userTextField.setText("both");
		grid.add(userTextField, 1, 1);

		Label pw = new Label("Password:");
		grid.add(pw, 0, 2);
		grid.setGridLinesVisible(false);

		PasswordField pwBox = new PasswordField();
		pwBox.setText("123456");
		grid.add(pwBox, 1, 2);

		Button loginBtn = new Button("Log in");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(loginBtn);
		grid.add(hbBtn, 1, 4);

        HBox messageBox = new HBox(10);
        messageBox.setAlignment(Pos.BOTTOM_RIGHT);
        messageBox.getChildren().add(messageBar);;
        grid.add(messageBox, 1, 6);
        
        loginBtn.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent e) {
        		doLogin(userTextField.getText().trim(), pwBox.getText().trim());
        	}
        });
        userTextField.setOnKeyPressed(new EventHandler<KeyEvent>() {
	        @Override
	        public void handle(KeyEvent ke)
	        {
	            if (ke.getCode().equals(KeyCode.ENTER)) {
	            	doLogin(userTextField.getText().trim(), pwBox.getText().trim());
	            }
	        }
	    });
        pwBox.setOnKeyPressed(new EventHandler<KeyEvent>() {
	        @Override
	        public void handle(KeyEvent ke)
	        {
	            if (ke.getCode().equals(KeyCode.ENTER)) {
	            	doLogin(userTextField.getText().trim(), pwBox.getText().trim());
	            }
	        }
	    });

        
		Scene scene = new Scene(grid);
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	public void doLogin(String id, String pw) {
		try {
			ControllerInterface c = new SystemController();
			c.login(id, pw);
			messageBar.setFill(Start.Colors.green);
     	    messageBar.setText("Login successful");
     	   backToMain();
		} catch(LoginException ex) {
			messageBar.setFill(Start.Colors.red);
			messageBar.setText("Error! " + ex.getMessage());
		}
	}
	public static void backToMain() {
		hideAllWindows();
		if(!MainWindow.INSTANCE.isInitialized()) {
			MainWindow.INSTANCE.init();
		}
		MainWindow.INSTANCE.clear();
		MainWindow.INSTANCE.show();
	}
}
