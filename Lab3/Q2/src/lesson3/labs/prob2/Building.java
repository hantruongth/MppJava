package lesson3.labs.prob2;

import java.util.*;

public class Building {
	
	String name;
	double maintenance = 0;
	LandLord landlord;
	List<Apparment> appartaments;
	List<LordBuildingApparment> entries  = new ArrayList<>();
	
	
	Building(String name, double maintenance, LandLord landlord) {
		
		this.maintenance = maintenance;
		this.name = name;
		this.landlord = landlord;
		this.appartaments = new ArrayList<Apparment>();
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void addApparment(Apparment apparment) {
		this.appartaments.add(apparment);
	}
	
	public double getMaintenance() {
		return this.maintenance;
	}
	
	public String getName() {
		return this.name;
	}
	
	public List<Apparment> getApparments(){
		return this.appartaments;
	}
	
}
