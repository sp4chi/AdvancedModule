package DynamicProgramming;

public class DiceProblem {
    static int timescalledRec = 0;
    static int timescalledTopDown = 0;
    static int timescalledBottomUp = 0;

    //recursive solution - O(6^N)
    public static int sumTillN(int N){
        timescalledRec++;
        if(N == 0) return 1;
        if(N <= 0) return 0;
        int count = 0;
        count += sumTillN(N-1) + sumTillN(N-2) + sumTillN(N-3) +
                sumTillN(N-4) + sumTillN(N-5) + sumTillN(N-6);
        return count;
    }

    //bottom up dp - tc - O(N) space - O(N+1)
    public static int sumTillNBottomUp(int N){
        int count = 0;
        int[] dp = new int[N+1];
        dp[0] = 1;
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= 6; j++){
                timescalledBottomUp++;
                if(i - j >= 0){
                    dp[i] += dp[i - j];
                }
            }
        }
        return dp[N];
    }

    public static int sumTillNTopTopDown(int N){
        int[] dp=  new int[N+1] ;
        dp[0] = 1;
        return sumTillNTopTopDownHelper(N,dp);
    }

    public static int sumTillNTopTopDownHelper(int N, int[] dp){
        timescalledTopDown++;
        if(N == 0) return 1;
        if(N <= 0) return 0;
        int count = 0;
        if(dp[N] != 0){
            return dp[N];
        }
        for(int i=1;i<=6;i++){
            count += sumTillNTopTopDownHelper(N-i,dp);
        }
        dp[N] = count;
        return dp[N];
    }
    public static void main(String[] args) {
        int N = 7;
        System.out.println(sumTillN(N)+" "+timescalledRec);
        System.out.println(sumTillNBottomUp(N)+" "+timescalledBottomUp);
        System.out.println(sumTillNTopTopDown(N)+" "+ timescalledTopDown);
    }
}
