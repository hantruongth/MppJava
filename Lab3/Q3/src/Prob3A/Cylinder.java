package Prob3A;

public class Cylinder {
	private double height;
	private double radius;

	public Cylinder(double radius, double height) {
		this.height = height;
		this.radius = radius;
	}

	public double getHeight() {
		return height;
	}

	public double getRadius() {
		return radius;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public double computeVolume() {
		return Math.PI * (Math.pow(radius, 2) * height);
	}

	public String toString() {
		return "Dimensions of this " + getClass().getSimpleName() + ": radius = " + radius + ", height = " + height;
	}
}
