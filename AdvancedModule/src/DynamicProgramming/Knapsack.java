package DynamicProgramming;

import java.util.Arrays;

public class Knapsack {
    public static int knapSackRec(int N, int capacity, int[] weight, int[] price){
        // base case
        if(N == 0 || capacity == 0){
            return 0;
        }

        int include = 0, exclude ;

        if(weight[N-1] <= capacity ){
            include = price[N-1] + knapSackRec(N-1,capacity - weight[N-1], weight,price);
        }

        exclude = knapSackRec(N-1,capacity,weight,price);

        return Math.max(include,exclude);
    }

    // top - down -> TC - (N x C), SC - (N x C)

    public static int knapSackTopDown(int N, int capacity,int[] weight, int[] price, int[][] dp){
        // base case
        if(N == 0 || capacity == 0){
            return 0;
        }

        int include = 0, exclude ;

        if(dp[N][capacity] != -1){
            return dp[N][capacity];
        }

        if(weight[N-1] <= capacity ){
            include = price[N-1] + knapSackTopDown(N-1,capacity - weight[N-1], weight,price,dp);
        }

        exclude = knapSackTopDown(N-1,capacity,weight,price,dp);

        dp[N][capacity] = Math.max(include,exclude);

        return dp[N][capacity];
    }

    public static int knapSackBottomUp(int N, int capacity, int[] weight, int[] price){
        int[][] dp = new int[N+1][capacity+1];

        for(int row=0;row<=N;row++){
            dp[row][0] = 0;
        }

        for(int col=0;col<=capacity;col++){
            dp[0][col] = 0;
        }
        // row -> item, col -> capacity
        for(int row = 1; row <= N; row++){
            for(int col = 1; col <= capacity; col++){

                int currentCapacity = col;
                int currentWeight = weight[row-1];
                int include = 0;

                if(currentWeight <= currentCapacity) {
                    include = price[row-1] + dp[row-1][col-weight[row-1]];
                }
                int exclude = dp[row-1][col];
                dp[row][col] = Math.max(include,exclude);
            }
        }

        return dp[N][capacity];
    }
    public static void main(String[] args) {
        int N = 4;
        int capacity = 20;
        int[] weight = {12,3,6,15};
        int[] price = {100,80,40,90};
        System.out.println("Max price: "+ knapSackRec(N,capacity,weight,price)); //ans - 180 (12 + 3)

        int[][] dp = new int[N+1][capacity+1];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

        System.out.println("Max price: "+ knapSackTopDown(N,capacity,weight,price,dp));
        System.out.println("Max price: "+ knapSackBottomUp(N,capacity,weight,price));
    }
}
