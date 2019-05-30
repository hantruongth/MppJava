package lesson3.labs.prob2;



public class LordBuildingApparmentFactory {
	
	
	public static Building createBuilding(String name, double maintenance, LandLord landlord) {
		
		if(name == null)
			throw new IllegalArgumentException("name cannot be null");
		
		if(landlord == null)
			throw new IllegalArgumentException("LandLord cannot be null");
		
		return new Building(name, maintenance, landlord);
		
	}
	
	
	public static LandLord createLandLord(String name) {
		
		if(name == null)
			throw new IllegalArgumentException("name cannot be null");
		
		return new LandLord(name);
		
	}
	
	
	public static void newLordBuildingApparment(String name, double rent, Building building, LandLord landlord) {
		
		if(name == null)
			throw new IllegalArgumentException("name cannot be null");
		
		if(landlord == null) 
			throw new IllegalArgumentException("LandLord name cannot be null");
		
		if(building == null) 
			throw new IllegalArgumentException("Building name cannot be null");
		
		
		Apparment apparment =  new Apparment(name, rent, building, landlord);
		
		LordBuildingApparment entry = new LordBuildingApparment(landlord, building, apparment);
		landlord.entries.add(entry);
		building.entries.add(entry);
		apparment.entries.add(entry);
		
	}
}
