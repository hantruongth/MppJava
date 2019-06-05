package ui;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
		panel.setPrefWidth(800);

		TextArea textarea = new TextArea();
		textarea.setLayoutX(5);
		textarea.setLayoutY(15);

		textarea.setPrefHeight(575);
		textarea.setPrefWidth(795);

		
	
		Map<LocalDate, List<CheckoutEntry>> checkoutEntries = ci.getCheckoutEntries(member);
		
		StringBuilder sb = new StringBuilder();
		sb.append("ID: ").append(member.getMemberId()).append("\n");
		sb.append("Member name: ").append(member.getFirstName()).append(" ").append(member.getLastName()).append("\n");
		sb.append("Checkout Details:\n");
		
		for(Entry<LocalDate, List<CheckoutEntry>> entry: checkoutEntries.entrySet()) {
			sb.append("  + ").append(entry.getKey()).append("\n");
			List<CheckoutEntry> entries = entry.getValue();
			for (CheckoutEntry checkoutEntry : entries) {
				sb.append("        - ").append(checkoutEntry.toString());
				sb.append("\n");
				
			}
			sb.append("\n");
			
		}
		textarea.setText(sb.toString());
		panel.getChildren().add(textarea);

		Scene scene = new Scene(panel);

		setScene(scene);

	}

	public void setValue(LibraryMember member) {
		this.member = member;
	}

}
