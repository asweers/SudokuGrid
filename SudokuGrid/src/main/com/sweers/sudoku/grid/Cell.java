package main.com.sweers.sudoku.grid;

import java.util.ArrayList;
import java.util.List;

public class Cell {

	private Character value;
	final private List<Character> options;
	final private CellList row;
	final private CellList column;
	final private Block block;
	
	public Cell(List<Character> options, CellList row, CellList column, Block block) {
		this.options = new ArrayList<Character>(options);
		
		this.row = row;
		this.column = column;
		this.block = block;
	}
	
	/**
	 * Returns the Character value of the Cell. If the cell is not set it will 
	 * return null
	 * 
	 * @return the cells value
	 */
	public Character getValue() {
		return value;
	}
	
	/**
	 * Returns a List of possible Cell value options. If the Cells value is 
	 * already set then the list returned will be empty.
	 * 
	 * @return list of possible options
	 */
	public List<Character> getOptions() {
		return options;
	}
	
	/**
	 * Returns the row of cells that this cell resides in
	 * 
	 * @return cell's row
	 */
	public CellList getRow() {
		return row;
	}

	/**
	 * Returns the column of cells that this cell resides in
	 * 
	 * @return cell's column
	 */
	public CellList getColumn() {
		return column;
	}

	/**
	 * Returns the block of cells that this cell resides in
	 * 
	 * @return cell's block
	 */
	public Block getBlock() {
		return block;
	}

	/**
	 * Removes a value from the list of possible options.
	 * 
	 * @param option the option being removed
	 */
	void removeOption(Character option) {
		options.remove(option);
		//TODO look into throwing exception when options is empty, but value is not set?
	}
		
	/**
	 * Returns true if it is a valid option.
	 * 
	 * @param option the option being checked
	 * @return true if it's a valid option
	 */
	public boolean isOption(Character option) {
		return options.contains(option);
	}

	/**
	 * Returns true if the cell's value has been set and false if not.
	 * 
	 * @return true if the cell value has been set
	 */
	public boolean isSet() {
		if(value == null) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * Checks to see if value is a valid option. If it is a valid option the 
	 * Cells option list is emptied. The value is also removed from the options
	 * list of the cells within the row, column, and block. If the option is 
	 * invalid then an exception is thrown.
	 * 
	 * @param value the value of the cell
	 * @throws IllegalStateException if the value is not a valid option for the cell. 
	 */
	public void setValue(Character value) throws IllegalStateException {
		if(isValid(value)) {
			this.value = value;
			options.clear();

			row.removeOption(value);
			column.removeOption(value);
			block.removeOption(value);
		} else {
			throw new IllegalStateException(value + " is an Invalid value for this Cell");
		}
	}
	
	/**
	 * Returns true if the value is a valid option. Returns false if the Cell's 
	 * value is already set or it is not a valid option.
	 * 
	 * @param value the value being checked
	 * @return true if the value is a valid option
	 */
	public boolean isValid(Character value){
		if(isSet()){
			//TODO Check if adding this logic broke anything.
			return false;
		}
		if(row.contains(value) || column.contains(value) || block.contains(value)) {
				if(isSet() && getValue() == value){
					return true;
				}
				return false;
		} else {
			return true;
		}
	}

}
