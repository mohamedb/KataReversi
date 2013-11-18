package reversi.kata;

public class Reversi {
	String[] input_to_lines;
	String[][] lines_to_dots= new String[10][];
	Integer[][] enemy_xy=new Integer[8][2];
	String direction="";
	int count_nearby=0;
	Direction in_direction;
	 
     
	public void inputToMatrix(String input){
		String[] input_to_lines= input.split("\n");	
		for(int i=0;i<9;i++){
			lines_to_dots[i]=input_to_lines[i].split(" ");
		}
		 in_direction= new Direction(lines_to_dots);
		}
	public  String printLegalMoves(String input) {
		this.inputToMatrix(input);
		for(int i=1;i<7;i++){
			for(int j=1;j<7;j++){	 
				if(lines_to_dots[i][j].equals(".")){
					this.scanNearby(i, j);
				}
			}
		}
		return newOutput();
	}
	public void scanNearby(int i, int j){
		if(isEnemyNearby("B",i,j)){
			this.addPossibleMove(i, j);
			this.count_nearby=0;
		}
	}
	public void addPossibleMove(int i, int j){
		for(int m=0;m<this.count_nearby;m++){
			in_direction.getDirection(i,j,this.enemy_xy[m][0],this.enemy_xy[m][1]);
			if(in_direction.isFriendInDirection(this.enemy_xy[m][0],this.enemy_xy[m][1])){
				this.lines_to_dots[i][j]="0";
			}
		}
	}
	public String newOutput(){
		String output="";
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){	 
				output=output+lines_to_dots[i][j]+" ";
			}
			output=output+"\n";
		}
		output=output+"B";
		return output;
	}
	
	public boolean isEnemyNearby(String WorB,int ligne,int colonne) {	
		for(int i=-1;i<2;i++){
			for(int j=-1;j<2;j++){
				if(lines_to_dots[ligne+i][colonne+j].equals("W")){
					this.enemy_xy[this.count_nearby][0]=ligne+i;
					this.enemy_xy[this.count_nearby][1]=colonne+j;
					this.count_nearby++;
				}
			}
		}
		if(this.count_nearby>0)
			return true;
		return false;
	}

}
