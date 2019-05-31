package com.lesson4;

public abstract class Employee {
	private String emppId;

	public Employee(String id) {
		
		this.emppId = id;
	}

	public void print(int month, int year) {
		System.out.println("Employee ID: "+ this.emppId);
		System.out.println("Paystub:");
		System.out.println(" Gross Pay: " + this.calcGrossPay(month, year));
		
		Paycheck paycheck = this.calcCompensation(month,  year);
		
		System.out.println("Fice: " + paycheck.FICA_TAX_RATE);
		System.out.println("State: "+ paycheck.STATE_TAX_RATE);
		System.out.println("Local: " + paycheck.LOCAL_TAX_RATE);
		System.out.println("Medicare: " + paycheck.MEDICARE_TAXT_RATE);
		System.out.println("Social Security: " + paycheck.SOCIAL_SECURITY_TAX_RATE);
		System.out.println("NET PAY: " + paycheck.getNetPay());
		System.out.println();
	}

	public abstract double calcGrossPay(int month, int year);

	public Paycheck calcCompensation(int month, int year) {
		double grossSalary = calcGrossPay(month, year);
		return new Paycheck(grossSalary);
	}

	public String getEmppId() {
		return emppId;
	}

	public void setEmppId(String emppId) {
		this.emppId = emppId;
	}
}
