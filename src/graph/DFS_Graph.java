package intro_Dfs_Bfs;

import java.util.Iterator;
import java.util.LinkedList;

public class DFS_Graph {
	
	private int v;
	private LinkedList<Integer> adjListArray[];
	
	DFS_Graph(int v){
		this.v = v;
		adjListArray = new LinkedList[v];
		for(int i=0;i<v;i++){
			adjListArray[i] = new LinkedList<>();
		}
				
	}
	
	 void addEdge(int src ,int dest){
		adjListArray[src].add(dest);
	}
	 
	void dfs(int start){
		boolean visited[] = new boolean[v];
		dfsUtil(start,visited);
		
	}
	
	void dfsUtil(int start, boolean visited[]){
		visited[start] = true;
		System.out.print(start+" ");
		Iterator<Integer> itr = adjListArray[start].listIterator();
		while(itr.hasNext()){
			int n = itr.next();
			if(!visited[n]){
				dfsUtil(n,visited);
			}			
		}
	}
	
	
	public static void main(String[] args) {
		int v = 4;
		DFS_Graph graph = new DFS_Graph(v);
		
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);
		
		graph.dfs(2);

	}

}
