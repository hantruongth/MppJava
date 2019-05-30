package Prob3A.extpackage;

import Prob3A.Circle;
import Prob3A.Cylinder;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cylinder cy1 = new Cylinder(2, 3);
		System.out.println("Volume = " + cy1.computeVolume());
		System.out.println(cy1);
		System.out.println("--------");
		Circle cy2 = new Circle(5);
		System.out.println("Area = " + cy2.computeArea());
		cy2.setHeight(6);
		System.out.println(cy2);
	}

}
