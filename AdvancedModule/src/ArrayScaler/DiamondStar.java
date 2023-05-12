package ArrayScaler;

import java.util.Scanner;

public class DiamondStar {
    //Write a program to input an integer N from user and print hollow diamond star pattern series of N lines.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter N:");
        int N = sc.nextInt();
        //top
        int start = 0;
        int end = N;
        for (int i = start; i < end; i++) {
            //top left triangle
            for (int j = start; j < end - i; j++) {
                System.out.print("*");
            }
            //printing spaces
            for (int j = end - i; j < end; j++) {
                System.out.print(" ");
            }
            for (int j = end; j < end + i; j++) {
                System.out.print(" ");
            }
            //right top triangle
            for (int j = end + i; j < 2 * end; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        //bottom
        for (int i = start; i < end; i++) {
            //bottom left triangle
            for (int j = start; j <= i; j++) {
                System.out.print("*");
            }
            //printing spaces
            for (int j = i; j < end - 1; j++) {
                System.out.print(" ");
            }
            //printing spaces
            for (int j = end; j < 2 * end - i - 1; j++) {
                System.out.print(" ");
            }
            //bottom right triangle
            for (int j = 2 * end - 1 - i; j < 2 * end; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

