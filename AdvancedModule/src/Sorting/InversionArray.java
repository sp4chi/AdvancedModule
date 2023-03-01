package Sorting;

public class InversionArray {
    public static int mergeSort(int[] A){
        return mergeSort(A,0,A.length-1);
    }
    public static int mergeSort(int[] A,int start,int end){
        if(start>=end)
            return 0;
        int mid = (start+end)/2;
        int x=mergeSort(A,start,mid);
        int y=mergeSort(A,mid+1,end);
        int z=inversion(A,start,mid,end);
        return x+y+z;
    }
    public static int inversion(int[] A,int start, int mid,int end ) {
        int[] temp = new int[A.length];
        int invCnt = 0;
        int i = start;
        int k = start;
        int j = mid + 1;
        while (i <= mid && j <= end) {
            if(A[i]<=A[j]){
                temp[k]=A[i];
                i++;
            }
            else{
                invCnt+=mid-i+1;
                temp[k]=A[j];
                j++;
            }
            k++;
        }
        while(i<=mid){
            temp[k]=A[i];
            i++;k++;
        }
        while(j<=end){
            temp[k] = A[j];
            j++;k++;
        }
        for(int x=start;x<=end;x++){
            A[x]=temp[x];
        }
        return invCnt;
    }
    public static void main(String[] args) {
        //int[] A={2,4,3,1,5,6,7,6};
        //int[] A={3,2,8,5,1,6,4,7,6};
        int[] A={7,5,8,6,4,9,4};
        System.out.println("Inversions in the array are: "+mergeSort(A));

    }
}
