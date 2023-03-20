package ArrayScaler;
import java.util.*;
public class TripletSum {
    public static void PrintTripletPairs (int[] A,int sum){
        int len=A.length;
        Arrays.sort(A);
/*
        for (int x:A) {
            System.out.print(x+" ");
        }
        System.out.println();
*/

        int total = 0;
        for(int i=0;i<len-3;i++){
            int target=sum-A[i];
            int j=i+1;
            int k=len-1;
            int cnt=0;
            //[1,2,3,4,6,7,8,10]
            while(j<k) {
                if (A[j] + A[k] > target) {
                    k--;
                } else if (A[j] + A[k] <= target) {
                    cnt += (k - j);
                    j++;
                   // System.out.println(cnt);
                }
            }
            total+=cnt;
        }
        System.out.println("total pairs : "+total);
    }

    public static void main(String[] args) {
        int[] A = {10,8,2,3,4,6,7,1};
        PrintTripletPairs(A,12);
    }
}
