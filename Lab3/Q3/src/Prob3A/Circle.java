package Prob3A;

public class Circle extends Cylinder{
	
	public Circle(double radius) {
		super(radius, radius);
	}
	
	public double computeArea() {
		return Math.PI*(Math.pow(getRadius(), 2));
	}
}
