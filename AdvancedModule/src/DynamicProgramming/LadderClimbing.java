package DynamicProgramming;
//Given N stairs, find how many ways to reach top taking 1,2 and 3 steps only?
//top down
public class LadderClimbing {
    static int recursiveTimesCalled=0;
    static int topDownTimesCalled = 0;
    static int iterations = 0;

    public static int climb(int N){
        recursiveTimesCalled++;
        if (N == 0 || N == 1) return 1;
        if ( N < 0 ) return 0;
        return climb(N-1) + climb(N-2) + climb(N-3);
    }
    public static int climbTopDown(int N, int[] dp) {
        topDownTimesCalled++;
        if (N == 0) return 1;

        if (N < 0) return 0;

        if(dp[N] != 0){
            return dp[N];
        }
        int f1 = climbTopDown(N - 1,dp);
        int f2 = climbTopDown(N - 2,dp);
        int f3 = climbTopDown(N - 3,dp);

        dp[N] = f1 + f2 + f3;
        return dp[N];
    }

    //bottom up
    public static int climbBottomUp(int N, int[] dp) {
        if (N == 0) return 1;
        if (N < 0) return 0;
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2 ;
        for (int i = 3; i < N; i++) {
            iterations++;
            dp[i] = dp[i - 1] + dp[i - 2] +  dp[i - 3];
        }
        return dp[N];
    }

    public static void main(String[] args) {
        int N = 10 ;
        int[] dp = new int[N+1];
        System.out.println("Recursive climbing :" + climb(N) + " times called: " + recursiveTimesCalled);
        System.out.println("Top Down Approach : "+climbTopDown(N,dp)+" times called "+ topDownTimesCalled);
        System.out.println("Bottom Up Approach : "+climbBottomUp(N,dp) + " iterations "+ iterations);
    }
}
