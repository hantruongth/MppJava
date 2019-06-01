package prob1;

public class MallardDuck extends Duck {

	public MallardDuck() {
		setBehavior(new FlyWithWings(), new Quack());
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("display");
	}

}
