package Hashing;

import java.util.HashSet;

public class SubArrayWithZeroSum {
    //Given an array of integers A, find and return whether the given array contains a non-empty subarray with a sum equal to 0.
    //If the given array contains a sub-array with sum zero return 1, else return 0.
    public static int subArrayBrute(int[] A) {
        int N = A.length;

        //HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int sum = A[i];
            for (int j = i + 1; j < N; j++) {
                sum += A[j];
                if (sum == 0) {
                    return 1;
                }
            }

        }
        return 0;
    }

    public static int subArrayHashing(int[] A) {
        int sum = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i : A) {
            sum += i;
            if (set.contains(sum)) {
                return 1;
            } else if (sum == 0) {
                return 1;
            } else {
                set.add(sum);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, -2, -7};
        //int[] A={-1,1};
        //int[] A={-78, -97, -44, -18, -7, -26, 37, -76, -23, -35, 48, 9, 25, 62, -90, 27, -40, 18, 88, 82, 15, 96, 31, -2, -45, -48, 52, -78, -79, -76, -18, -88, -85, 58, -48, -48, -16, 77, -79, -89, -78, 27, 98, 53, -6, 43, 73, 38};
        System.out.println(subArrayHashing(A));
        System.out.println(subArrayBrute(A));
    }
}
