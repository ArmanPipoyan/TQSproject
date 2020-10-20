package Othello;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DiskTest {

	Disk white_disk;
	Disk black_disk;
	@Before
	public void setUp() throws Exception {
		white_disk = new Disk(Color.White);
		black_disk = new Disk(Color.Black);
	}

	@Test
	public void changeColorTest() {
		white_disk.changeColor();
		assertEquals(Color.Black, white_disk.getColor());
		black_disk.changeColor();
		assertEquals(Color.White, black_disk.getColor());
		
	}

}
