package DynamicProgramming;

public class LongestIncreasingSubsequence {
    //pick a subsequence of largest length such that all elements are in increasing order
    public static int lcs(int[] arr){
        int N = arr.length;

        if(N == 1) return 1;

        int[] dp = new int[N];

        dp[0] = 1;
        //each element is an LIS of length 1 by itself
        for(int i = 1; i < N; i++){
            dp[i] = 1;
        }


        for(int i=1;i<N;i++){

            //comparing elements 0 - (i-1) with ith element
            for(int j = 0; j < i; j++){
                if(arr[i] > arr[j]){
                    dp[i] = Math.max(dp[j] + 1,dp[i]);
                }
            }

        }

        //finding the largest value in dp and returning ans
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<N;i++){
            ans = Math.max(ans,dp[i]);
        }

        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {9,2,4,3,10};
        System.out.println(lcs(arr));
    }
}
