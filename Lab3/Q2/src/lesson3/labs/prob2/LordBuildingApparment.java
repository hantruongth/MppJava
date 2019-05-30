package lesson3.labs.prob2;


class LordBuildingApparment {
	
	LandLord landlord;
	Building building;
	Apparment apparment;
	
	LordBuildingApparment(LandLord landlord, Building building, Apparment apparment){
		this.landlord = landlord;
		this.building = building;
		this.apparment = apparment;
	}	
	
	
	public String toString() {
		return "LandLord: " + landlord.name + "\n"
				+ "Building: " + building.name + "\n"
				+ "Appartment number: " + apparment.name + "\n";
	}
}
