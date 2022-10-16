package Stacks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

//Given an array of numbers, find out the nearest greater number on the left for every element. Store -1 if no such element is found.
//arr=[1,6,4,12,3,8]
//output arr=[-1,-1,6,-1,12,12]
public class NearestGreater {
    public static void main(String[] args) {
        int[] input1={2,5,10,6,3,4,1};
        System.out.println(outputFromRight(input1));

        //deprecated array declaration
        int[] input2= new int[]{10,9,6,5,3,2,1};
        System.out.println(outputFromRight(input2));

        int[] input3={1,2,3,4,5,6};
        System.out.println(outputFromRight(input3));
    }

    public static String outputFromLeft(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int x : arr) {
            while (!stack.isEmpty() && stack.peek() <= x)
                stack.pop();
            if (stack.empty())
                list.add(-1);
            else
                list.add(stack.peek());
            stack.push(x);
        }
        return list.toString();
    }

    //Nearest greater to the right
    public static String outputFromRight(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        int N = arr.length;
        for (int i = N-1; i >=0; i--) {
            int x = arr[i];
            while (!stack.isEmpty() && stack.peek() <= x)
                stack.pop();
            if (stack.empty())
                list.add(-1);
            else
                list.add(stack.peek());
            stack.push(x);
        }
        Collections.reverse(list);
        return list.toString();
    }
}

//TC-> O(n)
