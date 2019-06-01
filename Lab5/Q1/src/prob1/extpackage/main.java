package prob1.extpackage;
import prob1.*;
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Duck[] ducks = {
			new MallardDuck(),
			new DecoyDuck(),
			new RedheadDuck(),
			new RubberDuck()
		};
		for(Duck d: ducks) {
			System.out.println(d.getClass().getSimpleName()+":");
			System.out.print("	");
			d.display();
			System.out.print("	");
			d.fly();
			System.out.print("	");
			d.quack();
			System.out.print("	");
			d.swim();
		}
	}

}
