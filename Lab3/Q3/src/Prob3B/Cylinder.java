package Prob3B;

public class Cylinder {
	private double height;
	private Circle circles;
	public Cylinder(double radius, double height) {
		this.height = height;
		circles = new Circle(radius);
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double computeVolume() {
		return circles.computeArea()*height;
	}
	public String toString() {
		return "Dimensions of this " + getClass().getSimpleName() + ": radius = " + circles.getRadius() + ", height = " + height;
	}
}
