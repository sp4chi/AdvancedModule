package ArrayScaler;

public class SortItUp {
    //You are given an array arr, consisting of only zeroes, ones and twos.
    //Sort the same array in-place and return it. Do not create a new array.
    public static int[] sortIt(int[] A) {
        int N = A.length;
        int left = 0;
        int right = N - 1;
        int curr = 0;
        while (curr <= right) {
            if (A[curr] == 2) {
                swap(A, right, curr);
                right--;
            } else if (A[curr] == 1) {
                curr++;
            } else {
                swap(A, left, curr);
                curr++;
                left++;
            }
        }
        return A;
    }

    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void main(String[] args) {
        int[] A = {0, 0, 2, 0, 1, 2, 2};
        int[] B = sortIt(A);
        for (int i : B) {
            System.out.print(i + " ");
        }
    }
}
