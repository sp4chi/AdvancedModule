package Hashing;

import java.util.HashSet;

public class DistinctWindowElements {
    //print no. of distinct elements in a window
    public static void distinctElements(int[] A,int k){
        int N = A.length;
        for(int i=0;i<N-k+1;i++){
            HashSet<Integer> set = new HashSet<>();
            int cnt = 0;
            for(int j=0;j<k;j++){
                if(!set.contains(A[i+j])){
                    cnt++;
                }
                set.add(A[i+j]);
            }
            System.out.print(cnt+", ");
        }
    }

    public static void main(String[] args) {
        int[] A={2,4,3,8,3,9,4,9,4,10};
        int k = 4;
        distinctElements(A,k);
    }
}
