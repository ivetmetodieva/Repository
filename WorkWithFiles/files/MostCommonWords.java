package files;
import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream.PutField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Stream;

public class MostCommonWords {
	public static void main(String[] args) throws IOException {
		File file = new File("voina_i_mir_1_2.txt");	
		if(!file.exists()) file.createNewFile();
		
		HashMap<String,Integer> words= new HashMap<>();
		Scanner sc=null;
		try{
			sc= new Scanner(file);
			while(sc.hasNext()){
				String s = sc.next();
				s.trim();
				if(!words.containsKey(s)){
					words.put(s,1);
				}else{
					int toPut= words.get(s);
					words.put(s,++toPut);
				}
				
			}

			Stream<Map.Entry<String ,Integer>> sorted = words.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()));
			words.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
		}
		finally{
			sc.close();
		}
	}
	
}
