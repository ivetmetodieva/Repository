package files;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ComparingEfficiencyOfThreads {

	
	public static void main(String[] args) throws IOException, InterruptedException {
		File tom12= new File("voina_i_mir_1_2.txt");	
		if(!tom12.exists()) tom12.createNewFile();
		File tom34= new File("voina_i_mir_3_4.txt");	
		if(!tom34.exists()) tom34.createNewFile();
		warOrPeace(tom12);
		warOrPeace(tom34);
		int numOfThreads=2;
		long rowsTom1=countRows(tom12);
        long start=System.currentTimeMillis();
        ExecutorService executor = Executors.newFixedThreadPool(numOfThreads);
        long from=0;
        long to = rowsTom1/numOfThreads;
        for (int i = 0; i < numOfThreads; i++) {
			executor.execute(new MyThread(tom12, from, to-1));
			from=to;
			to=to*(i+2);
		}
        executor.shutdown();
        while(!executor.isTerminated()){
        	
        }
        long result=System.currentTimeMillis()-start;
		System.out.println("When using "+numOfThreads+" threads =>"+result);
		System.out.println("When using 1 thread and without Executor => ");
		start=System.currentTimeMillis();
		MyThread m = new MyThread(tom12, 0, rowsTom1-1);
		m.start();
		m.join();
		System.out.print("Reasulting time for single thread : "+(System.currentTimeMillis()-start));

		
	}	

	
	public static long countRows(final File f) throws IOException{
		Scanner  sc = new Scanner(f);
		int count=0;
		
		while(sc.hasNextLine()){
			count++;
			sc.nextLine();
		}
		sc.close();
		return count;
	}
	public static void warOrPeace(final File f){
		Scanner sc=null;
		try {
			 sc = new Scanner(f);
			String war="война";
			String peace= "мир";
			int warCount=0;
			int peaceCount=0;
			 while(sc.hasNext()){
				 String s= sc.next();
				 if(s.equalsIgnoreCase(war)){
					 warCount++;
				 }
				 if(s.equalsIgnoreCase(peace)){
					 peaceCount++;
				 }
				
			 }
			 
			System.out.println(warCount>peaceCount?"Война is more common ,used "+warCount+" vs"+peaceCount:"Мир is more common ,used :"+
			peaceCount+" vs "+warCount);
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			sc.close();
		}
		
		
	}
		
		
	}
	

