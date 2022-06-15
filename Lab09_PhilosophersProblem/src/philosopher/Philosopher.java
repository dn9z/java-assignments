package philosopher;

import java.util.Random;

public class Philosopher extends Thread {

	private Fork leftFork;
	private Fork rightFork;
	private static Random random = new Random(System.currentTimeMillis());

	public Philosopher(String name) {
		super(name);
	}

	@Override
	public void run() {

		while (true) {

			System.out.println(getName() + " is waiting.");
			waitRandom();

			System.out.println(getName() + " is hungry.");
			System.out.println(getName() + " grabs left fork.");
			leftFork.occupy(this);
			System.out.println(getName() + " grabs right fork.");
			rightFork.occupy(this);

			System.out.println(getName() + " is eating.");
			waitRandom();
			System.out.println(getName() + " is not hungry anymore.");

			// release
			System.out.println(getName() + " release left fork.");
			leftFork.release(this);
			System.out.println(getName() + " release right fork.");
			rightFork.release(this);

		}

	}


	private void waitRandom()  {
		long millis = (long) (random.nextDouble() * 5000);
			try {
				Thread.sleep(millis);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	public void setLeftFork(Fork leftFork) {
		this.leftFork = leftFork;
	}

	public void setRightFork(Fork rightFork) {
		this.rightFork = rightFork;
	}

}
