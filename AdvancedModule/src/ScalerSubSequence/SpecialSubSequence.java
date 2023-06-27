package ScalerSubSequence;

public class SpecialSubSequence {
    public static int solve(String A) {
        int n = A.length(), ans = 0, MOD = 1000*1000*1000 + 7;
        int[] cnt_G = new int[n];
        int count = 0;

        //Suffix count of G
        for(int i = n - 1 ; i >= 0 ; i--){
            if(A.charAt(i) == 'G')
                count++;
            cnt_G[i] = count;
        }

        // traverse the string again from beginning
        for(int i = 0; i < n; i++){
            // if current character is "A" then add number of G's after that
            if(A.charAt(i) == 'A') {
                ans = ans + cnt_G[i];
                ans = ans % MOD;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String A = "ABCGAG";
        System.out.println(solve(A));
    }
}
