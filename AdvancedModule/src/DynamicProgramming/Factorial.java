package DynamicProgramming;

public class Factorial {
    public static int factorial(int N){
        if(N <= 1){
            return N;
        }
        int f = factorial(N-1);
        return N*f;
    }
    //no overlapping problem so dp will not speed up the calculation
    public static void main(String[] args) {
        int N = 5;
        System.out.println(factorial(N));
    }
}
