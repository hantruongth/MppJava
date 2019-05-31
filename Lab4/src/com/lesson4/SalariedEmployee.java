package com.lesson4;

public class SalariedEmployee extends Employee {

	private double salary;

	public SalariedEmployee(String id, double salary) {
		super(id);
		this.salary = salary;
	}

	@Override
	public double calcGrossPay(int month, int year) {
		return this.salary;
	}

}
