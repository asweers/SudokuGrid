package test.com.sweers.sudoku.grid;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	BlockTest.class,
	CellTest.class, 
	CellListTest.class,
	PuzzleTest.class 
})
public class AllTests {

}
