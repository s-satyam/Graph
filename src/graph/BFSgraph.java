package graph;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author SU393542
 */
public class BFSgraph {
    
    int v;
    LinkedList<Integer> list[];
    BFSgraph(int v){
        this.v = v;
        list = new LinkedList[v];
        for(int i=0;i<v;i++){
            list[i] = new LinkedList<>();
        }
    }
    void addEdge(int src, int dest){
        list[src].add(dest);
    }
    
    void BFS(int startP){
        boolean visited[] = new boolean [v];
        LinkedList<Integer> queue = new LinkedList<>();
        
        visited[startP] = true;
        queue.add(startP);
        
        while(queue.size()!=0){
            startP = queue.poll();
            System.out.println(startP+" ");
            
            Iterator<Integer> itr = list[startP].listIterator();
            while(itr.hasNext()){
                int n = itr.next();
                if(!visited[n]){
                    visited[n]=true;
                    queue.add(n);
                }
            }
        }
    }
    
//    static void printGraph(BFSgraph graph){
//        for(int i=0;i<graph.v;i++){
//            System.out.println("adjascent vertex of "+ i);
//            System.out.print("Head");
//            for(Integer each :graph.list[i]){
//                System.out.print(" -> "+each);
//            }
//            System.out.println("\n");
//        }    
//    }
//    
    
    public static void main(String[] args) {
        int v = 4;
        BFSgraph graph = new BFSgraph(v);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
//        printGraph(graph);
        graph.BFS(2);
    }
}
