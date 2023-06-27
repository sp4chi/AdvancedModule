package Sorting;

public class MergeSort {
    public static void mergeSort(int[] A){
        int N=A.length;
        mergeSort(A,0,N-1);
    }
    public static void mergeSort(int[] A, int start, int end){
        //base case
        if(end-start+1 == 1)
            return;
        //recursive case
        int mid=(start+end)/2;

        mergeSort(A,start,mid);
        mergeSort(A,mid+1,end);
        merge(A,start,mid,end);
    }
    public static void merge(int[] A,int start, int mid, int end){
        int N=A.length;
        int[] temp=new int[N];
        int i=start;
        int j=mid+1;
        int k=start;
        while( i<=mid && j<=end){
            if(A[i]<=A[j]) {
                temp[k] = A[i];
                i++;
            }
            else{
                temp[k]=A[j];
                j++;
            }
            k++;
        }

        while(i<=mid){
            temp[k] = A[i];
            i++; k++;
        }
        while(j<=end){
            temp[k] = A[j];
            j++;k++;
        }

        /* for(int x=start;x<=end;x++){
                A[x] = temp[x];
         }*/
        //same as the above loop
        if (end + 1 - start >= 0) System.arraycopy(temp, start, A, start, end + 1 - start);
    }

    public static void main(String[] args) {
        int[] A={2,4,3,1,5,7,6,-19};
        mergeSort(A);
        for(int i: A){
            System.out.print(i+" ");
        }
    }

}
