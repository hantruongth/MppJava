package com.lesson4;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.stream.Collectors;

public class CommissionedEmployee extends Employee {
	private double commission;
	private double baseSalary;

	private List<Order> orders;

	CommissionedEmployee(String id, double commission, double baseSalary, List<Order> order) {
		super(id);
		this.commission = commission;
		this.baseSalary = baseSalary;
		this.orders = order;
	}

	public void addOrder(String orderId, double amount) {
		orders.add(new Order(orderId, amount, LocalDate.now()));
	}

	@Override
	public double calcGrossPay(int month, int year) {

		LocalDate firstDatetOfLastMonth = LocalDate.of(year, month-1, 1);
		LocalDate lastDateLocalDate = firstDatetOfLastMonth.with(TemporalAdjusters.lastDayOfMonth());

		List<Order> ordersInLastMonth = orders.stream().filter(e -> {
			return e.getOrderDate().isAfter(firstDatetOfLastMonth) && e.getOrderDate().isBefore(lastDateLocalDate);
		}).collect(Collectors.toList());

		double totalOrderLastMonth = 0;
		for (Order order : ordersInLastMonth) {
			totalOrderLastMonth += order.getOrderAmount();
		}
		return this.baseSalary + totalOrderLastMonth * this.commission;

	}

}