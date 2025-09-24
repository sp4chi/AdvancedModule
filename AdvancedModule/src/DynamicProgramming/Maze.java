package DynamicProgramming;

public class Maze {
    /*
        formula = M+N-2
                       C
                        M-1
     */
    public static int paths(int[][] maze) {
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
        int[] start = {0, 0};
        int[] end = {M - 1, N - 1};
        System.out.println(paths(maze));
    }
}
