package q4.lab.group16;

final public class Item {
	String name;
	
	Item(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return name;
	}
}
