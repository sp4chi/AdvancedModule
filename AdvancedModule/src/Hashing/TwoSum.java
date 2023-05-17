package Hashing;

import java.util.HashMap;

public class TwoSum {
    public static int[] twosum(int[] A, int sum){
        HashMap<Integer, Integer> map = new HashMap<>();
        int N = A.length;
        for(int i=0;i<N;i++){
            int target = sum - A[i];
            if(map.containsKey(target)){
                return new int[]{map.get(target)+1,i+1};
            }
            map.putIfAbsent(A[i],i);

        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] A={10,-3,5,-7};
        int sum = -2;
        int[] B = twosum(A,sum);
        for(int i: B){
            System.out.print(i+" ");
        }
    }
}
