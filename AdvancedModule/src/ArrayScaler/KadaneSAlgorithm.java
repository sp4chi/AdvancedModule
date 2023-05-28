package ArrayScaler;

public class KadaneSAlgorithm {
    //Finding the largest sum of a sub-array
    public static int maxSubArraySum(int[] A){
        int N = A.length;
        int max_till_here = 0;
        int max_overall = Integer.MIN_VALUE;
        for(int i=0;i<N;i++){
            max_till_here += A[i];
            if(max_till_here<0){
                max_till_here = 0;
            } else if(max_overall<max_till_here){
                max_overall = max_till_here;
            }
        }
        return max_overall;
    }

    public static void main(String[] args) {
        int[] A = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(maxSubArraySum(A));
    }
}
