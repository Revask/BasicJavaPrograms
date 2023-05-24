package BasicJavaPrograms;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class GenearteRandomNumbers {

	public static void main(String[] args) {

		Random r = new Random(10);
		int n = 0;
		
		int tlr = ThreadLocalRandom.current().nextInt(1,25);
		System.out.println("threadlocalrandom " + tlr);
		for(int i = 0;i < 10;i++)
		{
			System.out.println("Random number " + i + " " + r.nextInt(25));
			System.out.println("Random boolean " + i + " " + r.nextBoolean());
			n =  (int) (Math.random() * 10 + 1);
			System.out.println("Math.Random " + n);
			
		}
	}

}
