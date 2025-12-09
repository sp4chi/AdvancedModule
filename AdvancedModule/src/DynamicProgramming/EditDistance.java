package DynamicProgramming;

import java.util.Arrays;

public class EditDistance {
    public static int editDistance(String s1, String s2,int i,int j, int I,int D, int R) {
        if(i==-1) {
            return (j+1)*I;
        }
        if(j==-1){
            return (i+1)*D;
        }
        if(s1.charAt(i) == s2.charAt(j)) {
            return editDistance(s1, s2, i - 1, j - 1, I, D, R);
        }else{
            int insertion = I + editDistance(s1,s2,i,j-1,I,D,R);
            int deletion = D + editDistance(s1,s2,i-1,j,I,D,R);
            int replace = R + editDistance(s1, s2, i-1, j-1, I, D, R);
            return Math.min(insertion,Math.min(deletion,replace));
        }
    }
    public static int editDistanceTopDown(String s1, String s2, int i, int j, int I, int D, int R) {
        int[][] dp = new int[i+1][j+1];
        for (int[] row : dp) Arrays.fill(row, -1);

        return helper(dp,s1,s2,i,j,I,D,R);
    }
    public static int helper(int[][] dp, String s1, String s2, int i, int j, int I, int D, int R) {
        if(i==-1) {
            return (j+1)*I;
        }
        if(j==-1){
            return (i+1)*D;
        }
        if(dp[i][j] != -1) return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j)) {
            dp[i][j] = helper(dp, s1, s2, i - 1, j - 1, I, D, R);
        }else{
            int insertion = I + helper(dp, s1,s2,i,j-1,I,D,R);
            int deletion = D + helper(dp, s1,s2,i-1,j,I,D,R);
            int replace = R + helper(dp,s1, s2, i-1, j-1, I, D, R);
            dp[i][j] =  Math.min(insertion,Math.min(deletion,replace));
        }

        return dp[i][j];
    }
    public static int editDistanceBottomUp(String s1, String s2, int I, int D, int R) {
        int M = s1.length();
        int N = s2.length();
        int[][] dp = new int[M + 1][N + 1];
        dp[0][0] = 0;

        for(int col=1;col<M;col++) {
            dp[0][col] = col*I;
        }
        for(int row=1;row<N;row++) {
            dp[row][0] = row*I;
        }

        for(int row = 1; row < M; row++) {
            for(int col = 1; col < N; col++) {
                if(s1.charAt(row-1) == s2.charAt(col-1)) {
                    dp[row][col] = dp[row-1][col];
                }else{
                    dp[row][col] = I + dp[row][col-1];
                    dp[row][col] = R + dp[row-1][col-1];
                    dp[row][col] = D + dp[row-1][col];
                }
            }
        }

        return dp[M][N];
    }
    public static void main(String[] args) {
        String s1 = "abgxyl";
        String s2 = "abcgxl";
        int I = 1;
        int D = 2;
        int R = 3;
        System.out.println(editDistance(s1,s2,s1.length()-1,s2.length()-1,I,D,R));
        System.out.println(editDistanceTopDown(s1,s2,s1.length()-1,s2.length()-1,I,D,R));
        System.out.println(editDistanceBottomUp(s1,s2,I,D,R));
    }
}
