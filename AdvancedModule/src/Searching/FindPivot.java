package Searching;

public class FindPivot {
    //given a sorted array, rotated kth times given k<len(A), find out k?
    public static int findingPivot(int[] A){
        int ans=0;
        int N = A.length;
        int start = 0;
        int end = N-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(mid<end && A[mid]>A[mid-1] && A[mid]>A[mid+1]){
                ans = mid+1;
            }
            if(mid>start && A[mid]<A[mid+1] && A[mid]<A[mid-1]){
                ans = mid;
            }
            if(A[mid]>A[start]){
                start = mid + 1;
            }else {
                end = mid - 1; //if(A[mid]<A[start])
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        //int[] A={4,5,6,7,0,1,2};
        int[] A={5, 1, 3 };
        System.out.println(findingPivot(A));
    }
}
