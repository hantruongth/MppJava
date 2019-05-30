package lesson3.labs.prob1;

public class PersonWithJob {

	private double salary;
	private Person person;

	public double getSalary() {
		return salary;
	}

	PersonWithJob(String n, double s) {
		person = new Person(n);
		salary = s;
	}

	public Person getPerson() {
		return this.person;
	}

	@Override
	public boolean equals(Object aPerson) {
		if (aPerson == null)
			return false;
		if (!(aPerson instanceof PersonWithJob))
			return false;
		PersonWithJob p = (PersonWithJob) aPerson;
		boolean isEqual = this.person.getName().equals(p.person.getName()) && this.getSalary() == p.getSalary();
		return isEqual;
	}

	public static void main(String[] args) {
		PersonWithJob p1 = new PersonWithJob("Joe", 30000);
		Person p2 = new Person("Joe");
		// As PersonsWithJobs, p1 should be equal to p2
		System.out.println("p1.equals(p2)? " + p1.equals(p2));
		System.out.println("p2.equals(p1)? " + p2.equals(p1));
	}

}
