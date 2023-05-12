package ArrayScaler;

public class MaxSubArray {
    public static int[] maxSubArray(int[] A) {
        int N = A.length;
        int maxSoFar = 0;
        int maxSize = Integer.MIN_VALUE;

        //looping to find max
        for (int value : A) {
            if (value >= 0) {
                maxSoFar++;
                maxSize=Math.max(maxSize,maxSoFar);
            } else {
                maxSoFar = 0;
            }
        }

        //looping to find the first largest sub-array in case more than one exist
        int k = 0;
        int idx = -1;
        for (int i = 0; i < N; i++) {
            if (A[i] >= 0) {
                k++;
                if (k == maxSize) {
                    idx = Math.abs(k - i - 1);
                    break;
                }
            } else {
                k = 0;
            }

        }

        int[] out = new int[maxSize];
        int j = 0;
        while (j < maxSize) {
            out[j] = A[idx];
            j++;
            idx++;
        }
        return out;
    }

    //Scaler solution
    public static int[] solve(int[] A) {
        int size = 0, left = 0, right = 0;
        for (int l = -1, r = 0; r < A.length; r++) {
            if (A[r] >= 0) {
                if (size < r - l) {
                    size = r - l;
                    left = l;
                    right = r;
                }
            } else {
                l = r;
            }
        }
        int[] ans = new int[size];
        for (int i = left + 1; i <= right; i++) ans[i - left - 1] = A[i];
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {-5, 6, 1, 9, -8, -7, 0};
        int[] B = maxSubArray(A);
        for (int i : B) {
            System.out.print(i + " ");
        }
    }
}
