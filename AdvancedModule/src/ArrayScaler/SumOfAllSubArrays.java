package ArrayScaler;

public class SumOfAllSubArrays {
    //Given an integer array of size N, find the sum of all sub-arrays of the given array.

    //Brute Force - tc -> O(N*N)
    public static int sumOfAllSubArrayBrute(int[] A) {
        int N = A.length;
        int sum = 0;

        for (int i = 0; i < N; i++) {
            int temp = 0;
            for (int j = i; j < N; j++) {
                temp += A[j];
                sum += temp;
            }
        }

        return sum;
    }

    //Approach, find contribution of each element in all sub-arrays. (=N-i)
    public static int sumOfAllSubArrayOptimised(int[] A) {
        int N = A.length;
        int sum = 0;

        for (int i = 0; i < N; i++) sum += A[i] * (i + 1) * (N - i);

        return sum;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4};
        System.out.println("Brute: "+sumOfAllSubArrayBrute(A));
        System.out.println("Optimised: "+sumOfAllSubArrayOptimised(A));
    }

}
