package DynamicProgramming;

public class LadderClimbing {
    static int timesCalled = 0;
    public static int climb(int N, int[] dp) {
        timesCalled++;
        if (N == 0) return 1;

        if (N < 0) return 0;

        if(dp[N] != 0){
            return dp[N];
        }
        int f1 = climb(N - 1,dp);
        int f2 = climb(N - 2,dp);
        int f3 = climb(N - 3,dp);

        dp[N] = f1 + f2 + f3;
        return dp[N];
    }

    public static void main(String[] args) {
        int N = 3;
        int[] dp = new int[N+1];
        System.out.println(climb(N,dp)+" times called "+timesCalled);
    }
}
