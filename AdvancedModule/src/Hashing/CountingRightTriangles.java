package Hashing;

import java.util.HashMap;

public class CountingRightTriangles {
    // Given N points in 2D cartesian plane, find no. of right-angled triangles that
    // can be formed such that their 2 small sides are parallel to x-axis and
    // y-axis.
    public static int helper(int[] A, int[] B) {
        int N = A.length;
        int count = 0;
        HashMap<Integer, Integer> hx = new HashMap<>();
        HashMap<Integer, Integer> hy = new HashMap<>();
        for (int i = 0; i < N; i++) {
            hx.put(A[i], hx.getOrDefault(A[i], 0) + 1);
            hy.put(B[i], hy.getOrDefault(B[i], 0) + 1);
        }
        for (int i = 0; i < N; i++) {
            int x = hx.get(A[i]);
            int y = hy.get(B[i]);
            count = count+ countRightTriangles(x, y);
        }
        return count;
    }
    public static int countRightTriangles(int x, int y) {
        return (x - 1) * (y - 1);
    }
    public static void main(String[] args) {
        // int[][] A = { { 1, 1 }, { 1, -5 }, { 1, 4 }, { 1, 7 }, { 3, 1 }, { 5, 1
        // },{1,10} };
        int[] A = { 1, 1, 2, 3, 3};
        int[] B = { 1, 2, 1, 2, 1};
        System.out.println(helper(A,B));
    }
}
