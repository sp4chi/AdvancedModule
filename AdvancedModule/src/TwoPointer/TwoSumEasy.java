package TwoPointer;

public class TwoSumEasy {
    //Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.
    //
    //If the answer does not exist return an array with a single element "-1".
    //
    //First sub-array means the sub-array for which starting index in minimum
    public static int[] twoPointer(int[] A, int B) {
        int N = A.length;
        int start = 0;
        int end = 0;
        int[] ans = {-1};
        int sum = A[start];
        while(end<N && start<=end){
            if(sum == B){
                int n = end - start + 1;
                int[] sol = new int[n];
                for(int i=0;i<n;i++){
                    sol[i] = A[start++];
                }
                return sol;
            }
            else if(sum < B){
                end++;
                if(end < N){
                    sum+=A[end];
                }
            } else{
                sum-=A[start];
                start++;
                if(start>end){
                    end++;
                    if(end<N) {
                        sum+=A[end];
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A={15, 2, 5, 6, 9,11,8, 10 };
        int B = 13;
        int[] ans=twoPointer(A,B);
        for (int an : ans) {
            System.out.print(an + " ");
        }
    }
}
