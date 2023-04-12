package GCD;

//given N numbers find their gcd.
public class FindNGCD {
    public static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    public static int main(int[] A) {
        int ans = 0;
        for (int x : A) {
            ans = gcd(ans, x);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = { 10, 12, 11, 32 };
        System.out.println(main(A));
    }
}
