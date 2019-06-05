package dataaccess;

import java.util.HashMap;

import business.Author;
import business.Book;
import business.CheckoutEntry;
import business.CheckoutRecord;
import business.LibraryMember;

public interface DataAccess {
	public HashMap<String, Book> readBooksMap();

	public HashMap<String, User> readUserMap();

	public HashMap<String, LibraryMember> readMemberMap();

	public void saveNewMember(LibraryMember member);

	public void saveNewCheckoutRecord(CheckoutRecord record);
	public void saveNewCheckoutEntry(CheckoutEntry entry);

	public void saveBook(Book book);

	public HashMap<String, Author> readAuthorMap();
	
	public String getCheckoutRecord(String memberId);
	public HashMap<String, CheckoutRecord> readCheckoutRecordMap();
	public HashMap<String, CheckoutEntry> readEntryRecordMap();
}
