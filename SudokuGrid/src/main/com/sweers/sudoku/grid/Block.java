package main.com.sweers.sudoku.grid;

import java.util.ArrayList;
import java.util.List;


public class Block extends Grid{
	
	public Block(int rowCount, int columnCount) {
		super(rowCount, columnCount);		
	}
	
	void add(int row, int column, Cell cell) {
		rows.get(row).add(cell);
		columns.get(column).add(cell);
	}
	
	void removeOption(Character option) throws IllegalStateException {
		for(CellList row: rows) {
			for(Cell cell: row.getCells()) {
				cell.removeOption(option);
			}
		}
	}
	
	public boolean contains(Character value) {
		for(CellList row: getRows()) {
			for(Cell cell : row.getCells()) {
				if(cell.getValue() == value) {
					return true;
				}
			}
		}
		return false;
	}
	
	public List<Cell> getCellsContainingOption(Character value) {
		List<Cell> cells = new ArrayList<Cell>();
		for(CellList row : rows) {
			for(Cell cell : row.getCells()){
				if(cell.isOption(value)){
					cells.add(cell);
				}
			}
		}
		return cells;
	}
}
