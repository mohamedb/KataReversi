package reversi.kata;

public class Reversi {
	String[] input_to_lines;
	String[][] lines_to_dots= new String[10][];
	Integer[][] enemy_xy=new Integer[8][2];
	String direction="";
	int count_nearby=0;

	public void inputToMatrix(String input){
		String[] input_to_lines= input.split("\n");	
		for(int i=0;i<9;i++){
			lines_to_dots[i]=input_to_lines[i].split(" ");
		}
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
			getDirection(i,j,this.enemy_xy[m][0],this.enemy_xy[m][1]);
			if(isFriendInDirection(this.enemy_xy[m][0],this.enemy_xy[m][1])){
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
	public boolean isFriendInDirection(int x,int y){

		if(this.direction.equals("right")){
			int k=y;
			int h=x;
			while(k<8){
				k++;
				if(lines_to_dots[x][k].equals("."))
					return false;
				else if(lines_to_dots[x][k].equals("B"))
					return true;

			}
		}

		if(this.direction.equals("left")){
			int k=y;
			int h=x;
			while(k>0){
				k--;
				if(lines_to_dots[x][k].equals("."))
					return false;
				else if(lines_to_dots[x][k].equals("B"))
					return true;

			}
		}

		else if(this.direction.equals("up")){
			int k=y;
			int h=x;
			while(h>0){
				h--;
				if(lines_to_dots[h][y].equals("."))
					return false;
				else if(lines_to_dots[h][y].equals("B"))
					return true;

			}
		}

		else if(this.direction.equals("down")){
			int k=y;
			int h=x;
			while(h<8){
				h++;
				if(lines_to_dots[h][y].equals("."))
					return false;
				else if(lines_to_dots[h][y].equals("B"))
					return true;

			}
		}

		else if(this.direction.equals("antislash_up")){
			int k=y;
			int h=x;
			while(h>0 || k>0){
				k--;
				h--;
				if(lines_to_dots[h][k].equals("."))
					return false;
				else if(lines_to_dots[h][k].equals("B"))
					return true;

			}
		}

		else if(this.direction.equals("antislash_down")){
			int k=y;
			int h=x;
			while(h<8 || k<8){
				k++;
				h++;
				if(lines_to_dots[h][k].equals("."))
					return false;
				else if(lines_to_dots[h][k].equals("B"))
					return true;

			}
		}

		else if(this.direction.equals("slash_down")){
			int k=y;
			int h=x;
			while(h<8 || k>0){
				k--;
				h++;
				if(lines_to_dots[h][k].equals("."))
					return false;
				else if(lines_to_dots[h][k].equals("B"))
					return true;

			}
		}

		else if(this.direction.equals("slash_up")){
			int k=y;
			int h=x;
			while(h>0 || k<8){
				k++;
				h--;
				if(lines_to_dots[h][k].equals("."))
					return false;
				else if(lines_to_dots[h][k].equals("B"))
					return true;

			}
		}

		return false;
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
	public void getDirection(int i,int j,int x, int y){
		if(i==x && y==j-1)
			this.direction="left";
		else if(i==x && y==j+1)
			this.direction="right";
		else if(x==i-1 && y==j)
			this.direction="up";
		else if(x==i+1 && y==j)
			this.direction="down";
		else if(x==i-1 && y==j-1)
			this.direction="antislash_up";
		else if(x==i+1 && y==j+1)
			this.direction="antislash_down";
		else if(x==i-1 && y==j+1)
			this.direction="slash_up";
		else if(x==i+1 && y==j-1)
			this.direction="slash_down";

	}


}
