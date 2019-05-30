package lesson3.labs.prob2;

import java.util.*;
import java.util.Map.Entry;


public class LandLord {
	
	String name;
	List<Building> buildings;
	List<LordBuildingApparment> entries  = new ArrayList<>();
	
	LandLord(String name) {
		this.name = name;
		this.buildings = new ArrayList<Building>();
	}
	
	public void addBuilding(Building building) {
		this.buildings.add(building);
	}
	
	public String getName() {
		return this.name;
	}
	
	@Override
	public String toString() {
		
		double profit = 0;
		double maintenance = 0;
    	double sum = 0;
		
		HashMap<Building, List<Apparment>> apparments = new HashMap<Building, List<Apparment>>();
		
		for(LordBuildingApparment entry :  entries) {
			if (entry.landlord.equals(this)) {
				if (!apparments.containsKey(entry.building)) {
					apparments.put(entry.building, new ArrayList<Apparment>());
				}
				apparments.get(entry.building).add(entry.apparment);
			}
		}
		
		Iterator<Entry<Building, List<Apparment>>> it = apparments.entrySet().iterator();
		
	    while (it.hasNext()) {
	    	
	        Map.Entry pair = (Map.Entry)it.next();
	        
	        Building building = (Building) pair.getKey();
	        maintenance += building.getMaintenance();
	        for(Apparment apparment: (List<Apparment>) pair.getValue()) {
	        	sum += apparment.getRent();
	        }	        
	    }
	    
	    profit = sum - maintenance; 
		
		
	    StringBuilder sb = new StringBuilder("Profit for ");
		sb.append(this.name + ": ");
		sb.append(Double.toString(profit) + ": ");
		sb.append("\n\n");
		return sb.toString();
		
	}
	
	
}
