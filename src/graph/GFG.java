package intro_Dfs_Bfs;

import java.util.LinkedList;

public class GFG {

	static class Graph{
		int v;
		LinkedList<Integer> adjListArray[];
		
		Graph(int v){
			this.v = v;
			adjListArray =  new LinkedList[v];
			
			for(int i=0;i<v;i++){
				adjListArray[i] = new LinkedList<>();
			}
		}
	}
	
	static void addEdge(Graph graph,int src,int dest){
		graph.adjListArray[src].add(dest);
		graph.adjListArray[dest].add(src);
	}
	
	static void printGraph(Graph graph, int v){
		for(int i=0;i<v;i++){
			System.out.println("Adjacency list of vertex "+i+" is....");
			System.out.print("Head");
			for(int a : graph.adjListArray[i]){
				System.out.print(" -> "+a);
			}
			System.out.println("\n");
		}
	}
	
	public static void main(String[] args) {
		int v = 5;
		
		Graph graph = new Graph(v);
		
		addEdge(graph, 0, 1);
		addEdge(graph, 0, 4);
		addEdge(graph, 1, 2);
		addEdge(graph, 1, 3);
		addEdge(graph, 1, 4);
		addEdge(graph, 2, 3);
		addEdge(graph, 3, 4);
		
		printGraph(graph,v);
		
	}

}
