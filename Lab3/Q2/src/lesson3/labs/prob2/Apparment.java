package lesson3.labs.prob2;

import java.util.ArrayList;
import java.util.List;

class Apparment {
	
	String name;
	Building building;
	LandLord landlord;
	double rent;
	
	List<LordBuildingApparment> entries  = new ArrayList<>();
	
	Apparment(String name, double rent, Building building, LandLord landlord) {
		this.name = name;
		this.rent = rent;
		this.building = building;
		this.landlord = landlord;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	

	public void setRent(double rent) {
		this.rent = rent;
	}
	

	public void setBuilding(Building building) {
		this.building = building;
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getRent() {
		return this.rent;
	}
	
	public Building getBuilding() {
		return this.building;
	}
}
