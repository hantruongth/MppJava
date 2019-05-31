package com.lesson4;

public final class Paycheck {

	private double grossPay;
	public final double FICA_TAX_RATE = 23.0 / 100;
	public final double STATE_TAX_RATE = 5.0 / 100;
	public final double LOCAL_TAX_RATE = 1.0 / 100;
	public final double MEDICARE_TAXT_RATE = 3.0 / 100;
	public final double SOCIAL_SECURITY_TAX_RATE = 7.5 / 100;

	public Paycheck(double grossPay) {
		this.grossPay = grossPay;
	}

	public double getNetPay() {
		double totalReduceAmount = this.grossPay * (this.FICA_TAX_RATE + this.STATE_TAX_RATE + this.LOCAL_TAX_RATE
				+ this.MEDICARE_TAXT_RATE + this.SOCIAL_SECURITY_TAX_RATE);
		return Math.round(this.grossPay - totalReduceAmount);
	}

}
