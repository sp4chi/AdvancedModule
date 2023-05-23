package ScalerStrings;

public class AmazingSubString {
    //You are given a string S, and you have to find all the amazing substrings of S.
    //An amazing Substring is one that starts with a vowel (a, e, i, o, u, A, E, I, O, U).
    public static int amazingStrings(String A){
        int N = A.length();
        int cnt = 0;
        for(int i=0;i<N;i++){
            char temp = Character.toLowerCase(A.charAt(i));
            if( temp == 'a' || temp == 'e' || temp == 'i' || temp == 'o' || temp == 'u'){
               cnt += N-i;
            }
        }
        return cnt;
    }


    public static void main(String[] args) {
        String A = "ABEC";
        System.out.println(amazingStrings(A));
    }
}
