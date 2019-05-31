package com.lesson4;

import java.time.LocalDate;

public class Order {
	private String orderNo;
	private LocalDate orderDate;
	private double orderAmount;

	Order(String orderNo, double orderAmount, LocalDate date) {
		this.orderNo = orderNo;
		this.orderAmount = orderAmount;
		this.orderDate = date;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
	}

}
