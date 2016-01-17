package reversi.kata;

public class Reversi {
	String[] inputToLines;
	String[][] linesToDots= new String[10][];
	Integer[][] enemeyAtXY=new Integer[8][2];
	String direction="";
	int countNearby=0; 
	Direction inDirection;
	 
     
	public void inputToMatrix(String input){
		String[] inputToLines= input.split("\n");	
		for(int i=0;i<9;i++){
			linesToDots[i]=inputToLines[i].split(" ");
		}
		 inDirection= new Direction(linesToDots);
		}
	public  String printLegalMoves(String input) {
		this.inputToMatrix(input);
		for(int i=1;i<7;i++){
			for(int j=1;j<7;j++){	 
				if(linesToDots[i][j].equals(".")){
					this.scanNearby(i, j);
				}
			}
		}
		return newOutput();
	}
	public void scanNearby(int i, int j){
		if(isEnemyNearby("B",i,j)){
			this.addPossibleMove(i, j);
			this.countNearby=0;
		}
	}
	public void addPossibleMove(int i, int j){
		for(int m=0;m<this.countNearby;m++){
			inDirection.getDirection(i,j,this.enemeyAtXY[m][0],this.enemeyAtXY[m][1]);
			if(inDirection.isFriendInDirection(this.enemeyAtXY[m][0],this.enemeyAtXY[m][1])){
				this.linesToDots[i][j]="0";
			}
		}
	}
	public String newOutput(){
		String output="";
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){	 
				output=output+linesToDots[i][j]+" ";
			}
			output=output+"\n";
		}
		output=output+"B";
		return output;
	}
	
	public boolean isEnemyNearby(String WorB,int ligne,int colonne){
		countEnemyNearby(ligne,colonne);
		if(this.countNearby>0)
			return true;
		return false;
	}
	
	public void countEnemyNearby(int ligne,int colonne){
		for(int i=-1;i<2;i++){
			for(int j=-1;j<2;j++){
				if(linesToDots[ligne+i][colonne+j].equals("W")){
					this.enemeyAtXY[this.countNearby][0]=ligne+i;
					this.enemeyAtXY[this.countNearby][1]=colonne+j;
					this.countNearby++;
				}
			}
		}
	}

}
