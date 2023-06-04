package Hashing;

import java.util.HashSet;

public class FindDiff {
    /*
    Given an array A of integers and another non-negative integer B .
    Find if there exists 2 indices i and j such that A[i] - A[j] = B and i != j.
    */
    public static int isDiffPresent(int[] A, int B) {
        HashSet<Integer> set = new HashSet<>();
        for (int j : A) {
            if (set.contains(j - B)) {
                /*System.out.println(A[i] - B);
                System.out.println(A[i]);*/
                return 1;
            }
            if (set.contains(j + B)) {
                /*System.out.println(A[i] + B);
                System.out.println(A[i]);*/

                return 1;
            }
            set.add(j);

        }
        return 0;
    }

    public static void main(String[] args) {
        int[] A = {11,85,100,44,3,32,96,72,93,76,67,93,63,5,10,45,99,35,13};
        int B = 60;
        System.out.println(isDiffPresent(A,B));
    }
}
