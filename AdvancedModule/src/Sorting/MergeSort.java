package Sorting;

public class MergeSort {
    public static void mergeSort(int[] A, int start, int end){
        //base case
        if(start>=end)
            return;
        //recursive case\
        int mid=(start+end)/2;

        mergeSort(A,start,mid);
        mergeSort(A,mid+1,end);
        merge(A,start,mid,end);
    }
    public static void merge(int[] A,int start, int mid, int end){
        int N=A.length;
        int[] temp=new int[N];
        int i=start;
        int j=mid;
        int k=start;
        while( i<=mid && j<=end){
            if(A[i]<=A[j]) {
                temp[k] = A[i];
                k++;
                i++;
            }
            else{
                temp[k]=A[j];
                k++;j++;
            }


        }
    }

}
