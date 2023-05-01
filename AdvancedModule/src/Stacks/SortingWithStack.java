package Stacks;

import java.util.Stack;

public class SortingWithStack {
    /*
    Algorithm:
     1. Create a temporary stack say tmpStack.
     2. While input stack is NOT empty do this:
          ->Pop an element from input stack call it temp
          ->while temporary stack is NOT empty and top of temporary stack is greater than temp, pop from temporary stack and push it to the input stack
     3. push temp in temporary stack
    The sorted numbers are in tmpStack

    time - 0(N^N)
    space - O(N)
    */
    public static Stack<Integer> sortStack(Stack<Integer> stack){
        Stack<Integer> tempStack = new Stack<>();
        while(!stack.empty()){
            int temp = stack.pop();
            while(!tempStack.empty() && tempStack.peek()>temp){
                stack.add(tempStack.pop());
            }
            tempStack.add(temp);
        }
        return tempStack;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(5);
        stack.add(17);
        stack.add(100);
        stack.add(11);
        System.out.println(sortStack(stack));
    }
}
