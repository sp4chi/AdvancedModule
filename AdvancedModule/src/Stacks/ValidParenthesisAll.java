package Stacks;

import java.util.Stack;

public class ValidParenthesisAll {
    public static void main(String[] args) {
        String input="]";
        System.out.println(isValid(input));
    }

    public static boolean isValid(String s){
        Stack<Character> stack=new Stack<>();
        for(char c:s.toCharArray()){
            if(c == '(' || c == '[' ||c == '{' )
                stack.push(c);
            if(c==')'){
                if(stack.isEmpty())
                    return false;
                else if(stack.peek()=='(')
                    stack.pop();
            }
            if(c=='}' ){
                if(stack.isEmpty())
                    return false;
                else if(stack.peek()=='{')
                    stack.pop();
            }

            if(c==']' ){
                if(stack.isEmpty())
                    return false;
                else if(stack.peek()=='[')
                    stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
