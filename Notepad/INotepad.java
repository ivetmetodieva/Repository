
public interface INotepad {
	
	void  addTextToPage(int pageNum,String text);
	void  redactPageContent(int pageNum,String text);
	void deleteContent(int pageNum);
	void  printContent();
	boolean searchWord(String word);
	void printAllPagesWithDigits();
	
}
