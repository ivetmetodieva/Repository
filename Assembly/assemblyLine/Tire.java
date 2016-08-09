package assemblyLine;

public class Tire extends Thread{
	
	@Override
	public void run() {
		System.out.println("Creating tire..");
		try {
			for (int i = 0; i < 2; i++) {
				System.out.println("Working on tire "+(2-i)+" seconds till completion.");
				sleep(1000);
			}
			
		} catch (InterruptedException e) {
			//System.out.println();
		}
		System.out.println("TIRE created.");
	}
}
