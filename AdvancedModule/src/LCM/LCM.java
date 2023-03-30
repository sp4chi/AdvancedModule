package LCM;

public class LCM {
    public static int brute_lcm(int a, int b){
        int large=Math.max(a,b);
        int small=Math.min(a,b);
        int i=large;
        while(i%small!=0){
            i+=large;
        }
        return i;
    }


    public static int gcd(int a, int b){
        if(a == 0)
            return b;
        return gcd(b%a,a);
    }
    public static int lcm(int a, int b){

        return a*b/gcd(a,b);
    }

    public static void main(String[] args) {
        System.out.println(lcm(2,4));
    }
}
