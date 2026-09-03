package Miscellaneous;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


class Heroes implements Comparable<Heroes> {
    int age;
    String name;

    Heroes(String name, int age) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Duelist{" +
                "name=" + name +
                ", age='" + age + '\'' +
                '}';
    }

    @Override
    public int compareTo(Heroes that) {
        return Integer.compare(this.age, that.age);
    }
}

public class ComparatorDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i : new int[]{100, 3, 50, 17, 79}) {
            list.add(i);
        }

        /**
         * sort based on last digit
         */
        Comparator<Integer> com = Comparator.comparingInt((Integer i) -> i % 10);

        Collections.sort(list, com);


        /**
         * sort based on length of string
         */
        List<String> s = new ArrayList<>();
        Collections.addAll(s, "hello", "wonder", "cat", "ok", "sova", "jett");
        Comparator<String> strCom = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(),o2.length());
            }
        };

        Collections.sort(s, ( o1, o2)-> {
            return Integer.compare(o1.length(),o2.length());
        });

        /**
         * sort based on age
         */
        List<Heroes> myDuelist = new ArrayList<>();

        Collections.addAll(myDuelist, new Heroes("Phoenix", 10),
                new Heroes("Reyna", 20),
                new Heroes("Jett", 18),
                new Heroes("Yoru", 12));
        Comparator<Heroes> duelistCom = new Comparator<Heroes>() {
            @Override
            public int compare(Heroes o1, Heroes o2) {
                return o1.age > o2.age ? 1 : -1;
            }
        };

        Collections.sort(myDuelist, duelistCom);

        System.out.println("Sorting based on last digit: "+list);
        System.out.println("Sorting based on string length: "+s);
        System.out.println("Sorting based on age of duelist: "+myDuelist);
        ArrayList<Heroes> myControllers = new ArrayList<>(
                List.of(
                        new Heroes("Brimstone", 57),
                        new Heroes("Omen", 45),
                        new Heroes("Astra", 35),
                        new Heroes("Harbor", 39)
                )
        );
        Collections.sort(myControllers);
        System.out.println("Sorting based on age of controllers: "+myControllers);

    }
}
