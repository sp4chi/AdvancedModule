package Backtracking;

import java.util.Arrays;
import java.util.Scanner;

public class GenerateString {
    // Given 4,5 generate strings of length N
    public static void generateStrings(int A, int B,int N,int idx, int[] out){
//        if(idx == N){
//            System.out.println(sb);
//            return;
//        }
//
//        sb.append(A);
//        generateStrings(A,B,N,idx+1,sb);
//        sb.deleteCharAt(sb.length()-1);
//        sb.append(B);
//        generateStrings(A,B,N,idx+1,sb);
//        sb.deleteCharAt(sb.length()-1);

        if(idx == N){
            System.out.println(Arrays.toString(out));
            return;
        }

        out[idx] = A;
        generateStrings(A,B,N,idx+1,out);
        out[idx] = B;
        generateStrings(A,B,N,idx+1,out);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 1st value: ");
        int A = sc.nextInt();
        System.out.println("Enter 2nd value: ");
        int B = sc.nextInt();
        System.out.println("Enter length of string: ");
        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        int[] out = new int[N];
        generateStrings(A,B,N,0,out);
    }
}
