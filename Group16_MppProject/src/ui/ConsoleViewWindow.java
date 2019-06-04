package ui;

import business.ControllerInterface;
import business.SystemController;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ConsoleViewWindow extends Stage implements LibWindow {
	public static final ConsoleViewWindow INSTANCE = new ConsoleViewWindow();
	private String memberId;
	private boolean isInitialized = false;

	public boolean isInitialized() {
		return isInitialized;
	}

	public void isInitialized(boolean val) {
		isInitialized = val;
	}

	public void setData(String memberId) {

	}

	@Override
	public void init() {
		
		ControllerInterface ci = new SystemController();
		AnchorPane panel = new AnchorPane();
		panel.setPrefHeight(580);
		panel.setPrefWidth(600);

		TextArea textarea = new TextArea();
		textarea.setLayoutX(5);
		textarea.setLayoutY(15);

		textarea.setPrefHeight(575);
		textarea.setPrefWidth(595);

		textarea.setText("han truong");
		
		
		
		panel.getChildren().add(textarea);

		Scene scene = new Scene(panel);

		setScene(scene);

	}

	public void setValue(String memberId) {
		this.memberId = memberId;
	}

}
