package Sorting;

public class QuickSelect {
    // Given an integer array nums and an integer k, return the kth largest
    // element in the array.
    // Note that it is the kth largest element in the sorted order, not the kth
    // distinct element.

    // Solution - choose pivot, sort such that elements less than pivot are
    // on the left side and elements greater than pivot are on the right side
    // if pivot == k return A[pivot]
    // if pivot < N - k , quickSort right side of pivot, else quickSort left side
    // TC - O(N) SC - O(1) stack size worst case - O(N)

    public static int quickSort(int[] A, int k, int start, int end) {
        int N = A.length;
        if (start >= end)
            return A[end];
        int pivot = partition(A, start, end);
        if (pivot == N - k)
            return A[pivot];
        if (pivot < N - k) {
            return quickSort(A, k, pivot + 1, end);
        } else {
            return quickSort(A, k, start, pivot - 1);
        }
    }

    public static int quickSortTillK(int[] A, int k) {
        int N = A.length;
        return quickSort(A, k, 0, N - 1);
    }

    public static int partition(int[] A, int start, int end) {
        int j = start;
        int pivot = A[end];
        for (int i = start; i < end; i++) {
            if (A[i] < pivot) {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
                j++;
            }
        }
        int temp = A[end];
        A[end] = A[j];
        A[j] = temp;

        return j;
    }

    public static int findKthLargest(int[] A, int k) {
        int N = A.length;
        return quickSortTillK(A, k);
    }

    public static void main(String[] args) {
        int[] A = {3,2,3,1,2,4,5,5,6};
        int k = 4;
    }
}



