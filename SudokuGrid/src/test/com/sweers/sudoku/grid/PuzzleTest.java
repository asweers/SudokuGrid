package test.com.sweers.sudoku.grid;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import main.com.sweers.sudoku.grid.Puzzle;

import org.junit.Before;
import org.junit.Test;

public class PuzzleTest {

	Puzzle puzzle;
	
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
    	
		puzzle = new Puzzle(9, 9, 3, 3, options);
    }
	
	@Test
	public void puzzleBuildTest() throws IllegalStateException {
		puzzle.setCell(0, 0, '1');
		assertEquals(puzzle.getRow(0).getCell(0).getValue(), new Character('1'));
		assertEquals(puzzle.getColumn(0).getCell(0).getValue(), new Character('1'));
		assertEquals(puzzle.getBlock(0, 0).getCell(0, 0).getValue(), new Character('1'));
			
		puzzle.setCell(1, 7, '5');
		assertEquals(puzzle.getRow(1).getCell(7).getValue(), new Character('5'));
		assertEquals(puzzle.getColumn(7).getCell(1).getValue(), new Character('5'));
		assertEquals(puzzle.getBlock(0, 2).getCell(1, 1).getValue(), new Character('5'));
		

		puzzle.setCell(3, 5, '7');
		assertEquals(puzzle.getRow(3).getCell(5).getValue(), new Character('7'));
		assertEquals(puzzle.getColumn(5).getCell(3).getValue(), new Character('7'));
		assertEquals(puzzle.getBlock(1, 1).getCell(0, 2).getValue(), new Character('7'));

		puzzle.setCell(8, 2, '8');
		assertEquals(puzzle.getRow(8).getCell(2).getValue(), new Character('8'));
		assertEquals(puzzle.getColumn(2).getCell(8).getValue(), new Character('8'));
		assertEquals(puzzle.getBlock(2, 0).getCell(2, 2).getValue(), new Character('8'));
	}
    
}
