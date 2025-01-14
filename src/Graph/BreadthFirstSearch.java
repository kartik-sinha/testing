package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
    public static void BFS(int[][]adj, int i){
        boolean[] visited=new boolean[adj.length];
        visited[i]=true;
        Queue<Integer> queue=new LinkedList<Integer>();
        queue.add(i);
        System.out.println(i);

        while(!queue.isEmpty()){
            int val=queue.poll();
            for(int v=0; v< adj.length; v++){
                if(adj[val][v]==1 && !visited[v]){
                    visited[v]=true;
                    queue.add(v);
                    System.out.println(v);
                }
            }
        }

    }

    public static void main(String[] args) {
        int[][] adj={ {0, 1, 0, 1},
                      {1, 0, 1, 0},
                      {0, 1, 0, 1},
                      {1, 0, 1, 0}};
        int i=3;
        BFS(adj, i);
    }
}
