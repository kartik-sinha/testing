package Greedy_Algo;

public class Job_Sequencing {
    public static void main(String[] args) {
        int[][]obj={{20, 2}, {15, 2}, {10, 1}, {5, 3}, {1,3}};  //{ profit , deadline}
        int weight=3;

        System.out.println(getJobSequence(obj, weight));


    }

    private static int getJobSequence(int[][] obj, int weight) {
        boolean[] filled=new boolean[weight];
        int totalProfit=0;

        for(int i=0; i<obj.length; i++){
            if(!filled[obj[i][1]-1]){
                totalProfit+=obj[i][0];
                filled[ obj[i][1]-1 ]=true;
            }else{
                for(int j=obj[i][1]-2; j>=0; j--){
                    if(!filled[j]){
                        totalProfit+=obj[i][0];
                        filled[j]=true;
                    }
                }
            }
        }
        return totalProfit;
    }
}
