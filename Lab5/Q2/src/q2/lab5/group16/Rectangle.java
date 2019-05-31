package q2.lab5.group16;

public final class Rectangle implements Figure {

	private final double width;
	private final double height;

	public Rectangle(double width, double height) {
		super();
		this.width = width;
		this.height = height;
	}

	@Override
	public double computeArea() {
		return this.width * this.height;
	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

}
