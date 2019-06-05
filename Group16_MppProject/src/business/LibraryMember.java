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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LibraryMember other = (LibraryMember) obj;
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Member Info: " + "ID: " + memberId + ", name: " + getFirstName() + " " + getLastName() + 
				", " + getTelephone() + " " + getAddress();
	}

	private static final long serialVersionUID = -2226197306790714013L;
}
