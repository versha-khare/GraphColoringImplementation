package GraphColoringApplication;

import Graphmodules.GraphColors;
import Graphmodules.GraphFileIO;
import graphColoringAlgorithmsImpl.GraphColoringAlgoBackTracking;
import graphColoringAlgorithmsImpl.GraphColoringAlgoBackTrackingForSudoku;
import graphImplemenation.Graph;
import graphImplemenation.GraphAdjcaListImpl;

public class SudokuPuzzleSolver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "src/Files/sudoku";
		System.out.println("Sudoku Solver using backtracking Algorithm");
		Graph G = GraphFileIO.readInputSudokuAndCreateGraph(path, new GraphAdjcaListImpl());
		G.setGraphColoringTechnique(new GraphColoringAlgoBackTrackingForSudoku());
		G.colorGraph();
		GraphColors.printSudoku(G);
	}
	
}
