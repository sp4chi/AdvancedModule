package Sorting;

public class BubbleSort {
    public static void swap(int a,int b){
        int temp=a;
        a=b;
        b=temp;
    }
    public static void Sort(int[] A){
        int N=A.length;
        for(int i=0;i<N-1;i++){
            for(int j=0;j<N-i-1;j++){
                if(A[i]>A[j])
                    swap(A[i],A[j]);
            }
        }
    }

    public static void main(String[] args) {
        int[] S={3,4,5,1,2};
        Sort(S);
        for(int i=0;i<S.length;i++){
            System.out.print(S[i]+" ");
        }
    }
}
