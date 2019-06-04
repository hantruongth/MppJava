package dataaccess;

import java.util.HashMap;

import business.Author;
import business.Book;
import business.LibraryMember;

public interface DataAccess {
	public HashMap<String, Book> readBooksMap();

	public HashMap<String, User> readUserMap();

	public HashMap<String, LibraryMember> readMemberMap();

	public void saveNewMember(LibraryMember member);

	public void saveBook(Book book);

	public HashMap<String, Author> readAuthorMap();
	
	public String getCheckoutRecord(String memberId);
}
