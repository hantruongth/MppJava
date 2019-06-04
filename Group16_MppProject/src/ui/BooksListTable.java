package ui;

import java.util.ArrayList;
import java.util.Collection;

import java.util.List;


import business.Book;
import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class BooksListTable {
	

    @FXML private TableView<Book> tableView;
    @FXML private TableColumn<Book, String> isbn = new TableColumn<>("isbn");
    @FXML private TableColumn<Book, String> title = new TableColumn<>("title");
    @FXML private TableColumn<Book, String> authors = new TableColumn<>("authors");
    @FXML private TableColumn<Book, String> numCopies = new TableColumn<>("numCopies");
    
    
    @FXML
    public void initialize() {
    	
    	title.setCellValueFactory(new PropertyValueFactory<>("title"));
    	isbn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
    	authors.setCellValueFactory(new PropertyValueFactory<>("authors"));
    	numCopies.setCellValueFactory(new PropertyValueFactory<>("numCopies"));
        tableView.getItems().setAll(parseUserList());
    }
    
    private List<Book> parseUserList(){
    	
		DataAccess da = new DataAccessFacade();
		Collection<Book> books = da.readBooksMap().values();	
		List<Book> bs = new ArrayList<>();
		bs.addAll(books);
		
    	return bs;
	}
}