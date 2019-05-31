package prob1;

public class RedheadDuck extends Duck {

	public RedheadDuck() {
		setBehavior(new FlyWithWings(), new Quack());
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("displaying");
	}

}
