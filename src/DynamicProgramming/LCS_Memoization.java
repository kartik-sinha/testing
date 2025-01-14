package DynamicProgramming;

import java.util.Arrays;

public class LCS_Memoization {
    static String st1="bd";
    static String st2="abcd";

    static int[][] mat=new int[st1.length()+1][st2.length()+1];

    static int LCS(int i, int j){
        if(mat[i][j]!=-1)
            return mat[i][j];
        else if( i==st1.length() || j==st2.length()) {
            mat[i][j]=0;
            return 0;
        }
        else if(st1.charAt(i)==st2.charAt(j)) {
            mat[i][j]=1 + LCS(i + 1, j + 1);
            return mat[i][j];
        }
        else {
            mat[i][j] = Integer.max(LCS(i + 1, j), LCS(i, j + 1));
            return mat[i][j];
        }
    }

    public static void main(String[] args) {
        for(int i=0; i<mat.length; i++){
            Arrays.fill(mat[i], -1);
        }

        System.out.println(LCS(0, 0));
    }
}
