package Searching;

public class UniqueNumber {
    //Given 2N + 1 numbers in a sorted array, where every Number repeats twice except one unique number. Find out the unique number.
    public static int uniqueNumber(int[] A){
        int start = 0;
        int end = A.length-1;
        int ans = -1;
        while(start<=end){
            if(A[0]!=A[1])
                return A[0];
            if(A[end]!=A[end-1])
                return A[end];
            int mid = start + (end-start)/2;
            if(A[mid]!=A[mid-1] && A[mid]!=A[mid+1]){
                return A[mid];
            }else if(mid%2 == 0 && A[mid]==A[mid+1] ){
                start = mid +2;
            }else if(mid%2 != 0 && A[mid]==A[mid-1]){
                start = mid + 1;
            } else if (mid%2 == 0 && A[mid]==A[mid-1]) {
                end = mid - 2;
            } else if (mid%2 !=0 && A[mid] == A[mid+1]) {
                end = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A=  {1,1,2,2,3,3,5,5,6,7,7} ;
        System.out.println(uniqueNumber(A));
    }
}
