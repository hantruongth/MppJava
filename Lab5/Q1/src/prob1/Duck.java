package prob1;

public abstract class Duck {
	private FlyBehavior flyBehaior;
	private QuackBehavior quackBehavior;

	public abstract void display();

	void setBehavior(FlyBehavior flyBehaior, QuackBehavior quackBehavior) {
		this.flyBehaior = flyBehaior;
		this.quackBehavior = quackBehavior;
	}

	public void swim() {
		System.out.println("swimming");
	}

	public void quack() {
		quackBehavior.quack();
	}

	public void fly() {
		flyBehaior.fly();
	}
}
