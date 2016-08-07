

public class NotepadDemo {
	public static void main(String[] args) {
		Page[] pages = new Page[5];
		pages[0]=new Page("Title", "Text for page ");
		boolean searchFor=pages[0].searchWord("title");
		System.out.println(searchFor?"Word exists!":"No such word!");
		boolean hasDigits=pages[0].containsDigits();
		System.out.println(hasDigits?"Digits exist on page":"Only letters");
	
		pages[1]=new Page("Title2","text for page 2");
		pages[2]=new Page("Title3","text for page 3");
		pages[3]=new Page("Title ","text for page  ");
		pages[4]=new Page("Title5","text for page 5");
		hasDigits=pages[4].containsDigits();
		System.out.println(hasDigits?"Digits exist on page":"Only letters");
		
		SimpleNotepad sn = new SimpleNotepad();
		sn.setSimpleNotepad(pages);
		searchFor=sn.searchWord("tEXt");
		System.out.println(searchFor?"Word exists!":"No such word!");
		sn.printAllPagesWithDigits();
		sn.addTextToPage(2, "FUNCTION WORKS");
		sn.printContent();
		sn.redactPageContent(2, "555555555555555");
		sn.printContent();
		sn.deleteContent(2);
		sn.printContent();
	
		ElectronicSecuredNotepad esn;
		try{
			System.out.println("NOTE : when there is no action..enter your password again and hit enter..");
			esn = new ElectronicSecuredNotepad ();
			esn.setSimpleNotepad(pages);
			esn.addTextToPage(2, "This function works :) ");
			esn.printContent();
			
		}
		catch(DeviceNotOnException e){//see class ElectonicSecuredNotepad's constructor
			System.out.println("Can't create the object since device is not on,try again");
		}
		catch(InvalidPasswordException e){
			System.out.println("Reconsider your password !");
		}
		
	}
}
