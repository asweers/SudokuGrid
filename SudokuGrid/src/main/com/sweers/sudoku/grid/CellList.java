package main.com.sweers.sudoku.grid;

import java.util.ArrayList;
import java.util.List;

public class CellList {

	final private List<Cell> list;
	final private int index;
	
	public CellList(int index) {
		this.list = new ArrayList<Cell>();
		this.index = index;
	}
	
	public CellList(List<Cell> list, int index) {
		this.list = new ArrayList<Cell>(list);
		this.index = index;
	}
	
	public Cell getCell(int index) {
		return list.get(index);
	}
	
	public List<Cell> getCells() {
		return list;
	}
	
	public int getIndex() {
		return index;
	}
	
	public boolean contains(Character value) {
		for(Cell cell: list) {
			if(cell.getValue() == value) {
				return true;
			}
		}
		return false;
	}
	
	void removeOption(Character option) throws IllegalStateException {
		for(Cell cell: list) {
			cell.removeOption(option);
		}	
	}
	
	void add(Cell cell) {
		list.add(cell);
	}
	
	public List<Cell> getCellsContainingOption(Character value) {
		List<Cell> cells = new ArrayList<Cell>();
		for(Cell cell : list){
			if(cell.isOption(value)){
				cells.add(cell);
			}
		}
		return cells;
	}
	
}
