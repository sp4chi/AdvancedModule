package Hashing;

import java.util.HashSet;

public class FirstRepeatingInteger {
    public static int firstRepeatingInt(int[] A){
        HashSet<Integer> set = new HashSet<>();
        for (int j : A) {
            if (set.contains(j)) {
                return j;
            } else {
                set.add(j);
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] A={1,9,2,3,18,4,7,9,1};
        System.out.println(firstRepeatingInt(A));
    }
}
