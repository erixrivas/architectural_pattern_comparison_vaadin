package architecturalpatterncomparison.model.entities;

public class CharacterInfoResult {
private Info info;
private Character[] results;




	public Info getInfo() {
	return info;
}


public void setInfo(Info info) {
	this.info = info;
}


public Character[] getResults() {
	return results;
}


public void setResults(Character[] results) {
	this.results = results;
}


public class Info{
	
	private int count;
	private int pages;
	private String next;
	private String prev; 
	/*   "count": 671,
	    "pages": 34,
	    "next": "https://rickandmortyapi.com/api/character/?page=20",
	    "prev": "https://rickandmortyapi.com/api/character/?page=18"
	  },*/
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public String getNext() {
		return next;
	}
	public void setNext(String next) {
		this.next = next;
	}
	public String getPrev() {
		return prev;
	}
	public void setPrev(String prev) {
		this.prev = prev;
	}
	
	
	
	
	
}
	
	
}