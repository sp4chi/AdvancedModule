package CountBits;

public class CountBits {
    public static int solve(int a){
        int bits=0;
        for(int i=1;i<=a;i++){
            bits=bits+CB(i);
        }
        return bits;
    }
    public static int CB(int a){
        int cnt=0;
        while (a>0){
            int lastbit=a&1;
            if(lastbit==1)
                cnt++;
            a=a>>1;
        }
        return cnt;
    }
    //TC: O(nlogn)


    public static void main(String[] args) {
        System.out.println(solve(4));
    }
}
