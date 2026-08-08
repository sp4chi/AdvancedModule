package DynamicProgramming;

// pick a subsequence of largest length such that all
// elements are in increasing order

public class LongestIncreasingSubsequence {

    public static int LIS(int[] A, int prevIdx, int currentIdx) {
        // init: sequence, prev: -1(sentinel), start: 0
        // if currentIdx == len(sequence) return 0
        // do not select currentIdx : LIS(arr, prevIdx, currentIdx + 1
        // select currentIdx : LIS(arr, currentIdx, currentIdx + 1)
        // return max(do not select, select)

        if (currentIdx == A.length) {
            return 0;
        }

        int skip = LIS(A, prevIdx, currentIdx + 1);

        int select = 0;
        if (prevIdx == -1 || A[currentIdx] > A[prevIdx]) {
            select = 1 + LIS(A, currentIdx, currentIdx + 1);
        }

        return Math.max(skip, select);
    }

    public static int LISWithPruning(int[] nums, int currIdx, int N) {
        // generate all subsequences and find the longest increasing subsequence
        // 2^n subsequences, finding the longest increasing sub - n^2.
        // Total - 2^n * n^2
        // strat - generate subsequence of len 1 to N and for each length
        // find lcs and keep track of max
        // ** When arr[currIdx] < arr[currIdx] dfs till N - 1

        if (N > nums.length - 1) return 1;

        if (N == nums.length - 1) {
            if (nums[currIdx] < nums[N]) {
                return 1;
            }

            return 0;
        }

        int a, b = 0;

        if (nums[currIdx] < nums[N]) {
            b = 1 + LIS(nums, N, N + 1);
        }

        a = LIS(nums, currIdx, N + 1);


        return Math.max(a, b);
    }

    public static int LISBruteBottom(int[] A, int N) {

        int ans = 0;
        for (int i = A.length - 1; i > N; i--) {
            if (A[i] > A[N]) {
                ans = Math.max(ans, 1 + LISBruteBottom(A, i));
            }
        }
        return ans;
    }


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
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, 1 + LISWithPruning(arr, i, i + 1));
        }
        System.out.println(max);
        System.out.println(LIS(arr, -1, 0));

        int maxx = 0;
        for (int i = 0; i < arr.length; i++) {
            maxx = Math.max(maxx, 1 + LISBruteBottom(arr, i));
        }
        System.out.println(maxx);
    }
}
