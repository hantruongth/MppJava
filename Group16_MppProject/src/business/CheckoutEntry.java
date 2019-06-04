package business;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CheckoutEntry implements Serializable {

	private static final long serialVersionUID = 98714360920478488L;
	private CheckoutRecord record;
	private BookCopy copy;
	private LocalDate date;
	private LocalDate duedate;
	String id;
	
	CheckoutEntry(CheckoutRecord record, BookCopy copy, LocalDate date){
		
		this.id = UUID.randomUUID().toString();
		this.record = record;
		this.copy = copy;
		this.date = date;
		this.duedate = date;
		
	}
	
	public String getId() {
		return this.id;
	}
}
