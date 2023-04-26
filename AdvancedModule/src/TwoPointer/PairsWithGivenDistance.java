package TwoPointer;

import java.util.HashMap;

public class PairsWithGivenDistance {
    /*
    Given a one-dimensional integer array A of size N and an integer B.

    Count all distinct pairs with difference equal to B.

    Here a pair is defined as an integer pair (x, y), where x and y are both numbers in the array and their absolute difference is B.
    */
    public static int pairDifference(int[] A, int B) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : A) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        //HashSet<Integer> set=new HashSet<>(map.keySet());

        int cnt = 0;
        for (int i : A) {
            if (B == 0) {
                if (map.containsKey(i) && (map.get(i) > 1)) {
                    cnt++;
                    map.remove(i, map.get(i));
                } }
            else {
                    if (map.containsKey(B + i) && (map.get(B + i) >= 1)) {
                        map.remove(B + i, map.get(B + i));
                        cnt++;
                    }
                }
            }
            return cnt;
        }


        public static void main (String[] args){
            int[] A = {1, 2};
            int B = 0;
            //int[] A={8, 12, 16, 4, 0, 20};
            //int B = 4;
            //int[] A={1, 1, 1, 2, 2};
            //int B = 0;
            System.out.println(pairDifference(A, B));
        }
    }
