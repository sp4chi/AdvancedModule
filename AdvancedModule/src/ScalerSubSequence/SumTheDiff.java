package ScalerSubSequence;

import java.util.Arrays;

public class SumTheDiff {

        static int mod  = 1000000007;
        public static int solve(int[] A) {
            Arrays.sort(A);
            int N = A.length;
            double sum = 0;
            for(int i = 0; i < N ;i++){
                double smallest = Math.pow(2,N-i-1) % mod;
                double largest = Math.pow(2,i) % mod;
                double temp = (largest - smallest + mod) % mod;
                sum = (sum + A[i] * temp) % mod;
            }
            return (int)sum;
        }

    public static void main(String[] args) {
        int[] A={5,4,2};
        System.out.println(solve(A));
    }

}
