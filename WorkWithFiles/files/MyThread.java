package files;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

	class MyThread extends Thread{
	
		private long start;
		private long stop;
		final File file;
		private int counter = 0;
		
		public MyThread(File file,long start,long stop) throws IOException{
		this.file=file;
		this.start=start;
		this.stop=stop;
		this.counter=0;
		}
		
		
		
		public int getCounter() {
			return counter;
		}
		
		public void setCounter(int counter) {
			this.counter = counter;
		}
		@Override
		public void run() {
			Scanner sc = null;
			try {
				
				sc=new Scanner(this.file);
			
				int from=0;
				while(sc.hasNextLine()&&from<=stop){
					if(from<=start){
						sc.nextLine();
						from++;
					}else{
						String s= sc.nextLine();
						
							for (int i = 0; i < s.length(); i++) {
								if(s.charAt(i)==','){
									counter+=1;
								}
							}
						
						from++;
					}
					
				}
				
			
				
				System.out.println("Commas : "+counter);
				
				
			} catch (FileNotFoundException e) {
				System.out.println("File not existing.");
				
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				sc.close();
			}
			
		}
	}

