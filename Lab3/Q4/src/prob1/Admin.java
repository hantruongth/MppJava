package prob1;

public class Admin {

	public static double computeTotalRent(Object[] properties) {
		double totalRent = 0;
		for (Object o : properties) {
			Property pro = (Property) o;
			totalRent += pro.getRent();
		}
		return totalRent;
	}

}
