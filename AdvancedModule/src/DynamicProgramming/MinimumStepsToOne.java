package DynamicProgramming;

public class MinimumStepsToOne {

    //top down
    public static int decay(int N) {
        int[] dp = new int[N+1] ;
        dp[1] = 0;
        return decayHelper(N, dp);
    }
    public static int decayHelper(int N, int[] dp){
        if(N == 1) return 0;
        if(dp[N] != 0) return dp[N];
        int d1 = Integer.MAX_VALUE;
        int d2 = d1, d3;
        if(N%3 == 0) d1 = decayHelper(N/3,dp);
        if(N%2 == 0) d2 = decayHelper(N/2,dp);
        d3 = decayHelper(N-1,dp);
        dp[N] = Math.min(d1,Math.min(d2,d3)) + 1;

        return dp[N];
    }

    //bottom up
    public static int decayBottomUp(int N){
        int[] dp = new int[N+1] ;
        dp[1] = 0;
        dp[2] = 1; dp[3] = 1;
        for (int i=4; i<=N; i++){
            dp[i] = 1 + dp[i-1];

            if(i % 2 == 0) dp[i] = Math.min(dp[i], dp[i/2] + 1);

            if(i % 3 == 0) dp[i] = Math.min(dp[i], dp[i/3] + 1);
        }
        return dp[N];
    }
    public static void main(String[] args) {
        int N = 5 ;
        System.out.println(decay(N));
        System.out.println(decayBottomUp(N));
    }
}
