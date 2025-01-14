package Greedy_Algo;
public class Knapsack {
    //                              ---------------------------------Fractional Knapsack---------------------------------


    public static float totalProfit_Fractional(int[][]obj, int totalCapacity){
        float TotalProfit=0;

        // Sorting the array based on Profit by Weight ratio
        for(int i=0; i<obj.length; i++){
            for(int j=0; j<obj.length-1; j++){
                if((obj[j][0]*1.0f)/obj[j][1]>(obj[j+1][0]*1.0f)/obj[j+1][1]){
                    int[] temp=obj[j];
                    obj[j]=obj[j+1];
                    obj[j+1]=temp;
                }
            }
        }

        for(int i=obj.length-1; i>=0; i--){
            if(totalCapacity==0)
                break;
            if(obj[i][1]<=totalCapacity){
                totalCapacity-=obj[i][1];
                TotalProfit+=obj[i][0];
            }
            else{
                TotalProfit+=totalCapacity*(obj[i][0]*1.0f/obj[i][1]);
                break;
            }
        }
        return TotalProfit;
    }


    public static void main(String[] args) {
        int[][]obj={{10,2},{5,3}, {15,5}, {7,7}, {6,1}, {18,4}, {3,1}};  //{ profit , weight }
        int weight=15;

        System.out.println(totalProfit_Fractional(obj, weight));
    }
}
