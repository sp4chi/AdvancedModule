package Hashing;

import java.util.HashSet;

public class SubStringOfUniqueCharacters {
    //Given a string of length N, find the largest substring of unique characters, i.e, return length of the largest substring.
    //Brute Force Approach
    public static int largestSubstringBrute(String S) {
        int N = S.length();
        int max = 0;
        //int start = 0;
        for (int i = 0; i < N-1; i++) {
            char temp = S.charAt(i);
            int len = 1;
            for (int j = i+1; j < N; j++) {
                char currentChar = S.charAt(j);
                String subString = S.substring(j,N);
                if (!(temp == currentChar) ) {
                    len++;
                    if(checkLetterFrequency(j,subString,currentChar,N)){
                        j=N;
                        len = subString.lastIndexOf(currentChar)+i+1;
                    }
                }
                max=Math.max(max,len);
            }
        }
        return max;
    }
    public static boolean checkLetterFrequency(int currIndex,String subString,char target, int N){
        int cnt=0;
        for(int i=0;i<N-currIndex;i++){
            if(target == subString.charAt(i)){
                cnt++;
            }
        }
        return cnt > 1;
    }


    //Efficient Approach
    public static int largestSubStringHashing(String S) {
        int N = S.length();
        int max = 0;
        int i = 0;
        int j = 0;
        HashSet<Character> set = new HashSet<>();
        while(j<N) {
            char temp=S.charAt(j);
            if (!set.contains(temp)){
                set.add(temp);
                max=Math.max(max, set.size());
                j++;
            }else {
                while(set.contains(temp)){
                    char dupliate=S.charAt(i);
                    set.remove(dupliate);
                    i++;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String S = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaamngtabcdet";//"tabcdeft";
        System.out.println(largestSubStringHashing(S));
    }
}
