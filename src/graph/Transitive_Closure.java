package intro_Dfs_Bfs;


import java.util.Arrays;
import java.util.LinkedList;

public class Transitive_Closure {
	
	 private static int[][] tc = new int[4][4]; 
	 
	static class Graph{
		int v;
		LinkedList<Integer> adjListArray[];
		Graph(int v){
			this.v = v;
			adjListArray = new LinkedList[v];
			for(int i=0;i<v;i++){
				adjListArray[i] = new LinkedList<>();
			}
		}
	}
	
	
	static void addEdge(Graph graph,int src,int dest){
		graph.adjListArray[src].add(dest);
	}
	
	static void transitiveClosure(Graph graph,int v){
		for(int i=0;i<v;i++){
			Clsr_Util(i,i,graph);
		}
		for (int i = 0; i < v; i++) { 
	          System.out.println(Arrays.toString(tc[i])); 
	        } 
	}
	
	
	static void Clsr_Util(int s,int p,Graph graph){
		tc[s][p] = 1;
		
		for(int a:graph.adjListArray[p]){
			if(tc[s][a]==0)
				Clsr_Util(s,a,graph);
		}
		
	}
	
	public static void main(String[] args) {
		int v = 4;
		Graph graph = new Graph(v);
		
		addEdge(graph,0, 1); 
		addEdge(graph,0, 2); 
		addEdge(graph,1, 2); 
		addEdge(graph,2, 0); 
		addEdge(graph,2, 3); 
		addEdge(graph,3, 3);
		
		transitiveClosure(graph,v);
		
	}
}
