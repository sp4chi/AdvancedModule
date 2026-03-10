package DynamicProgramming;

public class LongestIncreasingSubsequence {
    //pick a subsequence of largest length such that all elements are in increasing order
    public static int lis(int[] arr) {
        int N = arr.length;

        if (N == 1) return 1;

        int[] dp = new int[N];

        dp[0] = 1;
        //each element is an LIS of length 1 by itself
        for (int i = 1; i < N; i++) {
            dp[i] = 1;
        }


        for (int i = 1; i < N; i++) {

            //comparing elements 0 - (i-1) with ith element
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }

        }

        //finding the largest value in dp and returning ans
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }

    public static int lisBinary(int[] arr) {
        int N = arr.length;
        int[] tails = new int[N];
        tails[0] = arr[0];
        int tailSize = 1;

        for (int i = 1; i < N; i++) {

            int left = 0;
            int right = tailSize - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (tails[mid] >= arr[i]) {
                    right = mid - 1; // try searching in the further left
                    // of mid for element greater then curr
                } else {
                    left = mid + 1; // try searching on the right side
                    // for element greater than curr
                }
            }
            // left is now insertion point
            tails[left] = arr[i];

            if (left == tailSize) { // only extend if we went past the end
                tailSize++;
            }
        }

        return tailSize;
    }

    public static void main(String[] args) {
        //int[] arr = {9,2,4,3,10};
        //int[] arr = {3,4,1,2,8};
        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lis(arr));
        System.out.println(lisBinary(arr));
    }
}
