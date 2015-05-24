package test.com.sweers.sudoku.grid;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import main.com.sweers.sudoku.grid.Cell;
import main.com.sweers.sudoku.grid.CellList;
import main.com.sweers.sudoku.grid.Puzzle;

import org.junit.Before;
import org.junit.Test;

public class CellTest {

		
	Cell cell;
	
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
		cell = puzzle.getCell(0, 0);
    }
    
	@Test
	public void throwsExceptionWhenSettingDuplicateValueTest() throws Exception {
		cell.setValue('9');
		assertTrue(cell.isSet());
		
		for(Cell testCell : cell.getRow().getCells()) {
		    try {
				testCell.setValue('9');
		        fail("Should throw an exception when trying to set an invalid value");
		    } catch (Exception e) {
		        assertThat(e, instanceOf(IllegalStateException.class));
		        assertThat(e.getMessage(), containsString("is an Invalid value for this Cell"));
		    }
		}
		
		for(Cell testCell : cell.getColumn().getCells()) {
		    try {
				testCell.setValue('9');
		        fail("Should throw an exception when trying to set an invalid value");
		    } catch (Exception e) {
		        assertThat(e, instanceOf(IllegalStateException.class));
		        assertThat(e.getMessage(), containsString("is an Invalid value for this Cell"));
		    }
		}

		for(CellList row : cell.getBlock().getRows()) {
			for(Cell testCell : row.getCells()) {
			    try {
					testCell.setValue('9');
			        fail("Should throw an exception when trying to set an invalid value");
			    } catch (Exception e) {
			        assertThat(e, instanceOf(IllegalStateException.class));
			        assertThat(e.getMessage(), containsString("is an Invalid value for this Cell"));
			    }
			}
		}
		
		assertTrue(cell.getOptions().size() == 0);
	}
	
	@Test (expected = IllegalStateException.class)
	public void throwsExceptionWhenSettingSingleCellMultipleTimesTest() throws Exception {
		cell.setValue('9');	
		cell.setValue('4');
	}
	
	@Test
	public void removeOptionTest() throws Exception {
		cell.setValue('9');
		assertTrue(cell.isSet());
		
		for(Cell testCell : cell.getRow().getCells()) {
			assertFalse(testCell.isOption('9'));
		}
		
		for(Cell testCell : cell.getColumn().getCells()) {
			assertFalse(testCell.isOption('9'));
		}

		for(CellList row : cell.getBlock().getRows()) {
			for(Cell testCell : row.getCells()) {
				assertFalse(testCell.isOption('9'));
			}
		}
	}

	@Test
	public void invalidValueTest() {
		cell.setValue('9');
		
		for(Cell testCell : cell.getRow().getCells()) {
			assertFalse(testCell.isValid('9'));
		}
		for(Cell testCell : cell.getColumn().getCells()) {
			assertFalse(testCell.isValid('9'));
		}
		for(CellList row : cell.getBlock().getRows()) {
			for(Cell testCell : row.getCells()) {
				assertFalse(testCell.isValid('9'));
			}
		}
	}
}
