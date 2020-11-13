package Othello;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GameTest {
	Game othello;

	@Before
	public void setUp() throws Exception {
		othello = new Game();
	}

	@Test
	public void GameConstructorTest() {
		Player player1 = othello.getPlayers()[0];
		Player player2 = othello.getPlayers()[1];
		
		assertEquals(Color.Black, player1.getColor());
		assertEquals(Color.White, player2.getColor());
	}
}
