package mum.project.group16;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainWindow extends Stage {

	public static final MainWindow INSTANCE = new MainWindow();

	private MainWindow() {
	}

	public void setStage(Stage primaryStage) {
		primaryStage.setTitle("Library System Home");
		
		VBox topContainer = new VBox();
		
		MenuBar mainMenu = new MenuBar();
		Text label = new Text("Welcome to Library System");
		label.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 30));
		label.setFill(Color.DARKRED);
		HBox labelBox = new HBox(10);
		labelBox.setAlignment(Pos.CENTER);
		labelBox.getChildren().add(label);
		
		topContainer.getChildren().add(mainMenu);
		topContainer.getChildren().add(labelBox);

		Menu bookMenu = new Menu("Book management");
		
		
		MenuItem addBookMenu = new MenuItem("Add book");
		addBookMenu.setOnAction(e->showAddBookWindow(primaryStage));
		
		//addBookMenu.setOnAction(e->showAddMemberWindow(primaryStage));
		
		
		MenuItem printCheckoutRecordMenu = new MenuItem("Print checkout record");
		printCheckoutRecordMenu.setOnAction(e->showPrintCheckoutRecord(primaryStage));
		
		MenuItem overdueMenu = new MenuItem("Show overdue copy");
		overdueMenu.setOnAction(e->showShowOverdue(primaryStage));
		
		MenuItem checkoutBook = new MenuItem("Checkout a book");
		checkoutBook.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				
				// TODO Auto-generated method stub
				
			}
		});
		MenuItem exitApp = new MenuItem("Exit");
		exitApp.setOnAction(evt -> Platform.exit());
			
		bookMenu.getItems().addAll(addBookMenu, printCheckoutRecordMenu, overdueMenu, checkoutBook, exitApp);

		Menu memberMenu = new Menu("Member");
		MenuItem addMemberMenu = new MenuItem("Add a new member");
		addMemberMenu.setOnAction(evt -> {showAddMemberWindow(primaryStage);});
		memberMenu.getItems().add(addMemberMenu);
		
		Menu adminMenu = new Menu("Administrator");
		MenuItem addCopyOfBook = new MenuItem("Add a copy of book");
		addCopyOfBook.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				
			}
		});
		adminMenu.getItems().addAll(addCopyOfBook);
		
		mainMenu.getMenus().addAll(bookMenu, memberMenu, adminMenu);

		setScene(new Scene(topContainer, 500, 200));
		primaryStage.show();

	}

	private void showShowOverdue(Stage primaryStage) {
		
	}

	private void showPrintCheckoutRecord(Stage primaryStage) {
	}

	private void showAddBookWindow(Stage primaryStage) {
		
		
	}

	private void showAddMemberWindow(Stage stage) {
		MemberAddWindow memberAddWindow = MemberAddWindow.INSTANCE;
		memberAddWindow.setStage(stage);
		// memberAddWindow.setData(DefaultData.CATALOG_LIST_DATA);
		memberAddWindow.show();
		stage.hide();
	}
}
