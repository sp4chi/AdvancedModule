package ArrayScaler;

public class MaxSubArray {
    public static int[] maxSubArray(int[] A) {
        int N = A.length;
        int maxSoFar = 0;
        int idx = -1;
        int maxSize = Integer.MIN_VALUE;

        //looping to find max
        for (int i = 0; i < N; i++) {
            if (A[i] >= 0) {
                maxSoFar++;
                maxSize = Math.max(maxSize, maxSoFar);
            } else {
                maxSoFar = 0;
            }
        }

        //looping to find the first largest sub-array in case more than one exist
        int k = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] >= 0) {
                k++;
                if (k == maxSize) {
                    if (k < i) {
                        idx = Math.abs(k - i) + 1;
                    } else {
                        idx = Math.abs(k - i - 1);
                    }
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
    public static int[] solve(int[] A){
        int N=A.length;

        // Step 1 : Carry forword
        int count=0,finalCount=0;   // to count elements.
        int start=0,finalStart=0;   // to note index positions.

        for (int i=0; i<N; i++){
            if (A[i]>=0){               // Positive Value
                count++;
                if (finalCount<count){  // finalCount less than count
                    finalCount=count;
                    finalStart=start;
                }
            }
            if (A[i]<0){                // Nagative Value
                count=0;
                if (i+1!=N){            // Edge case
                    start=i+1;
                }
            }
        }

        // Step 2 : Creating an array of size 'finalCount'.
        int[] out= new int[finalCount];
        for (int i=0; i<finalCount; i++) {
            out[i]=A[i+finalStart];
        }


        return out;
    }

    public static void main(String[] args) {
        int[] A = {-5, 6, 1, 9, -8, -7, 0};
        int[] B = maxSubArray(A);
        for (int i : B) {
            System.out.print(i + " ");
        }
    }
}
