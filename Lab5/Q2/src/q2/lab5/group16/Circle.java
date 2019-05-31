package q2.lab5.group16;

public final class Circle implements Figure {

	private final double radius;

	public Circle(double radius) {
		super();
		this.radius = radius;
	}

	@Override
	public double computeArea() {
		return this.radius * this.radius * Math.PI;
	}

	public double getRadius() {
		return radius;
	}

}
