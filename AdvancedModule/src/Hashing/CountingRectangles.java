package Hashing;

import java.util.HashSet;

public class CountingRectangles {
    /*Given two arrays of integers A and B of size N each, where each pair (A[i], B[i]) for 0 <= i < N represents a unique point (x, y) in a 2-D Cartesian plane. Find and return the number of unordered quadruplet (i, j, k, l) such that (A[i], B[i]), (A[j], B[j]), (A[k], B[k]) and (A[l], B[l]) form a rectangle with the rectangle having all the sides parallel to either x-axis or y-axis.*/
    public static int helper(int[] A,int[] B){
        int N=A.length;
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<N;i++){
            set.add(encode(A[i],B[i]));
        }
        int cnt = 0;
        for(int i=0;i<N-1;i++){
            for(int j=i+1;j<N;j++){
                int x1 = A[i];
                int y1 = B[i];
                int x2 = A[j];
                int y2 = B[j];
                if(!(x1 == x2 || y1 == y2)){
                    String p1 = encode(x2,y1);
                    String p2 = encode(x1,y2);
                    if(set.contains(p1) && set.contains(p2))
                        cnt++;
                }
            }
        }
        return cnt/2;
    }
    public static String encode(int A,int B){
        return A+"@"+B;
    }

    public static void main(String[] args) {
        /*int[] A={1, 1, 2};
        int[] B={1, 2, 1};*/
        int[] A={1, 1, 2, 2, 3, 3};
        int[] B={1, 2, 1, 2, 1, 2};
        System.out.println(helper(A,B));
    }
}
