package ScalerStrings;

public class LongestPalindromicSubstring {
    public static int expand(String s, int left, int right){
        int N = s.length();

        while(left>=0 && right<N && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }

        return (right-left-1);
    }
    public static String longestPalindromicSubstring(String s){
        int N = s.length();

        if(s == null || N == 0) return "";
        int len = 0;
        int start = 0;
        int end = 0;
        for(int i=0;i<N;i++){
            int odd = expand(s,i,i);
            int even = expand(s,i,i+1);

            len = Math.max(odd,even);

            if(len > end - start){
                start = i - (len-1)/2;
                end = i + len/2;
            }

        }

        return s.substring(start,end+1);
    }
    public static void main(String[] args) {
        String s = "abcxghhgxcbdeajaei";
        System.out.println(longestPalindromicSubstring(s));
    }
}
