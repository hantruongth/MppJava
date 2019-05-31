package prob1;

public class RubberDuck extends Duck {

	public RubberDuck() {
		setBehavior(new CannotFly(), new Squeak());
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("displaying");
	}

}
