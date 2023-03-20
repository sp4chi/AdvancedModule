package Sorting;

public class QuickSort {
    public static void quickSort(int[] A){
        quickSort(A,0,A.length-1);
    }
    public static void quickSort(int[] A, int start, int end){
        if(start>=end)
            return ;
        int index = partition(A,start,end);
        quickSort(A,start,index-1);
        quickSort(A,index+1,end);
    }
    public static void swap(int[] A,int i,int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    public static int partition(int[] A,int start, int end){
        int pivot = A[end];
        int i=start;
        for(int j=start;j<end;j++){
            if(A[j]<pivot){
                swap(A,i,j);
                i++;
            }
        }
        swap(A,i,end);
        return i;
    }

    public static void main(String[] args) {
        //int[] A={2,4,3,1,5,7,6};
        int[] A={6,2,8,5,1,4,3,7,6};
        quickSort(A);
        for(int i: A){
            System.out.print(i+" ");
        }
    }
}
