package business;

import java.time.LocalDate;
import java.util.List;

public interface ControllerInterface {
	public void login(String id, String password) throws LoginException;
	public List<String> allMemberIds();
	public List<String> allBookIds();
	public List<Author> allAuthors();
	public List<LibraryMember> allLibraryMembers();
	public void addBook(Book book);
	public void addLibraryMember(LibraryMember member);
	public List<LibraryMember> getLibraryMember(String memberId);
	public List<LibraryMember> getAllLibraryMember();
	
	
	public List<Book> allBooks();
	public List<LibraryMember> allMemebers();
	
	public CheckoutRecord saveCheckoutRecord(CheckoutRecord record);
	public CheckoutEntry saveCheckoutEntry(CheckoutEntry entry);
	
}
