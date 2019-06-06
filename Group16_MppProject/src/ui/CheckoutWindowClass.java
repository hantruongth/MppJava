package ui;


import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import business.Book;
import business.BookCopy;
import business.CheckoutRecord;
import business.ControllerInterface;
import business.LibraryMember;
import business.MemberCheckoutsFactory;
import business.SystemController;
import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;


public class CheckoutWindowClass  implements Initializable{

	//Connect your UI ids from Java SceneBuilder
	@FXML
    private TableView<Book> tableView;
	
	@FXML
	private ComboBox<LibraryMember> membersComboBox = new ComboBox<LibraryMember>();
    private ArrayList<Book> books = new ArrayList<Book>();
    private List<LibraryMember> members = new ArrayList<LibraryMember>();
    
	
	@FXML
	private Button btnAccept = new Button();
	
	@FXML
	private Button btnCancel;
	
	@FXML
	private Label lblError = new Label();
	
	@FXML
	private VBox vb;
	
	@FXML
	private ScrollPane scrollPanelBooks = new ScrollPane();
	
	public ObservableList<Book> selectedIDs;
	
	public CheckoutWindowClass(
			ArrayList<Book> selectedIDs,
			List<LibraryMember> membersList,
			TableView<Book> table) {
		
		books = selectedIDs;
		members = membersList;
		tableView = table;
    }
	
	@FXML
	public void handleCloseButtonAction(ActionEvent event) {
	    close(btnCancel);
	}
	
	
	
	private void close(Button button) {
		Stage stage = (Stage) button.getScene().getWindow();
	    stage.close();
	}
	
	//Handle events
	public void checkout(ActionEvent event) {
		
		boolean isMyComboBoxEmpty = membersComboBox.getSelectionModel().isEmpty();
		if (isMyComboBoxEmpty == true) {
			lblError.setText("You must select a Member!!");
			lblError.setVisible(true);
		}else {
			lblError.setText("");
			lblError.setVisible(false);
			LibraryMember member = membersComboBox.getValue();
			
			CheckoutRecord record = MemberCheckoutsFactory.createCheckoutRecord(member, LocalDate.now());
			DataAccess da = new DataAccessFacade();
			ControllerInterface ci = new SystemController();
			
			for(Book book: books) {
				BookCopy copy = book.getNextAvailableCopy();
				MemberCheckoutsFactory.createCheckoutEntry(record, copy, LocalDate.now());
				copy.changeAvailability();
				book.updateCopies(copy);
				da.saveBook(book);
			}
			
			tableView.getItems().clear();
			tableView.getItems().setAll(ci.allBooks());
			
			ButtonType okButton = new ButtonType("OK");
            Alert alert = new Alert(
            		Alert.AlertType.INFORMATION,
            		"The Books was checkout correctly!!",
            		okButton
            	);
            Window window = alert.getDialogPane().getScene().getWindow();
            window.setOnCloseRequest(e -> alert.hide());
            Optional<ButtonType> result = alert.showAndWait();
            result.ifPresent(res->{
                if (res.equals(okButton)) {
                	close(btnCancel);
                }
            });
		}
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		System.out.println(members);
        ObservableList<LibraryMember> observableMembers = FXCollections.observableList(members);
		membersComboBox.setItems(observableMembers);
		
		vb.setPadding(new Insets(10, 20, 10, 10));
	    vb.setSpacing(4);
		
	    for(Book book: books) {
			String printBook = "ISBN: " + book.getIsbn() + ", Title: " + book.getTitle() + ", Authors: " + book.getAuthors();
			Label b = new Label(printBook, null);
			vb.getChildren().add(b);
			Separator separator = new Separator();
			vb.getChildren().add(separator);
		}
		
		btnAccept.setOnAction(new EventHandler<ActionEvent>() {
			@Override
        	public void handle(ActionEvent e) {
				checkout(e);
			}
		});
		
	}
}
