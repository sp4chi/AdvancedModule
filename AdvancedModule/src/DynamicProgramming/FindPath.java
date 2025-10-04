package DynamicProgramming;

public class FindPath {
    static int recursive = 0;
    static int topDown = 0;

    //recursive - tc : 2^m+n in worst case
    public static int uniquePathsWithObstacles(int[][] A,int i,int j) {
        recursive++;
        int M = A.length;
        int N = A[0].length;
        if(i > M-1 || j > N - 1 || A[i][j] == 1) return 0;
        if(i == M-1 && j == N-1) return 1;
        return uniquePathsWithObstacles(A,i+1,j) + uniquePathsWithObstacles(A,i,j+1);
    }

    //top down dp
    public static int topDown(int[][] A) {
        int M = A.length;
        int N = A[0].length;
        int[][] dp = new int[M][N];
        for (int[] row : dp) {
            java.util.Arrays.fill(row, -1);
        }
        return helper(A,0,0,dp);
    }
    public static int helper(int[][] A, int i, int j, int[][] dp) {
        topDown++;
        int M = A.length;
        int N = A[0].length;
        if(i > M-1 || j > N - 1 || A[i][j] == 1) return 0;
        if(i == M-1 && j == N-1) return 1;

        if(dp[i][j] != -1) return dp[i][j];

        dp[i][j] = helper(A,i+1,j,dp) + helper(A,i,j+1,dp);
        return dp[i][j];
    }

    //bottom up - tc : N*N space : N*N
    public static int bottomUpHelper(int[][] A){
        int M=A.length;
        int N=A[0].length;
        int[][] dp = new int[M][N];
        for(int row=0;row<M;row++){
            if(A[row][0] == 1) {
                dp[row][0] = 0;
                continue;
            }
            dp[row][0] = 1;
        }
        for(int col=0;col<N;col++){
            if(A[0][col] == 1) {
                dp[0][col] = 0;
                continue;
            }
            dp[0][col] = 1;
        }
        for(int row=1;row<M;row++){
            for(int col=1;col<N;col++){
                if(A[row][col] == 1){
                    dp[row][col] = 0;
                    continue;
                }
                dp[row][col] = dp[row-1][col] + dp[row][col-1];
            }
        }
        return dp[M-1][N-1];
    }
    public static void main(String[] args) {
        //int[][] A = {{1,0},{1,0},{1,0},{0,0},{1,1},{0,0}};
        //int[][] A = {{0}};
        //int[][] A = {{1}};
        //int[][] A = {{1,0}};
        //int[][] A = {{0,0}};
        int[][] A = {
                {0, 0, 0, 0},
                {0, 1, 0, 1},
                {0, 0, 0, 0},
                {1, 0, 0, 0}
        };
        /*int[][] A = {
                {0,0,0},
                {0,0,0}
        };*/
        System.out.println(uniquePathsWithObstacles(A,0,0)+" "+ recursive);
        System.out.println(topDown(A)+" "+ topDown);
        System.out.println(bottomUpHelper(A));
    }
}



