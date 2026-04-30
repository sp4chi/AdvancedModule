package Queues;

import java.util.*;

public class FirstNonRepeatingCharacter {
    public static String solve(String A) {
        char[] input = A.toCharArray();

        StringBuilder out = new StringBuilder();

        HashMap<Character,Integer> map = new HashMap<>(); //for maintaining freq
        Queue<Character> queue = new LinkedList<>(); // for maintaining order

        for(char i : input){
            if(!map.containsKey(i)){
                // // new character → potential non-repeating candidate, add to queue
                queue.add(i);
                map.put(i,1);
            }else{
                map.put(i, map.get(i) + 1);
            }

            // lazily remove invalid candidates (freq > 1) from front
            // async invalidation ^_^
            while(!queue.isEmpty() && map.get(queue.peek()) > 1){
                queue.poll();
            }

            // front of queue is the first non-repeating character
            if(queue.isEmpty()){
                out.append("#");
            }else{
                out.append(queue.peek());
            }

        }

        return out.toString();
    }

    public static void main(String[] args) {
        String A = "gu"; //out -> "gg"
        // String A = "jyhrcwuengcbnuchctluxjgtxqtfvrebveewgasluuwooupcyxwgl"
        // String A = "xxikrwmjvsvckfrqxnibkcasompsuyuogauacjrr"
        System.out.println(solve(A));
    }
}



