package DynamicProgramming;

public class PartyProblem {
    static int timescalledRec = 0 ;
    static int timescalledBottomUp = 0 ;

    // recursive solution - TC - O(2^n)
    public static int groupsRec(int N){
        timescalledRec++;
        if(N <= 2) return N;
        return groupsRec(N-1) + (N-1) * groupsRec(N-2);
    }

    //bottom up
    public static int groups(int N){
        int[] dp = new int[N+1];
        return groupsHelper(N,dp);
    }
    public static int groupsHelper(int N, int[] dp){
        timescalledBottomUp++;
        if(N < 3) return N;
        if(dp[N] != 0) return dp[N];
        dp[N] = groupsHelper(N-1, dp) + (N-1) * groupsHelper(N-2, dp);
        return dp[N];
    }

    //top down
    public static int groupsBottomUp(int N){
        int[] dp = new int[N+1] ;
        dp[0] = 0; dp[1] = 1; dp[2] = 2;
        for(int i = 3; i <= N; i++){
            dp[i] = dp[i-1] + (i-1)*dp[i-2];
        }
        return dp[N];
    }
    public static void main(String[] args) {
        int N = 5;
        System.out.println("Recursive sol. : "+groupsRec(N)+" timescalled: "+timescalledRec);
        System.out.println("Top Down sol.  : "+groups(N)+" timescalled: "+timescalledBottomUp);
        System.out.println("Bottom Up sol.  : "+groupsBottomUp(N));
    }
}
