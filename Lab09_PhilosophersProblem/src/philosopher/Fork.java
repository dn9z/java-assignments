package philosopher;

public class Fork {

	private Philosopher reservedBy;
	private Philosopher occupiedBy;

	public synchronized void occupy(Philosopher philosopher) {

		if (occupiedBy != null) {
			if (philosopher != occupiedBy) {
				try {
					this.reserve(philosopher);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else {
			this.occupiedBy = philosopher;
		}
	}

	private synchronized void reserve(Philosopher philosopher) throws InterruptedException {
		this.reservedBy = philosopher;
		System.out.println(philosopher.getName() + " has to wait for a fork.");

		this.wait();

		System.out.println(philosopher.getName() + " got fork.");

		this.reservedBy = null;

		this.occupy(philosopher);

	}

	public synchronized void release(Philosopher philosopher) {

		this.occupiedBy = null;

		if (this.reservedBy != null) {
			this.notifyAll();
		}

	}

}
