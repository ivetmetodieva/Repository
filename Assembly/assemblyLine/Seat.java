package assemblyLine;

public class Seat extends Thread{
	@Override
	public void run() {
		System.out.println("Creating seat..");
		try {
			for (int i = 0; i < 3; i++) {
				System.out.println("Working on seat"+ (3-i)+" seconds till completion.");
				sleep(1000);
			}
			
		} catch (InterruptedException e) {
			
		}
		System.out.println("SEAT created!");
	}
}
