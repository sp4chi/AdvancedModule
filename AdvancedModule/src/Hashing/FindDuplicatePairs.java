package Hashing;

import java.util.HashMap;

public class FindDuplicatePairs {
    //return the number of duplicate pair of elements
    public static int findDuplicatesPairs(int[] A){
        HashMap<Integer,Integer> map = new HashMap<>(); //HashMap<value,frequency> map = new HashMap<>()
        int countOfPairs = 0;
        for (int j : A) {
            if (map.containsKey(j)) {
                map.put(j, map.get(j) + 1);
            } else {
                map.put(j, 1);
            }
        }
        for(int i: map.keySet()){
            int f = map.get(i);
            if(f>=2){
                countOfPairs+=f*(f-1)/2;
            }
        }
        return countOfPairs;
    }

    public static void main(String[] args) {
        int[] A = {1,3,3,1,4,5,1};
        System.out.println(findDuplicatesPairs(A));
    }
}
