package business;

import java.util.List;

public interface ControllerInterface {
	public void login(String id, String password) throws LoginException;
	public List<String> allMemberIds();
	public List<String> allBookIds();
	public List<Author> allAuthors();
	public List<LibraryMember> allLibraryMembers();
	public void addBook(Book book);
	public void addLibraryMember(LibraryMember member);
}
