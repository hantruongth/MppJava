package business;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CheckoutRecord implements Serializable  {
	
	private static final long serialVersionUID = 98714360920478488L;
	private LibraryMember member;
	private LocalDate date;
	private List<CheckoutEntry> entries;
	String id;
	
	CheckoutRecord(LibraryMember member, LocalDate date){
		
		this.id = UUID.randomUUID().toString();
		this.member = member;
		this.date = date;
		entries = new ArrayList<CheckoutEntry>();
		
	}
	
	public String getId() {
		return this.id;
	}
	
	public void addEntry(CheckoutEntry entry){
		entries.add(entry);
	}

	public LibraryMember getMember() {
		return member;
	}

	public LocalDate getDate() {
		return date;
	}

	public List<CheckoutEntry> getEntries() {
		return entries;
	}
	
	
	
	
}
