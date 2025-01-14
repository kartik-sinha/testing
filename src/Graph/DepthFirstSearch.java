package Graph;

public class DepthFirstSearch {
    static int[][] adj={{0,1,1,1,0,0,0},
                        {1,0,1,0,0,0,0},
                        {1,1,0,1,1,0,0},
                        {1,0,1,0,1,0,0},
                        {0,0,1,1,0,1,1,},
                        {0,0,0,0,1,0,0},
                        {0,0,0,0,1,0,0}};
    static boolean []visited=new boolean[adj.length];

    public static void DFS(int i){
        if(!visited[i]) {
            System.out.println(i);
            visited[i]=true;
            for(int v=0; v<adj.length; v++){
                if(adj[i][v]==1 && !visited[v])
                    DFS(v);
            }
        }
    }

    public static void main(String[] args) {
        DFS(4);
    }
}
