package Stacks;

import java.util.ArrayList;
import java.util.Stack;

//Given an array of stocks, find out the span for each element when it was higher than previous elements.
//input=[100,80,60,70,60,75,85]
//output=[1,1,1,2,1,4,6]
//https://leetcode.com/problems/online-stock-span/
public class StockSpan {
    public static void main(String[] args) {
        int[] stocks1={100,80,60,70,60,75,85};
        System.out.println(span(stocks1));

        int[] stocks2={2,5,7,3,6,8,9,4};
        System.out.println(span(stocks2));
    }
    public static ArrayList<Integer> span(int[] stocks){
        Stack<Integer> stack=new Stack<>();
        ArrayList<Integer> span=new ArrayList<>();
        span.add(1);
        stack.push(0);
        for(int i=1;i<stocks.length;i++){
            int current=stocks[i];
            while(!stack.isEmpty() && current>=stocks[stack.peek()])
                stack.pop();
            if(stack.empty())
                span.add(i+1);
            else
                span.add(i-stack.peek());
            stack.push(i);
        }
        return span;
    }

}
