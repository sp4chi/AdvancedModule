package Recursion;

public class CheckSortedArray {
    public static boolean isSorted1(int[] A,int N){
        if(N==1 || N==0)
            return true;
        return (A[N-1]>=A[N-2]) && isSorted1(A,N-1);
    }

    public static boolean isSorted2(int[] A,int i,int N){
        if(i==N-1)
            return true;
        return A[i]<=A[i+1] && isSorted2(A,i+1,N-1);
    }

    public static void main(String[] args) {
        int[] A={1,1,2,1};
        System.out.println(isSorted2(A,0,A.length));
    }
}
