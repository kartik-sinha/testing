package DynamicProgramming;

public class LCS_Tabulation {
    static String A="stone";
    static String B="longest";

    static int[][] LCS=new int[A.length()+1][B.length()+1];

    static int LCS(){
        for(int i=1; i<LCS.length; i++ )
            for(int j=1; j<LCS[i].length; j++)
                if(A.charAt(i-1)==B.charAt(j-1))
                    LCS[i][j] = 1 + LCS[i - 1][j - 1];
                else
                    LCS[i][j]=Integer.max(LCS[i-1][j], LCS[i][j-1]);
        return LCS[A.length()][B.length()];
    }

    public static void main(String[] args) {
        System.out.println(LCS());
    }
}
