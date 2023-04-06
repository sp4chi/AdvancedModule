package Hashing;

import java.util.HashMap;

public class ValidAnagrams {
    /*Given two strings s and t, return true if t is an anagram of s, and false otherwise.
    An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.*/
    public static boolean validAnagrams(String S, String T){
        int K = S.length(); //size of first String
        int M = T.length(); //size of second String
        if(K!=M){
            return false;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<K;i++){
            if(map.containsKey(S.charAt(i))){
                map.put(S.charAt(i), map.get(S.charAt(i))+1);
            }else{
                map.put(S.charAt(i),1) ;
            }
        }
        for(int i=0;i<K;i++){
            map.put(T.charAt(i),map.get(T.charAt(i))-1);
            if(map.get(T.charAt(i)) == 0){
                map.remove(T.charAt(i));
            }
        }
        if(map.size() == 0){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String S = "aabbccdd";
        String T = "abcddcba";
        System.out.println(S + " and " + T + " are valid anagrams? " +validAnagrams(S,T));
    }
}
