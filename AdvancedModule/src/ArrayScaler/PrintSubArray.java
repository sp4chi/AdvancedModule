package ArrayScaler;

public class PrintSubArray {
    public static void main(String[] args) {
        int[] arr = {2,2,3,4,5};
        int N = arr.length;
        for(int i=0; i<N;i++){
            for(int j=i;j<N;j++){
                //printing sub array from i - j
                for(int k=i;k<=j;k++){
                    System.out.print(arr[k]+" ");
                }
                System.out.println();
            }
        }

    }
}
