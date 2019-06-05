package business;

import java.time.LocalDate;

public class MemberCheckoutsFactory {
	
	public static CheckoutRecord createCheckoutRecord(LibraryMember member, LocalDate date) {
		if(member == null)
			throw new IllegalArgumentException("Member cannot be null");
		
		ControllerInterface ci = new SystemController();
		CheckoutRecord record = new CheckoutRecord(member, date);
		ci.saveCheckoutRecord(record);
		member.addRecord(record);
		return record;	
	}
	
	
	public static CheckoutEntry createCheckoutEntry(CheckoutRecord record, BookCopy copy, LocalDate date) {
		if(record == null)
			throw new IllegalArgumentException("Member cannot be null");
		
		if(copy == null)
			throw new IllegalArgumentException("BookCopy cannot be null");
		
		
		ControllerInterface ci = new SystemController();
		CheckoutEntry entry = new CheckoutEntry(record, copy, date);
		ci.saveCheckoutEntry(entry);
		record.addEntry(entry);
		return entry;	
	}

}
