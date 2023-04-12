package Recursion;

public class Sum {
    public static int sum(int N) {
        if (N == 0)
            return 0;
        return N % 10 + sum(N / 10);
    }

    public static void main(String[] args) {
        System.out.println(sum(123));
    }
}
