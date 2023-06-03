package Hashing;

import java.util.Arrays;
import java.util.HashMap;

public class DistinctWindows {
    public static int[] distinctWindow(int[] A, int B) {
        int N = A.length;
        int[] ans = new int[N - B + 1];
        int k = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < B; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
        }
        ans[k++] = map.size();
        for (int i = 1; i < N - B + 1; i++) {
            map.put(A[i + B - 1], map.getOrDefault(A[i + B - 1], 0) + 1);

            map.put(A[i - 1], map.get(A[i - 1]) - 1);
            if (map.get(A[i - 1]) == 0) {
                map.remove(A[i - 1]);
            }
            ans[k++] = map.size();
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 1, 3, 4, 3};
        int B = 3;
        System.out.println(Arrays.toString(distinctWindow(A, B)));
    }
}
