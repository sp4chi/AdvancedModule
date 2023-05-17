package Stacks.Assignments;

import java.util.Stack;

public class BalancedParenthesis {
    public static int solve(String A) {
        Stack<Character> stack = new Stack<>();
        int N = A.length();
        for(int i=0;i<N;i++){

            char temp = A.charAt(i);
            if(temp == '('){
                stack.push(A.charAt(i));
            }
            if( temp == ')'){
                if(stack.isEmpty()){
                    return 0;
                }else{
                    stack.pop();
                }
            }
        }
        if(stack.isEmpty()) return 1;
        return 0;
    }

    public static void main(String[] args) {
        String A = ")))";
        System.out.println(solve(A));
    }
}
