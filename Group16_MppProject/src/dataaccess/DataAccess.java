package dataaccess;

import java.util.HashMap;

import business.Book;
import business.CheckoutEntry;
import business.CheckoutRecord;
import business.LibraryMember;
import dataaccess.DataAccessFacade.StorageType;

public interface DataAccess { 
	public HashMap<String,Book> readBooksMap();
	public HashMap<String,User> readUserMap();
	public HashMap<String, LibraryMember> readMemberMap();
	public void saveNewMember(LibraryMember member);
	public void saveNewCheckoutRecord(CheckoutRecord record);
	public void saveNewCheckoutEntry(CheckoutEntry entry);
	public void saveBook(Book book);
}
