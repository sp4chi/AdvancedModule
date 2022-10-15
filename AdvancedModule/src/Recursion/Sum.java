package Recursion;

public class Sum {
    public static int Sum(int N){
        if(N == 0)
            return 0;
        return N%10+Sum(N/10);
    }

    public static void main(String[] args) {
        System.out.println(Sum(123));
    }
}
