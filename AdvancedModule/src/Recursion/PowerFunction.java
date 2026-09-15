package Recursion;

public class PowerFunction {
    public static double powerFunction(double x, int n){
        if(x == 0){
            return 0;
        }

        if(n == 0){
            return 1;
        }

        long N = n;
        if(n < 0){
            x = 1 / x;
            N = -N;
        }

        return fastPow(x,N);
    }

    private static double fastPow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }

        // Clean integer division: n / 2
        double half = fastPow(x, n / 2);

        if (n % 2 == 0) {
            return half * half;
        } else {
            return x * half * half;
        }
    }

    public static void main(String[] args) {
        double x = 2.0;
        int n = -2;

        System.out.println(powerFunction(x,n));
    }
}
