package Hashing;

import java.util.HashMap;
import java.util.Map;

public class ReplicatingSubstring {
    /*Given a string B, find if it is possible to re-order the characters of the string B so that it can be represented as a concatenation of A similar strings.

    Eg: B = aabb and A = 2, then it is possible to re-arrange the string as "abab" which is a concatenation of 2 similar strings "ab".

    If it is possible, return 1, else return -1.*/
    public static int findingReplicatingStrings(String S, int A){
        int N = S.length();
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<N;i++){
            if(map.containsKey(S.charAt(i))){
                int value = map.get(S.charAt(i)) + 1;
                map.put(S.charAt(i),value);
            }else{
                map.put(S.charAt(i),1);
            }
        }

        for(Map.Entry<Character,Integer> set: map.entrySet()){
            if(map.get(set.getKey())%A !=0){
                return -1;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        String S = "aaaabbb";
        int A = 2;
        System.out.println(findingReplicatingStrings(S,A));
    }
}
