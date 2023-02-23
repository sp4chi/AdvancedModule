package Sorting;

public class Merging {
    public static int[] merge(int[] A,int[] B) {
        int N=A.length+B.length;
        int i = 0;
        int j = 0;
        int k = 0;
        int[] C = new int[N];

        while(i<A.length && j<B.length){
            if( A[i] < B[j] ){
                C[k] = A[i];
                i++;
            }
            else {
                C[k] = B[j];
                j++;
            }
            k++;
        }

        //copying remaining elements of A array
        while( i < A.length ){
            C[k] = A[i];
            i++;
            k++;
        }
        while( j < B.length){
            C[k] = B[j];
            j++;
            k++;
        }
        return C;
    }

    public static void main(String[] args) {
        int[] A={2,3,4};
        int[] B={1,5,7,6};
        int[] helper = merge(A,B);
        for(int i: helper){
            System.out.print(i+" ");
        }
    }
}
