package intro_Dfs_Bfs;

import java.util.Iterator;
import java.util.LinkedList;

public class BFS {

	int v;
	LinkedList<Integer> adjListArray[];
	static class Graph{
		BFS bfs = new BFS();
		Graph(int v){			
			bfs.adjListArray = new LinkedList[v];
			for(int i=0;i<v;i++){
				bfs.adjListArray[i] = new LinkedList<>();
			}
		}
	}
	
	static void addEdge(Graph graph, int src, int dest){
		BFS bfs = new BFS();
		bfs.adjListArray[src].add(dest);
	}
	
	static void bfSearch(int start,int v){
		BFS bfs = new BFS();
		boolean visited[] = new boolean[v];
		LinkedList<Integer> dabba = new LinkedList<>();
		
		visited[start] = true;
		System.out.print(start+" ");
		dabba.add(start);
		
		while(dabba!=null){
			start = dabba.poll();
			Iterator<Integer> itr = bfs.adjListArray[start].listIterator();
			while(itr.hasNext()){
				int n = itr.next();
				if(!visited[n]){
					visited[n] = true;
					dabba.add(n);
					System.out.print(n+" ");
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		int v = 4;
		Graph graph = new Graph(v);
		
		addEdge(graph,0,1);
		addEdge(graph,0,2);
		addEdge(graph,1,2);
		addEdge(graph,2,0);
		addEdge(graph,2,3);
		addEdge(graph,3,3);
		
		bfSearch(2,v);
	}

}
