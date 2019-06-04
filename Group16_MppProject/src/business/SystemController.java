package business;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import business.Book;
import dataaccess.Auth;
import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;
import dataaccess.User;

public class SystemController implements ControllerInterface {
	public static Auth currentAuth = null;
	
	public void login(String id, String password) throws LoginException {
		DataAccess da = new DataAccessFacade();
		HashMap<String, User> map = da.readUserMap();
		if(!map.containsKey(id)) {
			throw new LoginException("ID " + id + " not found");
		}
		String passwordFound = map.get(id).getPassword();
		if(!passwordFound.equals(password)) {
			throw new LoginException("Password incorrect");
		}
		currentAuth = map.get(id).getAuthorization();
		
	}
	@Override
	public List<String> allMemberIds() {
		DataAccess da = new DataAccessFacade();
		List<String> retval = new ArrayList<>();
		retval.addAll(da.readMemberMap().keySet());
		return retval;
	}
	
	@Override
	public List<String> allBookIds() {
		DataAccess da = new DataAccessFacade();
		List<String> retval = new ArrayList<>();
		retval.addAll(da.readBooksMap().keySet());
		return retval;
	}
	
	@Override
	public List<Book> allBooks(){
		DataAccess da = new DataAccessFacade();
		Collection<Book> books = da.readBooksMap().values();	
		List<Book> bs = new ArrayList<>();
		bs.addAll(books);
		return bs;
	}
	
	@Override
	public List<LibraryMember> allMemebers(){
		DataAccess da = new DataAccessFacade();
		Collection<LibraryMember> members = da.readMemberMap().values();	
		List<LibraryMember> membersList = new ArrayList<>();
		membersList.addAll(members);
		return membersList;
	}
	
	
	@Override
	public CheckoutRecord saveCheckoutRecord(CheckoutRecord record){
		DataAccess da = new DataAccessFacade();
		da.saveNewCheckoutRecord(record);
		return record;
	}
	

	@Override
	public CheckoutEntry saveCheckoutEntry(CheckoutEntry entry){
		DataAccess da = new DataAccessFacade();
		da.saveNewCheckoutEntry(entry);
		return entry;
	}
	
}
