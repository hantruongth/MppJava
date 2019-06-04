package business;

import java.time.LocalDate;
import java.util.List;

import business.Book;
import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;

public interface ControllerInterface {
	public void login(String id, String password) throws LoginException;
	public List<String> allMemberIds();
	public List<String> allBookIds();
	
	public List<Book> allBooks();
	public List<LibraryMember> allMemebers();
	
	public CheckoutRecord saveCheckoutRecord(CheckoutRecord record);
	public CheckoutEntry saveCheckoutEntry(CheckoutEntry entry);
	
}
