package Searching;

public class Peak {
    public static int peak(int[] A) {
        return peak(A,0,A.length-1);
    }
    public static int peak(int[] A, int start, int end){
        while(start<end){
            int mid = start + (end-start)/2;
            if(A[mid] > A[mid+1]){
                end=mid;
            } else {
                start=mid+1;
            }
        }
        return A[start];
    }

    public static void main(String[] args) {
        int[] A={1, 1000000000, 1000000000};
        System.out.println(peak(A));
    }
}


