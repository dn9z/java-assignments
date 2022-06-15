package philosopher;

public class Main {

	
	public static void main(String[] args) {

		Philosopher a = new Philosopher("A");
		Fork f1 = new Fork();
		Philosopher b = new Philosopher("B");
		Fork f2 = new Fork();
		Philosopher c = new Philosopher("C");
		Fork f3 = new Fork();
		Philosopher d = new Philosopher("D");
		Fork f4 = new Fork();
		Philosopher e = new Philosopher("E");
		Fork f5 = new Fork();

		a.setLeftFork(f5);
		a.setRightFork(f1);
		
		b.setLeftFork(f1);
		b.setRightFork(f2);

		c.setLeftFork(f2);
		c.setRightFork(f3);

		d.setLeftFork(f3);
		d.setRightFork(f4);

		e.setLeftFork(f4);
		e.setRightFork(f5);
		
		a.start();
		b.start();
		c.start();
		d.start();
		e.start();
		
	}

}
