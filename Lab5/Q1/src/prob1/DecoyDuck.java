package prob1;

public class DecoyDuck extends Duck {

	public DecoyDuck() {
		setBehavior(new CannotFly(), new MuteQuack());
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("displaying");
	}

}
