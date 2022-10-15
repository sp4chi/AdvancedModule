package GCD;
//given an array,find if there is a subsequence with gcd 1.
public class SubSequenceWithGCDone {
    public static int gcd(int a, int b){
        if(a== 0)
            return b;
        return gcd(b%a,a);
    }
    public static String main(int[] A){
        int n=A.length;
        int ans=A[0];
        for(int i=1;i<n;i++){
            ans=gcd(ans,A[i]);
            if(ans==1)
                break;
        }
        if(ans==1) return "yes";
        else return "no";

    }
    public static void main(String[] args) {
        int[] A={1,33,333,3333};
        System.out.println(main(A));
    }
}
