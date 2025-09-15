package DynamicProgramming;

// Given N steps staircase and k steps you can take, find ways to reach top of staircase
public class LadderClimbingGeneralized {
    public static int climb(int N, int k) {
        int[] dp = new int[N+1];
        return climbDP(N,k,dp);
    }

    public static int climbDP(int N, int k, int[] dp) {

        dp[0] = 1;
        for (int steps = 1; steps <= N; steps++) {
            int ans = 0;
            for(int jump = 1; jump <= k; jump++) {
                if(steps-jump >= 0) {
                    ans += dp[steps-jump];
                }
            }
            dp[steps] = ans;
        }
        return dp[N];
    }
    public static void main(String[] args) {
        int N = 5;
        int k = 4;
        System.out.println(climb(N,k));
    }
}
