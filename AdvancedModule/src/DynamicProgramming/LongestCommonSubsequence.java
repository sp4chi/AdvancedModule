package DynamicProgramming;

import java.util.Arrays;

public class LongestCommonSubsequence {
    //tc : O(2^(M+N))
    public static int lcsRecursive(String s1, String s2){
        int i = s1.length()-1, j = s2.length()-1;
        return helper(s1,s2,i,j);
    }

    public static int helper(String s1, String s2, int i, int j){
        if(i == -1 || j == -1) return 0;
        if(s1.charAt(i) == s2.charAt(j)) {
            return helper(s1, s2, i - 1, j - 1) + 1;
        }
        int f1 = helper(s1, s2, i-1, j);
        int f2 = helper(s1, s2, i, j-1);
        return Math.max(f1, f2);
    }
    //tc : O(M x N)
    public static int lcsTopDown(String s1, String s2){
        int i = s1.length()-1, j = s2.length()-1;
        //int N = Math.max(s1.length(), s2.length());
        int[][] dp =  new int[i+1][j+1];
        /*for(int row = 0; row < dp.length; row++){
            for(int col = 0; col < dp[0].length; col++){
                dp[row][col] = -1;
            }
        }*/
        for(int[] row : dp) Arrays.fill(row, -1);

        return helperTopDown(s1,s2,i,j,dp);
    }
    public static int helperTopDown(String s1, String s2, int i, int j,int[][] dp){
        if(i == -1 || j == -1) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j)) {
            dp[i][j] = helperTopDown(s1, s2, i - 1, j - 1,dp) + 1;
        }else {
            int f1 = helperTopDown(s1, s2, i - 1, j, dp);
            int f2 = helperTopDown(s1, s2, i, j - 1, dp);
            dp[i][j] = Math.max(f1, f2);
        }
        return dp[i][j];
    }

    public static int lcsBottomUp(String s1, String s2){
        int N = s1.length(), M = s2.length();
        int[][] dp =  new int[N+1][M+1];
        for(int row = 0; row < N + 1; row++){
            dp[row][0] = 0;
        }

        for(int col = 0;col < M + 1; col++){
            dp[0][col] = 0;
        }
        return helperBottomUp(s1,s2,dp);
    }

    public static int helperBottomUp(String s1, String s2, int[][] dp){
        int N = dp.length;
        int M = dp[0].length;
        for(int row = 1; row < N; row++){
            for(int col = 1; col < M; col++){
                if(s1.charAt(row-1) == s2.charAt(col-1)){
                    dp[row][col] = dp[row-1][col-1] + 1;
                }else{
                    dp[row][col] = Math.max(
                            dp[row-1][col],
                            dp[row][col-1]
                    );
                }
            }
        }

        printLCS(dp,s1,s2);
        return dp[N-1][M-1];
    }
    public static void printLCS(int[][] dp,String s1,String s2){
        int i=dp.length - 1, j=dp[0].length - 1;
        StringBuilder sb = new StringBuilder();
        while(i > 0 && j > 0){
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                sb.append(s1.charAt(i-1));
                i--;j--;
            }else if(dp[i-1][j] > dp[i][j-1] ){
                i--;
            }else{
                j--;
            }
        }
        System.out.println(sb.reverse());
    }
    public static void main(String[] args) {
        String s1 = "ABCDX";
        String s2 = "AXCYD";
        System.out.println(lcsRecursive(s1,s2));
        System.out.println(lcsTopDown(s1,s2));
        System.out.println(lcsBottomUp(s1,s2));
    }
}
