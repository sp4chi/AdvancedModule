package DynamicProgramming;

import java.util.Arrays;

/*
 * Given an m x n grid, find min health you have to travel with from 0,0 to m-1,n-1
 * such that your health doesn't become zero
 * Ex - A = {
 *         {-5,-2},
 *         {-1,-1}
 *      }
 * ANS : 8 since 8 - 5 - 1 - 1 = 1
 */
public class DungeonsAndDragons {
    static int recursive = 0;
    static int topDown = 0;

    //recursive
    public static int recursive(int[][] grid, int i, int j) {
        recursive++;
        int M = grid.length;
        int N = grid[0].length;

        if(i >= M || j >= N)
            return Integer.MAX_VALUE;

        if( i == M-1 && j == N-1) return Math.max(1,1 - grid[i][j]);

        int right = recursive(grid, i, j+1);
        int down = recursive(grid, i+1, j);
        int next = Math.min(right,down);

        return Math.max(1,next - grid[i][j]);
    }

    //top down
    public static int topDown(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        int[][] dp = new int[M][N];

        // Fill dp with -1
        for (int[] row : dp)
            Arrays.fill(row, -1);

        return helper(grid, 0, 0, dp);

    }

    public static int helper(int[][] grid, int i, int j, int[][] dp) {
        topDown++;
        int M = grid.length;
        int N = grid[0].length;

        if(i >= M || j >= N) return Integer.MAX_VALUE;

        if( i == M-1 && j == N-1) return Math.max(1,1 - grid[i][j]);

        if(dp[i][j] != -1) return dp[i][j];

        int right = helper(grid, i, j+1, dp);
        int down = helper(grid, i+1, j, dp);
        int next = Math.min(right,down);

        dp[i][j] = Math.max(1, next - grid[i][j]);

        return dp[i][j];
    }
    //bottom up
    public static int bottomUp(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        int[][] dp = new int[M][N];

        if(M == 1 && N == 1) return Math.max(1, 1 - grid[0][0]);

        dp[M-1][N-1] = Math.max(1, 1 - grid[M-1][N-1]);

        for(int row = M - 2; row >= 0; row--){
            dp[row][N-1] = Math.max(1, dp[row+1][N-1] - grid[row][N-1]);
        }
        for(int col = N - 2; col >= 0; col--){
            dp[M-1][col] = Math.max(1, dp[M-1][col+1] - grid[M-1][col]);
        }


        for(int i=M-2;i>=0;i--){
            for(int j=N-2;j>=0;j--){
                dp[i][j] = Math.max(
                        1,
                        Math.min( dp[i+1][j] , dp[i][j+1] ) - grid[i][j]
                );
            }
        }
        return dp[0][0];
    }
    public static void main(String[] args) {
        int[][] caseA = {
                {-3,-2},
                {-4,-5}
        };
        int[][] caseB = {
                {6,-2},
                {-4,-5}
        };
        int[][] caseC = {
                {16,-2},
                {-4,-5}
        };
        int[][] caseD = {
                {-2,-3,3},
                {-5,-10,1},
                {10,30,-5}
        };
        System.out.println(
                        bottomUp(caseA)+" "+
                        bottomUp(caseB)+" "+
                        bottomUp(caseC)+" "+
                        bottomUp(caseD))
        ;
        System.out.println(
                        recursive(caseA,0,0)+" " +
                        recursive(caseB,0,0)+" " +
                        recursive(caseC,0,0)+
                        recursive(caseD,0,0)+" " +
                        " called: "+ recursive
        );
        System.out.println(
                        topDown(caseA)+" "+
                        topDown(caseB)+" "+
                        topDown(caseC) +
                        topDown(caseD)+" "+
                        " called: "+ topDown);

    }
}
