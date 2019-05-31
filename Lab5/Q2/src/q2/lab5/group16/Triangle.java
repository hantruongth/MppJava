package q2.lab5.group16;

public final class Triangle implements Figure{

	private final double base;
	private final double height;

	public Triangle(double base, double height) {
		super();
		this.base = base;
		this.height = height;
	}

	@Override
	public double computeArea() {
		return (this.base * this.height)/2;
	}

	public double getBase() {
		return base;
	}

	public double getHeight() {
		return height;
	}
	
	

}
