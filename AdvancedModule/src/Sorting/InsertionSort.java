package Sorting;

public class InsertionSort {
    public static void insertionSort(int[] A){
        int N=A.length;
        for(int i = 1; i<N ; i++){
            int j = i-1;
            int temp = A[i];
            while (j>=0 && A[j]>temp ){
                A[j+1] = A[j];
                j--;
            }
            A[j+1] = temp;
        }
    }
    public static void main(String[] args) {
        int[] S={3,4,5,1,2};
        insertionSort(S);
        for (int j : S) {
            System.out.print(j + " ");
        }
    }
}
