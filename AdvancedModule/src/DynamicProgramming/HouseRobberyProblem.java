package DynamicProgramming;

public class HouseRobberyProblem {
    static int timescalledRec = 0 ;
    static int timescalledTopDown = 0 ;
    //recursive solution - tc : O(2^N)
    public static int robbedMoneyRec(int[] money,int i){
        timescalledRec++ ;
        if(i < 0) return 0;
        if(i == 0) return money[0];
        int rob = money[i]+robbedMoneyRec(money,i-2);
        int skip = robbedMoneyRec(money,i-1);
        return Math.max(skip,rob);
    }

    //top down  - tc : O(N) space : O(N) stack : O(N)
    public static int robbedMoneyTopDown(int[] money,int i){
        int[] dp = new int[money.length];
        return robbedMoneyTopDownHelper(money,i,dp);
    }

    public static int robbedMoneyTopDownHelper(int[] money,int i,int[] dp){
        timescalledTopDown++;
        if(i < 0) return 0;
        if(i == 0) return money[0];
        if(dp[i] != 0) return dp[i];
        int rob = money[i]+robbedMoneyTopDownHelper(money,i-2,dp);
        int skip = robbedMoneyTopDownHelper(money,i-1,dp);
        dp[i] = Math.max(skip,rob);
        return dp[i];
    }

    //bottom up - tc : O(N) space : O(N)
    public static int robbedMoneyBottomUp(int[] money){
        int N = money.length;
        int[] dp = new int[N];
        dp[0] = money[0];
        dp[1] = Math.max(dp[0],money[1]);
        for(int i=2;i<N;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+money[i]);
        }
        return dp[N-1];
    }
    public static void main(String[] args) {
        int[] money = {1,1,100,1,1,100};
        //int[] money = {2,7,9,3,1};
        System.out.println(robbedMoneyBottomUp(money));
        System.out.println(robbedMoneyRec(money,money.length-1)+" "+timescalledRec);
        System.out.println(robbedMoneyTopDown(money,money.length-1)+" "+timescalledTopDown);
    }
}
