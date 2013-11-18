package reversi.kata;

public class Board {
	private String[] input_to_lines;
	private String[][] lines_to_cells= new String[10][];
    private Cell[][] table_of_cells=new Cell[10][];
    
    
    public void setInput(String input){
    	this.input_to_lines=input.split("\n");
    }
    
	public void setLinetoCells(){	
	for(int i=0;i<9;i++){
		lines_to_cells[i]=input_to_lines[i].split(" ");
	}
	}
	
	public void setCells(){
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				this.table_of_cells[i][j].setRow(i);
				this.table_of_cells[i][j].setColumn(j);
				this.table_of_cells[i][j].setContent(lines_to_cells[i][j]);
				
		}
		}
		
	}
	
	
	public Cell[][] getCells(){
		return this.table_of_cells;
	}
	
	

}
