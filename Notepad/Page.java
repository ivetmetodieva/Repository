
public class Page {
	protected String title;
	protected String text;
	
	protected Page() {
		
	}

	public Page(String title, String text){
		this.title = title;
		this.text = text;
	
	}
	/**
	 * Adds text to current text on the given page.
	 * @param text
	 * @return this.text+=text
	 */
	
	protected String addTextToPage(String text){
		if(this.text!=null&&text!=null)
			return this.text+=text;
		return this.text=text;
	}
	/**
	 * 
	 * Deletes one page.
	 * @return this.text= new String(" ") or Can't delete blank page
	 */
	String deleteText(){
		if(this.text!=null){
		return this.text= new String(" ");
		}

		return "Simply can't delete a blank page.";
	}
	/**
	 * Prints one page.
	 */
	public void showContent() {
		
		if(this.title!=null){
		System.out.println(this.title);
		}
		if(this.text!=null)System.out.println(this.text);
		
		if(this.title==null&&this.text==null){
			System.out.println("BLANK PAGE");
		}
	}

	/**
	 * Checks if the word exists on this page.
	 * @param word
	 * @return true is word is on page	
	 */
	public boolean searchWord(String word){
		if(word!=null&&word!=""){
		String t,s;
		String w=word.toLowerCase();
		boolean inTitle=false;
		if(this.title!=null&&this.title!=""){
			t = this.title.toLowerCase();
			inTitle=t.contains(w);
			
		}
		boolean inText=false;
		if(this.text!=null&&this.text!=""){
			s = this.text.toLowerCase();
			inText=s.contains(w);
		}
		
		return inTitle|inText;
		}
		return false;
	}
	
	/**
	 * @return if there are numbers on the page
	 */
	public boolean containsDigits(){
		String title;
		if(this.title!=null){
			title=this.title;
		}else{
			title="";
		}	
		String text;
			if(this.text!=null){
			text=this.text;
		}else{
			text="";
		}
			title+=text;
			for (int i = 0; i < title.length(); i++) {
				if(title.charAt(i)>=48&&title.charAt(i)<=57){
					return true;
				}
			}
			
		return false;
	}
	
}
