package ArrayScaler;

public class MaxSumContiguousArray {
    public static int maxSum(int[] A) {
        int N = A.length;
        int curr_sum=0;
        int max_sum=Integer.MIN_VALUE;
        for(int i=0;i<N;i++){
            curr_sum += A[i];
            max_sum=Math.max(max_sum,curr_sum);
            if(curr_sum<0) curr_sum = 0;
        }

        return max_sum;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, -10};
        System.out.println(maxSum(A));
    }
}
