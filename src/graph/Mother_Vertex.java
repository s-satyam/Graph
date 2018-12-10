package intro_Dfs_Bfs;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class Mother_Vertex {

	
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
	
	static int find_Mother(Graph graph,int V){
		int m = 0;
		boolean visited[] = new boolean[V];
		
		for(int i=0;i<V;i++){
			if(!visited[i]){
				DFS_Util(graph,i,visited);
				m = i;
			}
			
		}
		
		Arrays.fill(visited, Boolean.FALSE);
		DFS_Util(graph,m,visited);
		for(int i=0;i<V;i++){
			if(!visited[i])
				return -1;
		}
		return m;
	}
		
	static void DFS_Util(Graph graph,int i,boolean visited[]){
		visited[i] = true;
		Iterator<Integer> itr = graph.adjListArray[i].listIterator();
		while(itr.hasNext()){
			int n = itr.next();
			if(!visited[n]){
				DFS_Util(graph,n,visited);
			}
		}
	}

	
	public static void main(String[] args) {
		
		Graph graph = new Graph(7);
		
	    addEdge(graph,0, 1); 
	    addEdge(graph,0, 2); 
	    addEdge(graph,1, 3); 
	    addEdge(graph,4, 1); 
	    addEdge(graph,6, 4); 
	    addEdge(graph,5, 6); 
	    addEdge(graph,5, 2); 
	    addEdge(graph,6, 0);
	    
	   int m = find_Mother(graph,7);
	   
	   System.out.print("mother vertex is "+m);
	    
	}
}

/*
 package intro_Dfs_Bfs;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class Mother_Vertex {
	
	private int v;
	private LinkedList<Integer> adjListArray[];
	
	Mother_Vertex(int v){
		this.v = v;
		adjListArray = new LinkedList[v];
		for(int i=0;i<v;i++){
			adjListArray[i] = new LinkedList<>();
		}
				
	}
	
	void addEdge(int src ,int dest){
		adjListArray[src].add(dest);
	}
	 
	int find_Mother(int V){
			int m = 0;
			boolean visited[] = new boolean[V];
			
			for(int i=0;i<V;i++){
				if(!visited[i]){
					DFS_Util(i,visited);
					m = i;
				}			
			}
			
			Arrays.fill(visited, Boolean.FALSE);
			DFS_Util(m,visited);
			for(int i=0;i<V;i++){
				if(!visited[i])
					return -1;
			}
			return m;
		}
			
		void DFS_Util(int i,boolean visited[]){
			visited[i] = true;
			Iterator<Integer> itr = adjListArray[i].listIterator();
			while(itr.hasNext()){
				int n = itr.next();
				if(!visited[n]){
					DFS_Util(n,visited);
				}
			}
		}
	 public static void main(String[] args) {
			int v = 7;
			Mother_Vertex graph = new Mother_Vertex(v);
			
			graph.addEdge(0, 1); 
			graph.addEdge(0, 2); 
			graph.addEdge(1, 3); 
			graph.addEdge(4, 1); 
			graph.addEdge(6, 4); 
			graph.addEdge(5, 6); 
			graph.addEdge(5, 2); 
			graph.addEdge(6, 0);
			
			int m = graph.find_Mother(v);
			   
			System.out.print("mother vertx is "+m);;

		}
}
 * */
