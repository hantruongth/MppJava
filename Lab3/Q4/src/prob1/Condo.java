package prob1;

public class Condo extends Property{
	
	private int nbOfFloor;
	private static final double RANGE =400;
	
	public Condo(int nbOfFloor) {
		super();
		this.nbOfFloor = nbOfFloor;
	}

	@Override
	public double computeRent() {
		return this.RANGE * this.nbOfFloor;
	}

	@Override
	public double getRent() {
		return this.computeRent();
	}
	
	

}
