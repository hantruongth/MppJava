package business;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public List<Author> allAuthors() {
		DataAccess da = new DataAccessFacade();
		HashMap<String, Author> authorHashMap = da.readAuthorMap();
		return new ArrayList<>(authorHashMap.values());
	}
	@Override
	public void addBook(Book book) {
		DataAccess da =  new DataAccessFacade();
		da.saveBook(book);
	}
	@Override
	public void addLibraryMember(LibraryMember member) {
		DataAccess da =  new DataAccessFacade();
		da.saveNewMember(member);
	}
	@Override
	public List<LibraryMember> allLibraryMembers() {
		// TODO Auto-generated method stub
		DataAccess da = new DataAccessFacade();
		HashMap<String, LibraryMember> memberHashMap = da.readMemberMap();
		return new ArrayList<>(memberHashMap.values());
	}
	
	@Override
	public CheckoutEntry saveCheckoutEntry(CheckoutEntry entry){
		DataAccess da = new DataAccessFacade();
		da.saveNewCheckoutEntry(entry);
		return entry;
	}
	
	public List<LibraryMember> getLibraryMember(String memberId) {
		DataAccess da = new DataAccessFacade();
		HashMap<String, LibraryMember> memberMap = da.readMemberMap();

		// search by memberID
		if (memberId != null) {
			LibraryMember member = memberMap.get(memberId);
			return Arrays.asList(member);
		}
		return new ArrayList<>(memberMap.values());
		
	}
	@Override
	public List<LibraryMember> getAllLibraryMember() {
		DataAccess da = new DataAccessFacade();
		HashMap<String, LibraryMember> memberMap = da.readMemberMap();
		return new ArrayList<>(memberMap.values());
	}
	
	@Override
	public Map<LocalDate, List<CheckoutEntry>> getCheckoutEntries(LibraryMember member) {
		DataAccess da = new DataAccessFacade();
		HashMap<String, CheckoutRecord> checkoutHashMap = da.readCheckoutRecordMap();
		Collection<CheckoutRecord> checkoutRecords = checkoutHashMap.values();
		List<CheckoutRecord> checkoutRecordOfMember = new ArrayList<>();
		checkoutRecords.forEach(e->{
			if(e.getMember().equals(member))
				checkoutRecordOfMember.add(e);
		});
		Map<LocalDate, List<CheckoutEntry>> checkoutEntriesMap = new HashMap<>();
		checkoutRecordOfMember.forEach(e->{
			List<CheckoutEntry> existList = checkoutEntriesMap.get(e.getDate());
			if(existList == null)
				existList = new ArrayList<>();
			
			existList.addAll(e.getEntries());
			checkoutEntriesMap.put(e.getDate(), existList);
			
		});
		return checkoutEntriesMap;
	}
	@Override
	public Map<LibraryMember, List<CheckoutEntry>> getCheckoutEntryList(String isbn) {
		DataAccess da = new DataAccessFacade();
		HashMap<String, CheckoutRecord> checkoutHashMap = da.readCheckoutRecordMap();
		Collection<CheckoutRecord> checkoutRecords = checkoutHashMap.values();
		Map<LibraryMember, List<CheckoutEntry>> memberEntryMap = new HashMap<>();
		checkoutRecords.forEach(e-> {
			List<CheckoutEntry> overdueEntries = new ArrayList<>();
			
			List<CheckoutEntry> entries = e.getEntries();
			
			for (CheckoutEntry entry : entries) {
				if(entry.getCopy().getBook().getIsbn().equalsIgnoreCase(isbn) && entry.getDueDate().isBefore(LocalDate.now())){
					overdueEntries.add(entry);
				}
			}
			
			if(memberEntryMap.get(e.getMember()) != null) {
				overdueEntries.addAll(memberEntryMap.get(e.getMember()));
				memberEntryMap.put(e.getMember(), overdueEntries);
			}
			
		});
		
		return memberEntryMap;
	}
	
	 
	
}
