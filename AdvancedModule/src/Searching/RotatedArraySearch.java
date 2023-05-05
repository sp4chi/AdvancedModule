package Searching;

public class RotatedArraySearch {
    /*
    Given a sorted array of integers A of size N and an integer B. Array A is rotated at some pivot point.
    You are given a target value B to search. If found in the array, return its index otherwise, return -1.
    You may assume no duplicate exists in the array.
    */
    public static int pivot(int[] A, int B) {
        int N = A.length;
        int ans = -1;
        int start = 0;
        int end = N - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == B) return mid;
            if (A[start] <= A[mid]) {
                if (A[start] <= B && A[mid] >= B) end = mid - 1;
                else start = mid + 1;
            } else {
                if (A[end] >= B && A[mid] <= B) start = mid + 1;
                else end = mid - 1;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] A = {4, 5, 6, 7, 0, 1, 2, 3};
        int B = 0;

        System.out.println(pivot(A, B));
    }
}
