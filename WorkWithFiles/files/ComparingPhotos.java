package files;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ComparingPhotos {
	
	public static void main(String[] args) throws IOException {
		File pic1 = new File("Bugs.jpg");
		File pic2 = new File("Explore.jpg");
		if(!pic1.exists()){
			pic1.createNewFile();
		}
		if(!pic2.exists()){
			pic2.createNewFile();
		}
		FileInputStream fis = new FileInputStream(pic1);
		FileInputStream fis2 = new FileInputStream(pic2);
		int pixel1=fis.read();
		int pixel2=fis2.read();
		while(pixel1!=-1||pixel2!=-1){
			if((char)pixel1!=(char)pixel2){
				System.out.println("different");
				return;
			}
			pixel1=fis.read();
			pixel2=fis2.read();
			
		}
		System.out.println("same");
	}
}
