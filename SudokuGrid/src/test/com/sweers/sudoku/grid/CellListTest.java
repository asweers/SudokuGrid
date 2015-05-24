package test.com.sweers.sudoku.grid;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import main.com.sweers.sudoku.grid.CellList;
import main.com.sweers.sudoku.grid.Puzzle;

import org.junit.Before;
import org.junit.Test;

public class CellListTest {

	CellList row;
	
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
		row = puzzle.getRow(0);
    }

	@Test
	public void setCellRemovesOptionFromListTest() {
		row.getCell(0).setValue('9');

		assertEquals(row.getCellsContainingOption('9').size(), 0);
	}
   
	@Test
	public void listConfirmsSetValuesTest() {
		row.getCell(0).setValue('1');
		row.getCell(2).setValue('3');
		row.getCell(3).setValue('4');
		row.getCell(6).setValue('7');
		row.getCell(8).setValue('9');

		assertTrue(row.contains('1'));
		assertFalse(row.contains('2'));
		assertTrue(row.contains('3'));
		assertTrue(row.contains('4'));
		assertFalse(row.contains('5'));
		assertFalse(row.contains('6'));
		assertTrue(row.contains('7'));
		assertFalse(row.contains('8'));
		assertTrue(row.contains('9'));
	}
}
