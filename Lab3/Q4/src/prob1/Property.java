package prob1;

public abstract class Property {
	private String id;
	private Address address;
	private double rent;

	public abstract double computeRent();
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}


	public double getRent() {
		return rent;
	}

	public void setRent(double rent) {
		this.rent = rent;
	}

}
