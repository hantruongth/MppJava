package business;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

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
		this.duedate = getDueDate(copy, date);
		System.out.println("la fecha es:" + this.duedate);
	}
	
	private LocalDate getDueDate(BookCopy copy, LocalDate date) {
		Book book = copy.getBook();
		LocalDate duedate = date.plusDays(book.getMaxCheckoutLength());
		return duedate;
	}
	
	public String getId() {
		return this.id;
	}
	
	
	@Override
	public String toString() {
		return "id:" + id + "book: " + copy.getBook().getTitle() +
				", checkout: " + date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)) +
				", duedate: " + duedate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG));
	}
}
