package files;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Demo {
	public static void main(String[] args) throws IOException {
		File tom12= new File("voina_i_mir_1_2.txt");
		File tom34= new File("voina_i_mir_3_4.txt");
		System.out.println("commas file 1: "+countCommas(tom12));
		System.out.println("commas file 2: "+countCommas(tom34));
		System.out.println("Words "+countWords(tom12)+countWords(tom34));
	
		
	}
	public static int countWords(File f) throws IOException{
		int words=0;
		try(FileReader fr = new FileReader(f)){
			int sign=fr.read();
			while(sign!=-1){
				if(sign==' '){
					words++;
				}
				sign=fr.read();
				
			}
			fr.close();
			return words;
		} catch (FileNotFoundException e) {
			System.out.println("File not existing.");
			return 0;
		
		}

		
		
	}
	public static int countCommas(File f) throws IOException{
		int commas=0;
		try(FileReader fr = new FileReader(f)){
			int sign=fr.read();
			while(sign!=-1){
				if(sign==','){
					commas++;
				}
				sign=fr.read();
			}
			fr.close();
			return commas;
		} catch (FileNotFoundException e) {
			System.out.println("File not existing.");
			return 0;
		
		}
		
		
	}
}
