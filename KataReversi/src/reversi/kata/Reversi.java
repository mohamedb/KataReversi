package reversi.kata;

public class Reversi {
	String[] input_to_lines;
	String[][] lines_to_dots= new String[10][];
	int enemy_x=-10,enemy_y=-10;
	String direction="";
	
	public  String printLegalMoves(String input) {
		String[] input_to_lines= input.split("\n");	
		for(int i=0;i<9;i++){
			lines_to_dots[i]=input_to_lines[i].split(" ");
		}
		for(int i=1;i<7;i++){
			for(int j=1;j<7;j++){	 
				if(lines_to_dots[i][j].equals(".")){
					if(isEnemyNearby("B",i,j)){
						getDirection(i,j,this.enemy_x,this.enemy_y);
					   if(isFriendInDirection()){
						   this.lines_to_dots[i][j]="0";
					   }
					}
				}
			}
		}
		/////////////////////////////////////////////////////////////////////////////////
		return newOutput();
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
    public boolean isFriendInDirection(){
    	
    	if(this.direction.equals("right")){
    		int k=this.enemy_y;
        	int h=this.enemy_x;
			while(k<8){
				k++;
				if(lines_to_dots[this.enemy_x][k].equals("."))
					return false;
				else if(lines_to_dots[this.enemy_x][k].equals("B"))
					return true;
				 
			}
		}
    	
    	if(this.direction.equals("left")){
    		int k=this.enemy_y;
        	int h=this.enemy_x;
			while(k>0){
				k--;
				if(lines_to_dots[this.enemy_x][k].equals("."))
					return false;
				else if(lines_to_dots[this.enemy_x][k].equals("B"))
					return true;
				 
			}
		}
    	
    	else if(this.direction.equals("up")){
    		int k=this.enemy_y;
        	int h=this.enemy_x;
			while(h>0){
				h--;
				if(lines_to_dots[h][this.enemy_y].equals("."))
					return false;
				else if(lines_to_dots[h][this.enemy_y].equals("B"))
					return true;
				 
			}
		}
    	
    	if(this.direction.equals("down")){
    		int k=this.enemy_y;
        	int h=this.enemy_x;
			while(h<8){
				h++;
				if(lines_to_dots[h][this.enemy_y].equals("."))
					return false;
				else if(lines_to_dots[h][this.enemy_y].equals("B"))
					return true;
				 
			}
		}
    	
    	if(this.direction.equals("antislash_up")){
    		int k=this.enemy_y;
        	int h=this.enemy_x;
			while(h>0 || k>0){
				k--;
				h--;
				if(lines_to_dots[h][k].equals("."))
					return false;
				else if(lines_to_dots[h][k].equals("B"))
					return true;
				 
			}
		}
    	
//    	if(this.direction.equals("antislash_down")){
//			while(h<8 || k<8){
//				k++;
//				h++;
//				if(lines_to_dots[h][k].equals("."))
//					return false;
//				else if(lines_to_dots[h][k].equals("B"))
//					return true;
//				 
//			}
//		}
//    	
//    	if(this.direction.equals("slash_down")){
//			while(h<8 || k>0){
//				k--;
//				h++;
//				if(lines_to_dots[h][k].equals("."))
//					return false;
//				else if(lines_to_dots[h][k].equals("B"))
//					return true;
//				 
//			}
//		}
//    	
//    	if(this.direction.equals("slash_up")){
//			while(h>0 || k<8){
//				k++;
//				h--;
//				if(lines_to_dots[h][k].equals("."))
//					return false;
//				else if(lines_to_dots[h][k].equals("B"))
//					return true;
//				 
//			}
//		}
//    	
    	return false;
    }
	public boolean isEnemyNearby(String WorB,int ligne,int colonne) {	
		for(int i=-1;i<2;i++){
			for(int j=-1;j<2;j++){
				if(lines_to_dots[ligne+i][colonne+j].equals("W")){
					 this.enemy_x=ligne+i;
					 this.enemy_y=colonne+j;
					 return true;
				}
			}
		}
		return false;
	}
	public void getDirection(int i,int j,int x, int y){
		if(i==x && y==j-1)
			this.direction="left";
		if(i==x && y==j+1)
			this.direction="right";
 		if(x==i-1 && y==j)
			this.direction="up";
		if(x==i+1 && y==j)
			this.direction="down";
		if(x==i-1 && y==j-1)
			this.direction="antislash_up";
		if(x==i+1 && y==j+1)
			this.direction="antislash_down";
		if(x==i-1 && y==j+1)
			this.direction="slash_up";
		if(x==i+1 && y==j-1)
			this.direction="slash_down";
			
	}
	
	 
}
