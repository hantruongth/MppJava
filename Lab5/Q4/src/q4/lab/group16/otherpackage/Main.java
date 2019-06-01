package q4.lab.group16.otherpackage;

import java.time.LocalDate;

import q4.lab.group16.CustOrder;
import q4.lab.group16.CustOrderFactory;

public class Main {

	public static void main(String[] args) {
		makeOrders();
	}
	
	public static void makeOrders() {
		
		CustOrder custorder = CustOrderFactory.createCustomer("Bob");
		CustOrderFactory.createOrder(custorder, LocalDate.now());
		CustOrderFactory.addItem(custorder, "Shirt");
		CustOrderFactory.addItem(custorder, "Laptop");
		
		
		
		CustOrderFactory.createOrder(custorder, LocalDate.now());
		CustOrderFactory.addItem(custorder, "Pants");
		CustOrderFactory.addItem(custorder, "Knife set");
		
		
		System.out.println(custorder.getCustomer().getOrders());
		
		
	}
	

}
