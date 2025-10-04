package DynamicProgramming;

public class Maze {
    static int recursive = 0;
    static int topDown = 0;
    /*
        formula = M+N-2
                       C
                        M-1
     */
    //recursive solution
    public static int paths(int[][] maze,int i,int j) {
        recursive++;
        int M = maze.length;
        int N = maze[0].length;
        if(i > M-1 || j > N-1 ) return 0;
        if(i == M-1 && j == N-1) return 1;
        return paths(maze,i+1,j) + paths(maze,i,j+1);
    }

    //Top down dp
    public static int pathsTopDown(int[][] maze) {
        int M = maze.length;
        int N = maze[0].length;
        int[][] dp = new int[M][N];
        for (int[] row : dp) {
            java.util.Arrays.fill(row, -1);
        }
        return pathsTopDownHelper(maze,0,0,dp);
    }

    public static int pathsTopDownHelper(int[][] maze, int i, int j, int[][] dp) {
        topDown++;
        int M = maze.length;
        int N = maze[0].length;

        if(i > M-1 || j > N-1 ) return 0;
        if(i == M-1 && j == N-1) return 1;

        if(dp[i][j] != -1) return dp[i][j];
        dp[i][j] = pathsTopDownHelper(maze,i+1,j,dp) +
                pathsTopDownHelper(maze,i,j+1,dp);
        return dp[i][j];
    }


    public static int pathsBottomUp(int[][] maze) {
        int M = maze.length;
        int N = maze[0].length;
        int[][] dp = new int[M][N];
        for (int i = 0; i < N; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < M; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        return dp[M - 1][N - 1];
    }

    //Given a MxN grid, find ways to reach M-1,N-1 from 0,0
    public static void main(String[] args) {
        int M = 3, N = 4;
        int[][] maze = new int[M][N];
        System.out.println(paths(maze,0,0)+" "+ recursive);
        System.out.println(pathsTopDown(maze)+" "+ topDown);
        System.out.println(pathsBottomUp(maze));
    }
}
