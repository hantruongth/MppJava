package business.dto;

import business.CheckoutEntry;
import business.LibraryMember;

public class MemberBookEntryDto {
	
	private String memberId;
	private String memberFirstName;
	private String memberLastName;
	private String bookTitle;
	private String isbn;
	private int numberOfCopies;
	
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
		this.numberOfCopies = entry.getCopy().getCopyNum();
	}
	
	
	

}
