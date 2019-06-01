package q4.lab.group16;

final public class CustOrder {

	private Customer customer;
	private Order order;
	
	
	CustOrder(Customer customer) {
		this.customer = customer;
	}
	
	public void setOrder(Order order) {
		this.order = order;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public Order getOrder() {
		return order;
	}
}
