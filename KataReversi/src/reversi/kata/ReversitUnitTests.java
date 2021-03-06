package reversi.kata;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class ReversitUnitTests {
	Reversi game;
	@Before
	public void initTests(){
		this.game= new Reversi();
	}
	@Test
	public void shouldSuccessOnDirectionUpDownLeftRight() {
		String input= 
				". . . . . . . .\n" +
				". . . . . . . .\n" +
				". . . . . . . .\n" +
				". . . B W . . .\n" +
				". . . W B . . .\n" +
				". . . . . . . .\n" +
				". . . . . . . .\n" +
				". . . . . . . .\n" + 
				"B";
		String output=
				". . . . . . . . \n" +
			    ". . . . . . . . \n" +
			    ". . . . 0 . . . \n" +
			    ". . . B W 0 . . \n" +
			    ". . 0 W B . . . \n" +
			    ". . . 0 . . . . \n" +
			    ". . . . . . . . \n" +
			    ". . . . . . . . \n" +
			    "B";
		
		assertEquals(output,this.game.printLegalMoves(input));
	}
	
	@Test
	public void shouldSuccessOnDirectionAntiSlashUp() {
		String input= 
				". . . . . . . .\n" +
				". . . . . . . .\n" +
				". . . . . . . .\n" +
				". . . B W . . .\n" +
				". . . W W . . .\n" +
				". . . . . . . .\n" +
				". . . . . . . .\n" +
				". . . . . . . .\n" + 
				"B";
		String output=
				". . . . . . . . \n" +
			    ". . . . . . . . \n" +
			    ". . . . . . . . \n" +
			    ". . . B W 0 . . \n" +
			    ". . . W W . . . \n" +
			    ". . . 0 . 0 . . \n" +
			    ". . . . . . . . \n" +
			    ". . . . . . . . \n" +
			    "B";

		assertEquals(output,this.game.printLegalMoves(input));
	}
	@Test
	public void shouldSuccessOnDirectionAntiSlashDown() {
		String input= 
				". . . . . . . .\n" +
				". . . . . . . .\n" +
				". . . . . . . .\n" +
				". . . W B . . .\n" +
				". . . W B . . .\n" +
				". . . W B . . .\n" +
				". . . . . . . .\n" +
				". . . . . . . .\n" + 
				"B";
		String output=
				". . . . . . . . \n" +
			    ". . . . . . . . \n" +
			    ". . 0 . . . . . \n" +
			    ". . 0 W B . . . \n" +
			    ". . 0 W B . . . \n" +
			    ". . 0 W B . . . \n" +
			    ". . 0 . . . . . \n" +
			    ". . . . . . . . \n" +
			    "B";
		assertEquals(output,game.printLegalMoves(input));
	}
	@Test
	public void shouldSuccessOnTestAntislashDown() {
		String input= 
				". . . . . . . .\n" +
				". . . . . . . .\n" +
				". . . . . . . .\n" +
				". . . W B . . .\n" +
				". . . W B . . .\n" +
				". . . . . . . .\n" +
				". . . . . . . .\n" +
				". . . . . . . .\n" + 
				"B";
		String output=
				". . . . . . . . \n" +
			    ". . . . . . . . \n" +
			    ". . 0 . . . . . \n" +
			    ". . 0 W B . . . \n" +
			    ". . 0 W B . . . \n" +
			    ". . 0 . . . . . \n" +
			    ". . . . . . . . \n" +
			    ". . . . . . . . \n" +
			    "B";
		assertEquals(output,this.game.printLegalMoves(input));
	}
}
