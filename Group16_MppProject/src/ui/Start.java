package ui;

import javafx.application.Application;
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

public class Start extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	private static Stage primStage = null;

	public static Stage primStage() {
		return primStage;
	}

	public static class Colors {
		static Color green = Color.web("#034220");
		static Color red = Color.FIREBRICK;
	}

	private static Stage[] allWindows = { LoginWindow.INSTANCE, AllMembersWindow.INSTANCE, AllBooksWindow.INSTANCE,
			MainWindow.INSTANCE };

	public static void hideAllWindows() {
		primStage.hide();
		for (Stage st : allWindows) {
			st.hide();
		}
	}

	@Override
	public void start(Stage primaryStage) {

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
		grid.add(userTextField, 1, 1);

		Label pw = new Label("Password:");
		grid.add(pw, 0, 2);
		grid.setGridLinesVisible(false);

		PasswordField pwBox = new PasswordField();
		grid.add(pwBox, 1, 2);

		Button loginBtn = new Button("Log in");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(loginBtn);
		grid.add(hbBtn, 1, 4);

//        HBox messageBox = new HBox(10);
//        messageBox.setAlignment(Pos.BOTTOM_RIGHT);
//        messageBox.getChildren().add(messageBar);;
//        grid.add(messageBox, 1, 6);
//        
//        loginBtn.setOnAction(new EventHandler<ActionEvent>() {
//        	@Override
//        	public void handle(ActionEvent e) {
//        		try {
//        			ControllerInterface c = new SystemController();
//        			c.login(userTextField.getText().trim(), pwBox.getText().trim());
//        			messageBar.setFill(Start.Colors.green);
//             	    messageBar.setText("Login successful");
//        		} catch(LoginException ex) {
//        			messageBar.setFill(Start.Colors.red);
//        			messageBar.setText("Error! " + ex.getMessage());
//        		}
//        	   
//        	}
//        });
//
//        Button backBtn = new Button("<= Back to Main");
//        backBtn.setOnAction(new EventHandler<ActionEvent>() {
//        	@Override
//        	public void handle(ActionEvent e) {
//        		Start.hideAllWindows();
//        		Start.primStage().show();
//        	}
//        });
//        HBox hBack = new HBox(10);
//        hBack.setAlignment(Pos.BOTTOM_LEFT);
//        hBack.getChildren().add(backBtn);
//        grid.add(hBack, 0, 7);
		Scene scene = new Scene(grid);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

}
