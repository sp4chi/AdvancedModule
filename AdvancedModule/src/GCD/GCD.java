package GCD;

public class GCD {
    //using recursion
    public static int gcd(int a, int b){
        if(a== 0)
            return b;
        return gcd(b%a,a);
    }

    //using loop
    public static int gdc_loop(int a, int b){

        while(a!=0){
            int temp=b;
            b= a;
            a= temp%a;
        }
        return b;
    }
    public static void main(String[] args) {
        System.out.println(gdc_loop(120,100));
    }
}
