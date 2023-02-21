package Sorting;

public class SelectionSort {
    public static void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    public static void selectionSort(int[] A){
        int N= A.length;

        for(int i = 0;i<N-1;i++){
            int minIdx = i;
            for(int j = i+1; j<N;j++){
                if(A[j]<A[minIdx]){
                    minIdx = j;
                }
            }
            swap(A,i,minIdx);

        }
    }
    public static void main(String[] args) {
        int[] S={3,4,5,1,2};
        selectionSort(S);
        for (int j : S) {
            System.out.print(j + " ");
        }
    }
}
