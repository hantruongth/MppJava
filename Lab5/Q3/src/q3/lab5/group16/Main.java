package q3.lab5.group16;

import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		Vehicle car = VehicleFactory.getVehicle("car");
		Vehicle truck = VehicleFactory.getVehicle("truck");
		Vehicle bus = VehicleFactory.getVehicle("bus");
		Vehicle electricCar = VehicleFactory.getVehicle("electricCar");

		List<Vehicle> vehicles = Arrays.asList(car, truck, bus, electricCar);
		vehicles.forEach(e -> e.startEngine());
	}

}
