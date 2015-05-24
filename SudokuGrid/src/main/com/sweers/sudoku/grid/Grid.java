package main.com.sweers.sudoku.grid;

import java.util.ArrayList;
import java.util.List;

abstract public class Grid {

	final List<CellList> rows;
	final List<CellList> columns;
	
	public Grid(int rowCount, int columnCount) {
		rows = new ArrayList<CellList>();
		columns = new ArrayList<CellList>();
	
		for(int r=0; r<rowCount; r++) {
			rows.add(new CellList(r));
		}
		for(int c=0; c<columnCount; c++) {
			columns.add(new CellList(c));
		}
	}

	public Cell getCell(int row, int column) {
		return rows.get(row).getCell(column);
	}
	
	public void setCell(int row, int column, Character value) throws IllegalStateException{
		rows.get(row).getCell(column).setValue(value);
	} 
	
	public CellList getRow(int index) {
		return rows.get(index);
	}
	public List<CellList> getRows() {
		return rows;
	}
	
	public CellList getColumn(int index) {
		return columns.get(index);
	}	
	
	public List<CellList> getColumns() {
		return columns;
	}
	
}
