package q3.lab5.group16;

public class VehicleFactory {

	public static Vehicle getVehicle(String v) {
		switch (v) {
		case "bus":
			return new Bus();
		case "car":
			return new Car();
		case "electricCar":
			return new ElectricCar();
		case "truck":
			return new Truck();
		default:
			throw new IllegalArgumentException("Wrong data");
		}
	}

}
