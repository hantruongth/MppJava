package business.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import business.CheckoutEntry;
import business.LibraryMember;

public class MemberBookEntryDto implements Comparable<MemberBookEntryDto>{
	
	private String memberId;
	private String memberFirstName;
	private String memberLastName;
	private String bookTitle;
	private String isbn;
	private int numberOfCopies;
	private String dueDate;
	
	private LocalDate dueDateLocalDate;
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/YYYY"); 
    
	
	public MemberBookEntryDto(String memberId, String memberFirstName, String memberLastName, String bookTitle,
			String isbn, int numberOfCopies) {
		this.memberId = memberId;
		this.memberFirstName = memberFirstName;
		this.memberLastName = memberLastName;
		this.bookTitle = bookTitle;
		this.isbn = isbn;
		this.numberOfCopies = numberOfCopies;
	}
	
	public MemberBookEntryDto(LibraryMember member, CheckoutEntry entry) {
		this.memberId = member.getMemberId();
		this.memberFirstName = member.getFirstName();
		this.memberLastName = member.getLastName();
		this.bookTitle = entry.getCopy().getBook().getTitle();
		this.isbn = entry.getCopy().getBook().getIsbn();
		this.numberOfCopies = entry.getCopy().getBook().getNumCopies();
		this.dueDate = formatter.format(entry.getDueDate());
		this.dueDateLocalDate = entry.getDueDate();
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberFirstName() {
		return memberFirstName;
	}

	public void setMemberFirstName(String memberFirstName) {
		this.memberFirstName = memberFirstName;
	}

	public String getMemberLastName() {
		return memberLastName;
	}

	public void setMemberLastName(String memberLastName) {
		this.memberLastName = memberLastName;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getNumberOfCopies() {
		return numberOfCopies;
	}

	public void setNumberOfCopies(int numberOfCopies) {
		this.numberOfCopies = numberOfCopies;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	@Override
	public int compareTo(MemberBookEntryDto o) {
		return o.dueDateLocalDate.compareTo(this.dueDateLocalDate);
	}
	
	
	

}
