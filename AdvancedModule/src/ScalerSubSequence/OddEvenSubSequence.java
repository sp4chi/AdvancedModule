package ScalerSubSequence;

public class OddEvenSubSequence {
    public static int oddEvenSubSequence(int[] A) {
        int N = A.length;
        if(N == 0) return 0;
        int cnt = 0;
        boolean toggle = true;

        //if first element is even
        if(A[0] % 2 == 0){
            for (int j : A) {
                if (toggle && j % 2 == 0) {
                    cnt++;
                    toggle = !toggle;
                } else if (!toggle && !(j % 2 == 0)) {
                    cnt++;
                    toggle = !toggle;
                }
            }
        }else{ //if first element is odd
            toggle = !toggle;
            for (int j : A) {
                if (toggle && j % 2 == 0) {
                    cnt++;
                    toggle = !toggle;
                } else if (!toggle && !(j % 2 == 0)) {
                    cnt++;
                    toggle = !toggle;
                }
            }
        }


        return cnt;
    }
    //scaler solution using bit manipulation
    public static int solve(int[] A) {
        int n=A.length;
        int ans1=0,ans2=0;
        int x=1,y=0;
        for(int i = 0; i < n; i++){
            int it = A[i];
            it=(it&1); //masking to find the least significant bit, if set(1) then odd, if unset(0) then even
            if(it==x){ //checking for odd
                ++ans1;
                x^=1;   //toggling 1^1 = 0, 0^1 = 1
            }
            if(it==y){ //checking for even
                y^=1;
                ++ans2; //toggling 1^1 = 0, 0^1 = 1
            }
        }
        return Math.max(ans1,ans2);
    }
    public static void main(String[] args) {
        int[] A = { 2,2,3,3,9,2,4,5,2,2,6,7};
        System.out.println(oddEvenSubSequence(A));
        System.out.println(solve(A));
    }
}
