package intro_Dfs_Bfs;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.lang.Object;	

public class K_Cores {

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
		graph.adjListArray[dest].add(src);
	}
	
	static void findCores(int k,int v,Graph graph){
		boolean visited[] = new boolean[v];		
		
		int vDegree[] = new int[v];
		
		for(int i=0;i<v;i++){
			vDegree[i] = graph.adjListArray[i].size();
		}

		Dfs_Util(0,graph,visited,vDegree,k);
		
		for(int i=0;i<v;i++){
			if(!visited[i])
				Dfs_Util(i,graph,visited,vDegree,k);
		}
		
		for(int j=0;j<v;j++){
			if(vDegree[j]>=k){
				
				System.out.print("["+j+"]");
				Iterator<Integer> itr = graph.adjListArray[j].listIterator();
				while(itr.hasNext()){
					int n = itr.next();
					if(vDegree[n]>=k){
						System.out.print(" -> "+n);
					}
				}
				System.out.print("\n");
			}}}
	
	static boolean Dfs_Util(int start,Graph graph,boolean visited[],int vDegree[],int k){
		visited[start] = true;
		Iterator<Integer> itr = graph.adjListArray[start].listIterator();
		while(itr.hasNext()){
			int n = itr.next();
			if(vDegree[start]<k)
				vDegree[n]--;
			
			if(!visited[n]){
				if(Dfs_Util(n,graph,visited,vDegree,k))
					vDegree[start]--;
			}
		}
		return (vDegree[start]<k);
	}
	
	public static void main(String[] args) {
		int v = 9;
		int k = 3;
		Graph graph = new Graph(v);
		
		
		addEdge(graph,0, 1); 
		addEdge(graph,0, 2); 
	    addEdge(graph,1, 2); 
	    addEdge(graph,1, 5); 
	    addEdge(graph,2, 3); 
	    addEdge(graph,2, 4); 
	    addEdge(graph,2, 5); 
	    addEdge(graph,2, 6); 
	    addEdge(graph,3, 4); 
	    addEdge(graph,3, 6); 
	    addEdge(graph,3, 7); 
	    addEdge(graph,4, 6); 
	    addEdge(graph,4, 7); 
	    addEdge(graph,5, 6); 
	    addEdge(graph,5, 8); 
	    addEdge(graph,6, 7); 
	    addEdge(graph,6, 8); 
	    
	    findCores(k,v,graph);

	}

}
