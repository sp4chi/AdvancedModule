package Searching;

public class MedianOfSortedArray {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int M = nums1.length;
        int N = nums2.length;

        if (M > N)
            return findMedianSortedArrays(nums2, nums1);

        int half = (1 + M + N) / 2;
        // int mid = half - 1;
        // int i = 1;
        int ALeft = Integer.MIN_VALUE, ARight = Integer.MAX_VALUE, BLeft = Integer.MIN_VALUE,
                BRight = Integer.MAX_VALUE;

        int left = 0;
        int right = M;

        while (left <= right) {
            int i = (left + right) / 2;
            int j = half - i;

            if (i == 0) {
                ALeft = Integer.MIN_VALUE;
            } else {
                ALeft = nums1[i - 1];
            }
            if (i == M) {
                ARight = Integer.MAX_VALUE;
            } else {
                ARight = nums1[i];
            }
            if (j == 0) {
                BLeft = Integer.MIN_VALUE;
            } else {
                BLeft = nums2[j - 1];
            }
            if (j == N) {
                BRight = Integer.MAX_VALUE;
            } else {
                BRight = nums2[j];
            }

            if (ALeft <= BRight && BLeft <= ARight) {
                if ((M + N) % 2 == 0) {
                    return (Math.max(ALeft, BLeft) + Math.min(ARight, BRight)) / 2.0;
                }
                // odd case
                return Math.max(ALeft, BLeft) / 1.0;

            } else if (ALeft > BRight) { // taken too many elements from first arr, move left
                right = i - 1;
            } else if (BLeft > ARight) { // taken few from first array, move right
                left = i + 1;
            }
        }
        if ((M + N) % 2 == 0) {
            return (Math.max(ALeft, BLeft) + Math.min(ARight, BRight)) / 2.0;
        }
        // odd case
        return Math.max(ALeft, BLeft) / 1.0;
    }

    public static void main(String[] args) {
        int[] nums1={1,3,8};
        int[] nums2={2,9,10,11};

        System.out.println(findMedianSortedArrays(nums1,nums2));
    }
}



