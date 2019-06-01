package q4.lab.group16;

import java.util.ArrayList;
import java.util.List;

final public class Customer {
	
	private String name;
	private List<Order> orders;
	Customer(String name) {
		this.name = name;
		orders = new ArrayList<Order>();	
	}
	public void addOrder(Order order) {
		orders.add(order);
	}
	public String getName() {
		return name;
	}
	public List<Order> getOrders() {		
		return orders;
	}
}
