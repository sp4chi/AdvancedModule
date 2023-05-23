package Stacks;

import java.util.Stack;

public class ValidParenthesis {
    public static boolean check(String s) {
        Stack<Character> stack = new Stack<>();
        for (int x = 0; x < s.length(); x++) {
            if (s.charAt(x) == '(')
                stack.push('(');
            if (s.charAt(x) == ')') {
                if (stack.isEmpty())
                    return false;
                else
                    stack.pop();
            }
        }
        return stack.empty();

    }

    public static void main(String[] args) {
        String input="(]}])}";
        System.out.println(check(input));
    }
}

