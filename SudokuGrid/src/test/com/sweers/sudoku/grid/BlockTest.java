package test.com.sweers.sudoku.grid;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import main.com.sweers.sudoku.grid.Block;
import main.com.sweers.sudoku.grid.Puzzle;

import org.junit.Before;
import org.junit.Test;

public class BlockTest {

	Block block;
	
    @Before
    public void setUp() {
		List<Character> options = new ArrayList<Character>();
    	options.add('1');
    	options.add('2');
    	options.add('3');
    	options.add('4');
    	options.add('5');
    	options.add('6');
    	options.add('7');
    	options.add('8');
    	options.add('9');
    	
		Puzzle puzzle = new Puzzle(9, 9, 3, 3, options);
		block = puzzle.getBlock(0, 0);
    }

	@Test
	public void setCellRemovesOptionFromBlockTest() {
		block.getCell(0, 0).setValue('9');

		assertEquals(block.getCellsContainingOption('9').size(), 0);
	}
   
	@Test
	public void blockConfirmsSetValuesTest() {
		block.getCell(0, 0).setValue('1');
		block.getCell(0, 1).setValue('3');
		block.getCell(1, 0).setValue('4');
		block.getCell(2, 0).setValue('7');
		block.getCell(2, 2).setValue('9');

		assertTrue(block.contains('1'));
		assertFalse(block.contains('2'));
		assertTrue(block.contains('3'));
		assertTrue(block.contains('4'));
		assertFalse(block.contains('5'));
		assertFalse(block.contains('6'));
		assertTrue(block.contains('7'));
		assertFalse(block.contains('8'));
		assertTrue(block.contains('9'));
	}
}
