package ScalerSubSequence;

public class SubSequenceSum {
    public static int sum(int[] A,int B){
        int N = A.length;
        for(int i=0;i<(1<<N);i++){
            int sum = 0;
            for(int j=0;j<N;j++){
                if(((1<<j)&i) != 0) sum += A[j];
            }
            if(sum == B) return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] A={11,9};
        System.out.println(sum(A,9));
    }
}
