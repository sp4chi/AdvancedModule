package Hashing;

import java.util.HashMap;

public class LargestContinuousSequenceZeroSum {
    /*Given an array A of N integers. Find the largest continuous sequence in an array which sums to zero.
    Return an array denoting the longest continuous sequence with total sum of zero.
    NOTE : If there are multiple correct answers, return the sequence which occurs first in the array.
    Example-
    input :A=[1,2,-2,4,-4];
    output :A=[2,-2,4,-4];*/

    public static int[] largestArray(int[] A){
        int N=A.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int len=0;
        int start = 0;
        for(int i=0;i<N;i++){
            sum+=A[i];
            if(sum == 0){
                len = i+1;
                start = 0;
            }
            if(map.containsKey(sum)){
                int prevLen = len;
                len=Math.max(len,i-map.get(sum));
                if(prevLen < len){
                    start = map.get(sum)+1;
                }
            }else{
                map.put(sum,i);
            }
        }
        int[] ans = new int[len];
        int k=start;
        for(int i=0;i<len;i++){
            ans[i] = A[k++];
        }
        return ans;
    }

    public static void main(String[] args) {
        //int[] A={15,2,-2,4,-1,-3,19};
        //int[] A={1, 2, -3, 3};
        int[] A={1,-1, 20, 7, -22, 1, 21, 5, 24, -26, -16, -4, -9, 19, 8, -27, 28, 9, 8, -29, 29, 8, 9, 17, -28, 13, 20, -1, -8, -16};
        int[] ans = largestArray(A);
        for(int i:ans){
            System.out.print(i+" ");
        }
    }
}
