package Sorting;

public class BubbleSort {
    public static void swap(int[] A,int a, int b){
        int temp=A[a];
        A[a]=A[b];
        A[b]=temp;
    }
    public static void bubbleSort(int[] A){
        int N=A.length;
        for(int i=0;i<N-1;i++){
            for(int j=0;j<N-i-1;j++){
                if(A[j]>A[j+1])
                    swap(A,j,j+1);
            }
        }
    }

    public static void main(String[] args) {
        int[] S={3,4,5,1,2};
        bubbleSort(S);
        for (int j : S) {
            System.out.print(j + " ");
        }
    }
}
