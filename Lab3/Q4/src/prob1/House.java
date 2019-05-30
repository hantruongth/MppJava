package prob1;

public class House extends Property{
	private double lotSize;
	private static final double RATE = 0.1;
	
	public House(double lotSize) {
		this.lotSize = lotSize;
	}

	@Override
	public double computeRent() {
		return this.RATE * this.lotSize;
	}

	@Override
	public double getRent() {
		return this.computeRent();
	}
	
	
	

}
