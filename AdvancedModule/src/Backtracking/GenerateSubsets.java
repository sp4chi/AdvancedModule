package Backtracking;

public class GenerateSubsets {
    // generate all subsets - only for unique characters
    // 1. build the tree -
    // 2. select a character or skip, backtrack before calling right subtree
    // 3. print only the leaf

    public static void generateSubSets(int N, int idx, StringBuilder out, String input) {
        if (idx == N) {
            if (out.length() == 0) System.out.println("''");
            else System.out.println(out);
            return;
        }

        // preorder traversal -  root -> left subtree -> right subtree
        // or dfs then backtrack


        // select char
        out.append(input.charAt(idx));
        generateSubSets(N, idx + 1, out, input);

        // backtrack - remove last char
        out.deleteCharAt(out.length() - 1);

        // skip
        generateSubSets(N, idx + 1, out, input);


    }

    public static void main(String[] args) {
        String input = "abcd";
        StringBuilder sb = new StringBuilder();
        generateSubSets(input.length(), 0, sb, input);
    }
}
