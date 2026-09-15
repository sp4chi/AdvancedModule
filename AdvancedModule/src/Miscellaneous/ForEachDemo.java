package Miscellaneous;

import java.util.Arrays;
import java.util.List;

public class ForEachDemo {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,5,77,3,18);

        /*Consumer<Integer> consumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        };*/

        list.forEach(n-> System.out.println(n));
    }
}
