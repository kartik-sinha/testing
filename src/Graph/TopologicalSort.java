package Graph;

import java.util.Stack;

public class TopologicalSort {
    static int[][] adj={{0,0,0,0,0,0},
            {0,0,0,0,0,0},
            {0,0,0,1,0,0},
            {0,1,0,0,0,0},
            {1,1,0,0,0,0},
            {1,0,1,0,0,0}};
    static boolean []visited=new boolean[adj.length];
    static Stack<Integer> stack=new Stack<>();

    public static void topologicalSort(){
        for(int i=0; i<adj.length; i++){
            if(!visited[i])
                DFS(i);
        }
        while(!stack.empty())
            System.out.println(stack.pop());
    }
    public static void DFS(int i){
        visited[i]=true;
        for(int v=0; v< adj.length; v++){
            if(!visited[v] && adj[i][v]==1)
                DFS(v);
        }
        stack.push(i);
    }

    public static void main(String[] args) {
        topologicalSort();
    }

}
