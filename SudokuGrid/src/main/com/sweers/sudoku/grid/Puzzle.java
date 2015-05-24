package main.com.sweers.sudoku.grid;

import java.util.ArrayList;
import java.util.List;


public class Puzzle extends Grid {

	final private List<List<Block>> blocks;
	final private List<Character> options;
	

	public Puzzle(Puzzle puzzle) throws IllegalStateException {
		this(puzzle.getRows().size(),
			puzzle.getColumns().size(),
			puzzle.getBlock(0, 0).getRows().size(),
			puzzle.getBlock(0, 0).getColumns().size(),
			puzzle.getOptions()
		);
		
		for(CellList row : puzzle.getRows()) {
			for(Cell cell : row.getCells()) {
				if(cell.isSet()) {
					setCell(cell.getRow().getIndex(), cell.getColumn().getIndex(), cell.getValue());
				}
			}
		}
	}
	
	public Puzzle(int rowCount, int columnCount, int blockRowCount, int blockColumnCount, List<Character> options) {
		super(rowCount, columnCount);
		this.blocks = new ArrayList<List<Block>>();
		this.options = new ArrayList<Character>(options);

		for(int r=0; r<rowCount/blockRowCount; r++) {
			List<Block> blockRow = new ArrayList<Block>();
			
			for(int c=0; c<columnCount/blockColumnCount; c++) {
				blockRow.add(new Block(blockRowCount, blockColumnCount));
			}
			blocks.add(blockRow);
		}
			
		for(int r=0; r<rowCount; r++) {
			CellList row = rows.get(r);
			
			for(int c=0; c<columnCount; c++) {
				CellList column = columns.get(c);
				Block block = blocks.get(r/blockRowCount).get(c/blockColumnCount);
				
				Cell cell = new Cell(options, row, column, block);
				
				row.add(cell);
				column.add(cell);
				block.add(r%blockRowCount, c%blockColumnCount, cell);
			}
		}
		
	}

	public List<List<Block>> getBlocks() {
		return blocks;
	}
	
	public Block getBlock(int row, int column) {
		return blocks.get(row).get(column);
	}
	
	public List<Character> getOptions() {
		return options;
	}

}
