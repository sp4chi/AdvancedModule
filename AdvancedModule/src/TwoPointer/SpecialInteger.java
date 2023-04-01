package TwoPointer;

public class SpecialInteger {
    //Given an array of integers A and an integer B, find and return the maximum value K such that there is no sub-array in A of size K with the sum of elements greater than B.
    //using binary search approach
    public static int specialIntegerUsingBinarySearch(int[] A,int B){
        int N=A.length;
        int start = 1;
        int end = N;
        int ans = 0;
        while(start<=end){

            int mid = start + (end-start)/2;
            if(slidingWindow(A,B,N,mid) ) {
                ans = mid;
                start = mid + 1;
            } else{
                end = mid - 1;
            }
        }
        return ans;
    }
    public static boolean slidingWindow(int[] A, int B, int N, int mid){
        int sum = 0;
        for(int i=0;i<mid;i++){
            sum+=A[i];
            if(sum>B){
                return false;
            }
        }
        for(int i=mid;i<N;i++){
            sum=sum+A[i]-A[i-mid];
            if(sum>B){
                return false;
            }
        }
        return true;
    }
    public static int twoPointerApproach(int[] A, int B){
        int N = A.length;
        int i = 0;
        int j = 0;
        int sum = 0;
        int ans = 0;
        while(i<=j && j<N){

            if(sum<=B){
                sum+=A[j++];
            }else{
                //if(sum>B)
                sum-=A[i++];
                ans=Math.min(ans,j-i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        //int[] A = {2, 24, 38, 25, 35, 33, 43, 12, 49, 35, 45, 47, 5, 33};
        int[] A={1, 2, 3, 4, 5, 100};
        int B = 10;
        System.out.println(twoPointerApproach(A,B));
    }
}
