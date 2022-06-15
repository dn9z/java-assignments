package pi;

public class PiComputer {

	private static int n = 100000;
	private int t;
	
	public PiComputer() {
		
	}
	
	public static void main(String[] args) {
		PiComputer pi = new PiComputer();
		pi.computePi();
	}
	
	private void computePi() {
		double x, y;
		
		for(int i = 0; i < n; i++) {
			x = Math.random();
			y = Math.random();
			
			if (Math.hypot(x, y) <= 1) t = t + 1;
			
		}
		double pi =   4 * (double) t / n;
		System.out.println("Pi: " + pi);
	}

	
	
}
