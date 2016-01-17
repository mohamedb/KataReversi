package reversi.kata;

public class Direction {
   
   String name="left";
   boolean find_friend=false;
   String[][] linesToDotes= new String[10][];
   
   
   public Direction(String[][] linesToDotes){
	   this.linesToDotes= linesToDotes;
   }

   public boolean isFriendInDirection(int x,int y){

		if(this.name.equals("right")){
			int k=y;
			int h=x;
			while(k<8){
				k++;
				return (linesToDotes[x][k].equals("."))
					||(linesToDotes[x][k].equals("B"));
					

			}
		}

		if(this.name.equals("left")){
			int k=y;
			int h=x;
			while(k>0){
				k--;
				return(linesToDotes[x][k].equals("."))
					||(linesToDotes[x][k].equals("B"));
					 

			}
		}

		else if(this.name.equals("up")){
			int k=y;
			int h=x;
			while(h>0){
				h--;
				if(linesToDotes[h][y].equals("."))
					return false;
				else if(linesToDotes[h][y].equals("B"))
					return true;

			}
		}

		else if(this.name.equals("down")){
			int k=y;
			int h=x;
			while(h<8){
				h++;
				if(linesToDotes[h][y].equals("."))
					return false;
				else if(linesToDotes[h][y].equals("B"))
					return true;

			}
		}

		else if(this.name.equals("antislash_up")){
			int k=y;
			int h=x;
			while(h>0 || k>0){
				k--;
				h--;
				if(linesToDotes[h][k].equals("."))
					return false;
				else if(linesToDotes[h][k].equals("B"))
					return true;

			}
		}

		else if(this.name.equals("antislash_down")){
			int k=y;
			int h=x;
			while(h<8 || k<8){
				k++;
				h++;
				if(linesToDotes[h][k].equals("."))
					return false;
				else if(linesToDotes[h][k].equals("B"))
					return true;

			}
		}

		else if(this.name.equals("slash_down")){
			int k=y;
			int h=x;
			while(h<8 || k>0){
				k--;
				h++;
				if(linesToDotes[h][k].equals("."))
					return false;
				else if(linesToDotes[h][k].equals("B"))
					return true;

			}
		}

		else if(this.name.equals("slash_up")){
			int k=y;
			int h=x;
			while(h>0 || k<8){
				k++;
				h--;
				if(linesToDotes[h][k].equals("."))
					return false;
				else if(linesToDotes[h][k].equals("B"))
					return true;

			}
		}

		return false;
	}

	public void getDirection(int i,int j,int x, int y){
		if(i==x && y==j-1)
			this.name="left";
		else if(i==x && y==j+1)
			this.name="right";
		else if(x==i-1 && y==j)
			this.name="up";
		else if(x==i+1 && y==j)
			this.name="down";
		else if(x==i-1 && y==j-1)
			this.name="antislash_up";
		else if(x==i+1 && y==j+1)
			this.name="antislash_down";
		else if(x==i-1 && y==j+1)
			this.name="slash_up";
		else if(x==i+1 && y==j-1)
			this.name="slash_down";

	}
}
