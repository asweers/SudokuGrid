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
	
	public boolean contains(Cell cell) {
		for(CellList row: getRows()) {
			for(Cell blockCell : row.getCells()) {
				if(blockCell == cell) {
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
	
	public List<CellList> getRowsContainingOption(Character value) {
		List<CellList> rowList = new ArrayList<CellList>();
		for(CellList row : rows) {
			if(row.getCellsContainingOption(value).size() > 0){
				rowList.add(row);
			}
		}
		return rowList;
	}
	
	public List<CellList> getColumnsContainingOption(Character value) {
		List<CellList> columnList = new ArrayList<CellList>();
		for(CellList column : columns) {
			if(column.getCellsContainingOption(value).size() > 0){
				columnList.add(column);
			}
		}
		return columnList;
	}
}
