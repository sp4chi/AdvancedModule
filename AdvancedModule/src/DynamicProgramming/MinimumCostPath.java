package DynamicProgramming;

public class MinimumCostPath {
    static int recursive=0;
    static int topDown=0;
    /*
    * Find minimum cost from 0,0 to m-1, n-1
    *
    * */
    public static int minCostPath(int[][] maze,int i,int j){
        recursive++;
        int M = maze.length;
        int N = maze[0].length;

        //out of bounds
        if(i > M - 1 ) return Integer.MAX_VALUE-maze[i-1][j];
        if(j > N - 1) return Integer.MAX_VALUE-maze[i][j-1];

        //reached destination
        if(i == M - 1 && j == N - 1) return maze[i][j];
        int min1 = maze[i][j] + minCostPath(maze,i+1,j);
        int min2 = maze[i][j] + minCostPath(maze,i,j+1);
        return Math.min(min1, min2);
    }

    //top down dp
    public static int topDown(int[][] maze){
        int M = maze.length;
        int N = maze[0].length;
        int[][] dp = new int[M][N];
        return helper(maze,0,0,dp);
    }

    public static int helper(int[][] maze,int i,int j,int[][] dp){
        topDown++;
        int M = maze.length;
        int N = maze[0].length;

        if(i > M - 1 ) return Integer.MAX_VALUE-maze[i-1][j];
        if(j > N - 1) return Integer.MAX_VALUE-maze[i][j-1];

        if(i == M - 1 && j == N - 1) return maze[i][j];

        if(dp[i][j] != 0) return dp[i][j];

        dp[i][j] = Math.min(
                maze[i][j] + helper(maze,i+1,j,dp),
                maze[i][j] + helper(maze,i,j+1,dp)
        );

        return dp[i][j];
    }

    public static int bottomUp(int[][] maze){
        int M = maze.length;
        int N = maze[0].length;
        int[][] dp = new int[M][N];
        dp[0][0] = maze[0][0];
        for(int row = 1; row < M; row++){
            dp[row][0] = dp[row-1][0] + maze[row][0];
        }

        for(int col = 1; col < N; col++){
            dp[0][col] = dp[0][col-1] + maze[0][col];
        }

        for(int row = 1; row < M; row++){
            for(int col = 1; col < N; col++){
                dp[row][col] = Math.min(dp[row-1][col], dp[row][col-1]) + maze[row][col];
            }
        }
        return dp[M-1][N-1];
    }
    public static void main(String[] args) {
        /*int[][] maze = {
                {1,2,2,4},
                {6,5,6,0},
                {3,8,1,-1},
                {3,7,8,4}
        };*/
        int[][] maze = {
                {1, -5},
                {2,  3}
        };
        /*int[][] maze = {
                {1, -10, 5},
                {2,  100, 100},
                {3,   4,   1}
        };*/
        /*int[][] maze = {
                {1, -2000000000, 5},
                {2, 100, 100},
                {3, 4, 1}
        };*/
        /*int[][] maze = {
                {1, -2000000000, 5},
                {2, 100, -1500000000},
                {3, 4, 1}
        };*/
        /*int[][] maze = {
                {Integer.MAX_VALUE - 100, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };*/




        System.out.println(minCostPath(maze,0,0)+" times called "+recursive);
        System.out.println(topDown(maze)+" times called "+topDown);
        System.out.println(bottomUp(maze));
        System.out.println(Integer.MAX_VALUE);
    }
}
