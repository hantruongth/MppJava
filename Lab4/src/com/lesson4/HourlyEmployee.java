package com.lesson4;

public class HourlyEmployee extends Employee {

	private double hourlyWage = 50;
	private int hoursPerWeek = 4;

	public HourlyEmployee(String id, double hourlyWage, int hourPerWeek) {
		super(id);
		this.hourlyWage = hourlyWage;
		this.hoursPerWeek = hourPerWeek;
	}

	@Override
	public double calcGrossPay(int month, int year) {
		return (this.hourlyWage * this.hoursPerWeek);
	}

}
