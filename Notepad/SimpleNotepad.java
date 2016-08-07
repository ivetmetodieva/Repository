

public class SimpleNotepad extends Page implements INotepad{
	private Page[] simpleNotepad;
	private static final int MAX_PAGE=5;
	
	
	public SimpleNotepad() {
		super();
		this.simpleNotepad = new SimpleNotepad [MAX_PAGE];
		System.out.println("SimpleNotepad created with "+MAX_PAGE+" pages.");
		
	}
	
	public Page[] getSimpleNotepad() {
		return simpleNotepad;
	}
	
	public boolean searchWord(String word){
		for (int i = 0; i < simpleNotepad.length; i++) {
			if(simpleNotepad[i].searchWord(word)){
			return true;
			}
		}
		return false;
	}
	
	public void setSimpleNotepad(Page[] simpleNotepad) {
		this.simpleNotepad = simpleNotepad;
	}

	/**
	 * Adds text to a blank page with number.
	 */
	@Override
	public void addTextToPage(int pageNum, String text) {
		if(validatePageNum(pageNum)){
			if(simpleNotepad[pageNum-1].text!=null&&simpleNotepad[pageNum-1].title!=null)
			this.simpleNotepad[pageNum-1].addTextToPage(text);
		}else{
			System.out.println("Error in add text to blank page");
		}
		
	}
	/**
	 * Delete content of the current page.
	 */
	@Override
	public void deleteContent(int pageNum) {
		if(validatePageNum(pageNum)){
				this.simpleNotepad[pageNum-1].deleteText();
			}else{
				System.out.println("Can't delete something that doesn't exist.");
			}
		
		
	}
	/** 
	 * Prints the content of the whole simpleNotepad.
	 */
	@Override
	public void printContent() {
		for (int i = 0; i < simpleNotepad.length; i++) {
			if(simpleNotepad[i]!=null)
			simpleNotepad[i].showContent();
		}
		
	}
	/**
	 * Add new text to old page.
	 */
	@Override
	public void redactPageContent(int pageNum, String text) {
		if(validatePageNum(pageNum)){
			if(simpleNotepad[pageNum-1].text!=null&&simpleNotepad[pageNum-1].title!=null){
				this.deleteContent(pageNum);
				this.addTextToPage(pageNum, text);			}
		}else{
			System.out.println("RedactPageContent stopped working.");
		}
		
	}
	public static boolean validatePageNum(int pageNum){
		if(pageNum>=1&&pageNum<=MAX_PAGE){
			return true;
		}
		return false;
	}

	@Override
	public void printAllPagesWithDigits() {
		for (int i = 0; i < simpleNotepad.length; i++) {
			if(simpleNotepad[i].containsDigits()){
				simpleNotepad[i].showContent();
			}
		}
		
	}
	
	
	
	

}
