package Stacks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class FindMaxHistogramArea {
    //using brute force
    public static int largestRectangleBrute(int[] A) {
        int N = A.length;
        int max = 0;
        for (int i = 0; i < N; i++) {
            int temp = A[i];
            int width = 1;

            int area ;
            if (i == N - 1) {
                max = Math.max(max, temp * A[i]);
            }
            int k = i + 1;
            while (k < N && temp <= A[k]) {
                width++;
                k++;
            }
            k = i - 1;
            while (k >= 0 && temp <= A[k]) {
                width++;
                k--;
            }

            area = width * temp;
            max = Math.max(max, area);
        }
        return max;
    }

    //function to find out the largest area enclosed under the histogram
    static int largestRectangle(int[] A) {
        int N = A.length;
        ArrayList<Integer> P1 = NearestSmallestToLeft(A);
        ArrayList<Integer> P2 = NearestSmallestToRight(A);
        int largest = 0;
        for (int i = 0; i < N; i++) {
            int height = A[i];
            int width = P2.get(i) - P1.get(i) - 1;
            int area = height * width;
            largest = Math.max(largest, area);
        }
        return largest;
    }

    //Function to build an array that has indexes of the "nearest smaller number" on the left for every element. Store -1 if no such element is found.
    static ArrayList<Integer> NearestSmallestToLeft(int[] A) {
        int N = A.length;
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> listOfIndexes = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int temp = A[i];
            while (!stack.empty() && A[stack.peek()] >= temp) stack.pop();
            if (stack.empty()) listOfIndexes.add(-1);
            else listOfIndexes.add(stack.peek());
            stack.push(i);
        }
        return listOfIndexes;
    }

    //Function to build an array that has indexes of the "nearest smaller number" on the right for every element. Store -1 if no such element is found.
    static ArrayList<Integer> NearestSmallestToRight(int[] A) {
        int N = A.length;
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> listOfIndexes = new ArrayList<>(N);
        for (int i = N - 1; i >= 0; i--) {
            int temp = A[i];
            while (!stack.empty() && A[stack.peek()] >= temp) stack.pop();
            if (stack.empty()) listOfIndexes.add(N);
            else listOfIndexes.add(stack.peek());
            stack.push(i);
        }
        Collections.reverse(listOfIndexes);
        return listOfIndexes;
    }

    public static void main(String[] args) {
        int[] A = {2, 4, 3, 4, 5, 1};
        System.out.println("List of indexes " + NearestSmallestToLeft(A));
        System.out.println("List if indexes " + NearestSmallestToRight(A));
        System.out.println("Largest rectangle enclosed is " + largestRectangleBrute(A));
    }
}
