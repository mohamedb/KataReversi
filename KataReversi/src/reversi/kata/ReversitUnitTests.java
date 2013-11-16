package reversi.kata;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReversitUnitTests {

	
	@Test
	public void shouldSuccessDirectionAntiSlashUp() {
		String input= 
				". . . . . . . .\n" +
				". . B . . . . .\n" +
				". . . W . . . .\n" +
				". . . . . . . .\n" +
				". . . . . . . .\n" +
				". . . . . . . .\n" +
				". . . . . . . .\n" +
				". . . . . . . .\n" +
				"B";
		String output=
				". . . . . . . . \n" +
			    ". . B . . . . . \n" +
			    ". . . W . . . . \n" +
			    ". . . . 0 . . . \n" +
			    ". . . . . . . . \n" +
			    ". . . . . . . . \n" +
			    ". . . . . . . . \n" +
			    ". . . . . . . . \n" +
			    "B";
		Reversi game= new Reversi();
		assertEquals(output,game.printLegalMoves(input));
	}

}
