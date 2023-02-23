package Sorting;

public class MergeSort {
    public static void mergeSort(int[] A){
        int N=A.length;
        mergeSort(A,0,N-1);
    }
    public static void mergeSort(int[] A, int start, int end){
        //base case
        if(start>=end)
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
        for(int x=start;x<=end;x++){
            A[x] = temp[x];
        }
    }

    public static void main(String[] args) {
        //int[] A={2,4,3,1,5,7,6};
        int[] A={ 8, 16, 80, 55, 32, 8, 38, 40, 65, 18, 15, 45, 50, 38, 54, 52, 23, 74, 81, 42, 28, 16, 66, 35, 91, 36, 44, 9, 85, 58, 59, 49, 75, 20, 87, 60, 17, 11, 39, 62, 20, 17, 46, 26, 81, 92};
        mergeSort(A);
        for(int i: A){
            System.out.print(i+" ");
        }
    }

}
