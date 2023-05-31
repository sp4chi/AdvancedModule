package ArrayScaler;

import java.util.ArrayList;
import java.util.List;

public class BirthdayChocolate {
    public static int birthday(List<Integer> s, int d, int m) {
        // Write your code here
        int N = s.size();
        int cnt = 0;


        for(int i=0;i<N+1-m;i++){
            int sum = 0;
            for(int j=i;j<i+m;j++){
                sum += s.get(j);
            }
            if(sum == d) cnt++;
        }

        return cnt;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(4);
        System.out.println(birthday(list,4,1));
    }


}
