package prob1;

public class Trailer extends Property {
	
	private static final double PRICE = 500;

	@Override
	public double computeRent() {
		return this.PRICE;
	}

	@Override
	public double getRent() {
		return this.computeRent();
	}
	
	

}
