package q4.lab.group16;

import java.time.LocalDate;

/** Typical use: Loading data from database into class model */
final public class CustOrderFactory {
	
	private CustOrderFactory(){}
	
	public static CustOrder createCustomer(String name) {
		CustOrder custorder = new CustOrder(new Customer(name));
		return custorder;
	}
	
	public static void createOrder(CustOrder custorder, LocalDate localdate) {
		if(custorder.getCustomer() == null) throw new NullPointerException("Null customer");
		Order order = Order.newOrder(custorder.getCustomer(), localdate);
		custorder.setOrder(order);
	}
	
	public static void addItem(CustOrder custorder, String item) {
		if(custorder.getCustomer() == null) throw new NullPointerException("Null customer");
		if(custorder.getOrder() == null) throw new NullPointerException("Null order");
		custorder.getOrder().addItem(item);
	}
}
