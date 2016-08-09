package assemblyLine;

public class Demo {
	/*
	 * Your job is to implement the simulation of an assembly line that will build Cars. Each Car
is made up of several components: tires, seats, engine and frame. Each of these
components takes a different amount of time to build on their own. Here’s the breakdown
on the simulated time each component takes to construct:
•Tire – 2 seconds
•Seats – 3 seconds
•Engine – 7 seconds
•Frame – 5 seconds
With these times, you must implement the code that will simulate the construction of each
of these components individually, then once all the necessary components are built you
must put them together to make a car. To build a car, you’ll need 4 tires, 5 seats, 1 engine
and 1 frame. Here’s the catch, the assembly line can only and should only be capable of
building 3 Components at any given time. You’ll need to implement this in your code.
Once you’ve completed the assignment, try and fiddle with the order of which the
Components are assembled on the line. Is there a particular order that provides the fastest
building time for a Car?
	 */
	public static void main(String[] args) throws InterruptedException {
		Tire tire1= new Tire();
		Tire tire2=new Tire();
		Tire tire3=new Tire();
		Tire tire4=new Tire();
		Seat seat1=new Seat();
		Seat seat2=new Seat();
		Seat seat3=new Seat();
		Seat seat4=new Seat();
		Seat seat5=new Seat();
		Thread engine= new Thread(){
			@Override
			public void run() {
				System.out.println("Creating Engine..");
				try{
				for (int i = 0; i < 7; i++) {
					
						System.out.println("Working on engine  "+(7-i)+" seconds till completion");
						sleep(1000);
						
					
					}
				}
				 catch (InterruptedException e) {
						
					}
				System.out.println("ENGINE created.");
			}
		
		};
		Thread  frame = new Thread(){
			@Override
			public void run() {
				System.out.println("Creating frame.");
				try {
					for (int i = 0; i < 5; i++) {
						System.out.println("Working on frame"+(5-i)+" seconds till completion");
						sleep(1000);
					}
					
				} catch (InterruptedException e) {
					
				}
				System.out.println("FRAME created!");
			}
		};
		long startTime = System.currentTimeMillis();
		engine.start();
		frame.start();
		seat1.start();
		seat1.join();
		if(!seat1.isAlive()){
			tire1.start();
		}
		tire1.join();
		if(!tire1.isAlive()){
			tire2.start();
		}
		frame.join();
		if(!frame.isAlive()){
			tire3.start();
		}

		engine.join();
		tire3.join();
		seat2.start();
		seat3.start();
		seat4.start();
	
		seat2.join();
		seat3.join();
		if(!(seat2.isAlive()||seat3.isAlive())){
			seat5.start();
		}
		
		tire4.start();
		
		seat4.join();
		seat5.join();
		tire4.join();
		long estimatedTime = System.currentTimeMillis() - startTime;
		
		System.out.println("Time for completion : "+estimatedTime/1000+" seconds.");
		System.out.println("Car components build.");
		
	}
}
