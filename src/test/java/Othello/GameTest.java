package Othello;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Othello.Color;
import Othello.Game;
import Othello.Player;

public class GameTest {
	Game othello;

	@Before
	public void setUp() throws Exception {
		othello = new Game();
	}

	@Test
	public void GameConstructorTest() {
		Player player1 = othello.getPlayer(0);
		Player player2 = othello.getPlayer(1);
		
		assertEquals(Color.Black, player1.getColor());
		assertEquals(Color.White, player2.getColor());
	}
}
