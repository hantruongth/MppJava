package business;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;

final public class LibraryMember extends Person implements Serializable {
	private String memberId;
	private List<CheckoutRecord> checkoutrecords;
	
	public LibraryMember(String memberId, String fname, String lname, String tel,Address add) {
		super(fname,lname, tel, add);
		
		checkoutrecords = new ArrayList<CheckoutRecord>();
		this.memberId = memberId;		
	}
	
	
	public String getMemberId() {
		return memberId;
	}

	
	
	public void addRecord(CheckoutRecord record) {
		if (checkoutrecords == null) {
			checkoutrecords = new ArrayList<CheckoutRecord>();
		}
		checkoutrecords.add(record);
	}

	
	@Override
	public String toString() {
		return "Member Info: " + "ID: " + memberId + ", name: " + getFirstName() + " " + getLastName() + 
				", " + getTelephone() + " " + getAddress();
	}

	private static final long serialVersionUID = -2226197306790714013L;
}
