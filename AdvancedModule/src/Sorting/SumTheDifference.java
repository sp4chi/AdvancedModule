package Sorting;

import java.util.Arrays;

public class SumTheDifference {
    static int mod = (int) 1e9 + 7;

    public static int solve(int[] A) {
        Arrays.sort(A);
        int N = A.length;
        int min = 0, max = 0;
        for (int j : A) {
            min = (min * 2) % mod;
            min = (min + j) % mod;
        }
        for (int i = N - 1; i >= 0; i--) {
            max = (max * 2) % mod;
            max = (max + A[i]) % mod;
        }
        return (max - min + mod) % mod;
    }

    public static void main(String[] args) {
        int[] A = {5, 4, 2};
        System.out.println(solve(A));
    }
}
