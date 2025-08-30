package DynamicProgramming;

public class FibonacciSeries {
    // top down
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

    // bottom up
    public static int fib_loop(int N, int[] dp){
        for(int i=2;i<=N;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[N];
    }
    //
    public static int fib(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;

        int past = 0;   // Fib(0)
        int prev = 1;   // Fib(1)
        int curr = 0;

        for (int i = 2; i <= N; i++) {
            curr = past + prev;  // Fib(i)
            past = prev;
            prev = curr;
        }
        return curr;
    }

    public static void main(String[] args) {
        int N = 6;

        int[] dp = new int[N + 1];

        //not required but for convention
        dp[0] = 0;
        dp[1] = 1;

        System.out.println(fib(N));
    }
}
