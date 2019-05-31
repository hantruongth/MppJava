package q2.lab5.group16;

import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Figure> figures = Arrays.asList(new Circle(100), new Triangle(30, 100), new Rectangle(25, 50));

		double area = 0;
		for (Figure figure : figures) {
			area += figure.computeArea();
		}

		System.out.println("Sum of Areas = " + area);
	}

}
