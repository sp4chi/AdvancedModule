package Prime;

public class Prime {
    public static boolean prime_root(int n){
        if( n<2)
            return false;
        for(int i=2;i*i<=n;i++){
            if(n%i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(prime_root(29));
    }
}
