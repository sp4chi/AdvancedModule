package Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MigratoryBirds {
    public static int migratoryBirds(List<Integer> arr) {
        // Write your code here
        int N = arr.size();
        int[] A = new int[6];


        for(int i=0;i<N;i++){
            if(arr.get(i) == 1) A[1]++;
            else if(arr.get(i) == 2) A[2]++;
            else if(arr.get(i) == 3) A[3]++;
            else if(arr.get(i) == 4) A[4]++;
            else if(arr.get(i) == 5) A[5]++;
        }
        int max = 0;
        int maxType = -1;
        for(int i=1;i<6;i++){
            if(max < A[i]){
                max = A[i];
                maxType = i;
            }
        }
        return maxType;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 4 ,4, 4 ,5 ,3));
        System.out.println("Type: "+migratoryBirds(list));
    }
}
