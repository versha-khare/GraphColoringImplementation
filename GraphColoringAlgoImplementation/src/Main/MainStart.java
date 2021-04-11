package Main;
import graphColoringAlgorithmsImpl.GraphColoringAlgoGreedyBFS;
import Graphmodules.GraphColors;
import Graphmodules.GraphFileIO;
import graphColoringAlgorithmsImpl.GraphColoringAlgoBackTracking;
import graphColoringAlgorithmsImpl.GraphColoringAlgoGreedyDFS;
import graphColoringAlgorithmsImpl.GraphColoringAlgoWelshPowell;
import graphImplemenation.Graph;
import graphImplemenation.GraphAdjcaListImpl;
import graphImplemenation.GraphAdjcaMatrixImpl;

public class MainStart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		String path = "src/Files/samplemyclei";
		//streamFileAndUpdateGraph(path);
		
		//find which graph should be implemented
		int numberOfVertices = GraphFileIO.GraphToCreate(path);
		Graph G;
		if (numberOfVertices == 0){
			G = GraphFileIO.readInputDataAndCreateGraph(path, new GraphAdjcaListImpl());
		}
		else {
			G = GraphFileIO.readInputDataAndCreateGraph(path, new GraphAdjcaMatrixImpl(numberOfVertices));
		}
		
		G.printAllVertexes();
		G.printGraph();
		G.setGraphColoringTechnique(new GraphColoringAlgoBackTracking());
		G.setGraphColoringTechnique(new GraphColoringAlgoGreedyBFS());
		G.setGraphColoringTechnique(new GraphColoringAlgoGreedyDFS());
		G.setGraphColoringTechnique(new GraphColoringAlgoWelshPowell());
		G.getGraphColoringObj().toggleShuffle();
		G.colorGraph();
		GraphColors.printColors(G);
		
		
		G.resetColors();
		
		for (int i = 1; i< 5; i++){
			if (G.isGraphColorable(i)){
				System.out.println("The Graph was fully colorable with number of colors = " + i);
			}
			else{
				System.out.println("The Graph was not fully colorable with number of colors = " + i);
			}
			GraphColors.printVertexCoverage(G, i);
			G.resetColors();
		}
		
		long end = System.currentTimeMillis(); 
		System.out.println("Total exection time =" + (end - start) + "millisec");
		/*
		 * G.setGraphColoringTechnique(new GraphColoringGreedyDFS()); G.colorGraph();
		 * Colors.printColors(G);
		 * 
		 * G.resetColors();
		 * 
		 * G.setGraphColoringTechnique(new GraphColoringGreedyBFS()); G.colorGraph();
		 * Colors.printColors(G);
		 */
	}
	
	
}
