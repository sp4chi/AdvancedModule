package DynamicProgramming;

public class FibonacciSeries {
    public static int fib_rec(int N, int[] dp) {
        if (N == 0 || N == 1) {
            return N;
        }

        if (dp[N] != 0) {
            return dp[N];
        }
        int f1 = fib_rec(N - 1, dp);
        int f2 = fib_rec(N - 2, dp);

        dp[N] = f1 + f2;
        return dp[N];
    }
    public static int fib_loop(int N, int[] dp){
        for(int i=2;i<=N;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[N];
    }
    public static void main(String[] args) {
        int N = 6;

        int[] dp = new int[N + 1];

        //not required but for convention
        dp[0] = 0;
        dp[1] = 1;

        System.out.println(fib_loop(N, dp));
    }
}
