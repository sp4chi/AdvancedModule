package Searching;

public class PaintersPartition {
    static int mod = 10000003;
    public static int binarySearch(int A, int B, int[] C) {
        int N = C.length;
        long max = 0;
        long sum = 0;
        for (int j : C) {
            max = Math.max(max, j);
            sum += j;
        }
        long start = max * (long)B;
        long end = sum * (long)B;
        while(start<=end){
            long mid = start + (end - start)/2;
            if(checkingFunction(B,C,N,mid) > A){
               start = mid + 1;
            } else{
                //if(checkingFunction(A,B,C,N,mid) <= A)
                end = mid - 1;
            }
        }
        return (int)(start%mod);
    }
    public static int checkingFunction(int B, int[] C, int N, long mid){
        int painters = 1;
        long time = 0;
        int i = 0;
        while(i<N){
            time+=C[i] * (long)B;
            if(time>mid){
                painters++;
                time = C[i] * (long)B;
            }
            i++;
        }
        return painters;
    }

    public static void main(String[] args) {
        int A = 1;
        int B =  1000000;
        int[] C = { 1000000, 1000000};
        System.out.println(binarySearch(A,B,C));
    }
}
