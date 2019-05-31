package com.lesson4;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Order> orderList = new ArrayList<Order>();
		orderList.add(new Order("1001", 10500, LocalDate.of(2019, Month.MAY, 05)));
		orderList.add(new Order("1002", 20000, LocalDate.of(2019, Month.APRIL, 20)));
		orderList.add(new Order("1003", 50500, LocalDate.of(2019, Month.APRIL, 23)));
		orderList.add(new Order("1004", 80000, LocalDate.of(2019, Month.APRIL, 06)));
		orderList.add(new Order("1005", 10500, LocalDate.of(2019, Month.MAY, 05)));
		orderList.add(new Order("1006", 40500, LocalDate.of(2019, Month.APRIL, 03)));
		orderList.add(new Order("1007", 70700, LocalDate.of(2019, Month.MAY, 05)));
		orderList.add(new Order("1008", 90600, LocalDate.of(2019, Month.APRIL, 16)));
		orderList.add(new Order("1009", 30000, LocalDate.of(2019, Month.MAY, 18)));
		orderList.add(new Order("1010", 20000, LocalDate.of(2019, Month.MAY, 05)));
		orderList.add(new Order("1011", 15500, LocalDate.of(2019, Month.JUNE, 25)));
		orderList.add(new Order("1012", 19200, LocalDate.of(2019, Month.MAY, 24)));
		orderList.add(new Order("1013", 12800, LocalDate.of(2019, Month.MAY, 27)));

		CommissionedEmployee comEmployee = new CommissionedEmployee("123", 0.8, 500, orderList);
		List<Employee> employees = Arrays.asList(new HourlyEmployee("122", 15.50, 20),
				new SalariedEmployee("124", 300000), comEmployee);

		for (Employee employee : employees) {
			employee.print(5, 2019);
			
		}

	}

}
