package reversi.kata;

public class Cell {

	////***Variables***/////
	private int column;
	private int row;
	private String content;
	
	
	////********Functions********/////
	public boolean isEmpty(){
		if(this.content.equals("."))
			return true;
		return false;
	}
	
	
	public void setColumn(int column) {
		this.column=column;
	}
	
	public void setRow(int row) {
		this.row=row;
	}
	
	public void setContent(String content) {
		this.content=content;
	}
	
	public int getColumn() {
		return this.column;
	}
	
	public int getRow() {
		return this.row;
	}
	
	public String getContent() {
		return this.content;
	}
	
}
