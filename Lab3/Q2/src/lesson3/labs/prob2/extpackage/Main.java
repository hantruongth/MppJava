package lesson3.labs.prob2.extpackage;

import java.util.*;

import lesson3.labs.prob2.Building;
import lesson3.labs.prob2.LandLord;
import lesson3.labs.prob2.LordBuildingApparmentFactory;


public class Main {
	
	List<LandLord> landlords = new ArrayList<LandLord>();
	
	private LandLord createLandLord(String name) {
		LandLord landlord = LordBuildingApparmentFactory.createLandLord(name);
		landlords.add(landlord);
		return landlord;
	}
	
	private Building createBuilding(String name, double maintenance, LandLord landlord) {
		return LordBuildingApparmentFactory.createBuilding(name, maintenance, landlord);
	}
	
	private void getProfit() {
		for (LandLord lord: landlords) {
			System.out.println(lord);
		}
	}
	
	private void readDataFromDb() {
		
		LandLord bob = this.createLandLord("Bob");
		LandLord tim = this.createLandLord("Tim");
		LandLord allen = this.createLandLord("Allen");
		
		Building b1_tim = this.createBuilding("Building 1", 789, tim);
		Building b2_tim = this.createBuilding("Building 1", 456, tim);
		Building b3_tim = this.createBuilding("Building 1", 1239, tim);
		
		Building b1_bob = this.createBuilding("Building 1", 123, bob);
		
		Building b1_allen = this.createBuilding("Building 1", 786, allen);
		Building b2_allen = this.createBuilding("Building 1", 613, allen);
		
		LordBuildingApparmentFactory.newLordBuildingApparment("Apparment 1", 1234, b1_tim, tim);
		LordBuildingApparmentFactory.newLordBuildingApparment("Apparment 2", 2345, b1_tim, tim);
		LordBuildingApparmentFactory.newLordBuildingApparment("Apparment 3", 1678, b1_tim, tim);
		LordBuildingApparmentFactory.newLordBuildingApparment("Apparment 4", 789, b2_tim, tim);
		LordBuildingApparmentFactory.newLordBuildingApparment("Apparment 5", 981, b2_tim, tim);
		LordBuildingApparmentFactory.newLordBuildingApparment("Apparment 6", 3452, b2_tim, tim);
		LordBuildingApparmentFactory.newLordBuildingApparment("Apparment 7", 599, b3_tim, tim);
		
		LordBuildingApparmentFactory.newLordBuildingApparment("Apparment 1", 599, b1_bob, bob);
		LordBuildingApparmentFactory.newLordBuildingApparment("Apparment 2", 890, b1_bob, bob);
		
		LordBuildingApparmentFactory.newLordBuildingApparment("Apparment 1", 897, b1_allen, allen);
		LordBuildingApparmentFactory.newLordBuildingApparment("Apparment 2", 1679, b1_allen, allen);
		LordBuildingApparmentFactory.newLordBuildingApparment("Apparment 3", 1900, b2_allen, allen);
		
	}
	
	
	public static void main(String[] args) { 
		Main m = new Main();
		m.readDataFromDb();
		m.getProfit();
	}

}
