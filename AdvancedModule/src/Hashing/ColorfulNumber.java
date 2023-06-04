package Hashing;

import java.util.ArrayList;
import java.util.HashSet;

public class ColorfulNumber {
    public static int colorful(int A) {
        ArrayList<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        while(A>0)
        {
            list.add(A % 10);
            A = A / 10;
        }
        int N = list.size();
        for(int i=0; i<N; i++)
        {
            int prod = 1;
            for(int j=i; j<N; j++)
            {
                prod = prod * list.get(j);
                if(set.contains(prod))
                {
                    return 0;
                }
                set.add(prod);
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(colorful(236));
    }
}
