package ui;

import java.util.List;

import business.CheckoutEntry;
import business.ControllerInterface;
import business.LibraryMember;
import business.SystemController;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ConsoleViewWindow extends Stage implements LibWindow {
	public static final ConsoleViewWindow INSTANCE = new ConsoleViewWindow();
	private LibraryMember member;
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

		
	
		List<CheckoutEntry> checkoutEntries = ci.getCheckoutEntries(member);
		
		//textarea.setText(checkoutEntries.toString());
		
		panel.getChildren().add(textarea);

		Scene scene = new Scene(panel);

		setScene(scene);

	}

	public void setValue(LibraryMember member) {
		this.member = member;
	}

}
