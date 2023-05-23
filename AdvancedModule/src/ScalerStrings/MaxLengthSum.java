package ScalerStrings;

import java.util.HashSet;

public class MaxLengthSum {
    //Given an array of Strings , A = ["abc", "dog", "ac", "bc", "dg"]. Find the max of length(A[i])+length(A[j]) such that A[i] and A[j] are strings that have distinct characters.
    public static int maxProduct(String[] A) {
        int N = A.length;
        int max = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (isDistinct(A[i], A[j])) {
                    int sum = A[i].length() + A[j].length();
                    max = Math.max(max, sum);
                }
            }
        }
        return max;
    }
    //time complexity = O(N*N*M)

    public static boolean isDistinct(String A, String B) {
        HashSet<Character> set = new HashSet<>();
        int N = A.length();
        int M = B.length();
        for (int i = 0; i < N; i++) set.add(A.charAt(i));
        for (int i = 0; i < M; i++) {
            char temp = B.charAt(i);
            if (set.contains(temp)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] A = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        System.out.println(maxProduct(A));
    }
}
