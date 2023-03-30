package ArrayScaler;

import java.util.Arrays;

public class TripletSum {
    //brute force approach
    //Time - O(N*N*N)
    //Space - O(1)
    public static void printTripletsBrute(int[] A, int sum){
        int N=A.length;
        for(int i = 0;i<N-2;i++){
            for(int j = i+1;j<N-1;j++){
                for(int k = j+1;k<N;k++){
                    if(A[i] + A[j] + A[k] == sum){
                        System.out.println("Triplets using brute : " + A[i] + " " + A[j] + " " + A[k]);
                    }
                }
            }
        }
    }
    //efficient approach using two pointer
    //time - O(N*N)
    //space - O(N)
    public static void printTripletsTwoPointer (int[] A,int sum){
        int N=A.length;
        Arrays.sort(A);
        for(int i=0;i<N-2;i++){
            int target=sum-A[i];
            int j=i+1;
            int k=N-1;
            while(j<k) {
                if(A[j] + A[k] == target){
                    System.out.println("Triplets using two pointer : " + A[i] + " " + A[j] + " " + A[k]);
                    j++;k--;
                }else if (A[j] + A[k] > target) {
                    k--;
                }else if (A[j] + A[k] < target) {
                    j++;
                }
            }
        }
    }
    //function to print total triplets less than or equal to given sum
    public static void PrintTripletPairs (int[] A,int sum){
        int N=A.length;
        Arrays.sort(A);
        int total = 0;
        for(int i=0;i<N-2;i++){
            int target=sum-A[i];
            int j=i+1;
            int k=N-1;
            int cnt=0;
            while(j<k) {
                if (A[j] + A[k] > target) {
                    k--;
                } else {
                    //if (A[j] + A[k] <= target)
                    cnt += (k - j);
                    j++;
                }
            }
            total+=cnt;
        }
        System.out.println("Printing total triplets less than or equal to given sum: "+total);
    }

    public static void main(String[] args) {
        int[] A = {10,8,8,2,3,3,4,6,7,1};
        PrintTripletPairs(A,12);
        System.out.println("----------------------------------------------------------------");
        printTripletsBrute(A,12);
        System.out.println("----------------------------------------------------------------");
        printTripletsTwoPointer(A,12);
    }
}
