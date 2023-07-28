package ArrayScaler;

import java.util.*;

class Interval{
    int startTime;
    int endTime;

    Interval(int startTime,int endTime){
        this.startTime = startTime;
        this.endTime = endTime;
    }
    int getStartTime(){
        return startTime;
    }
}
public class MergeIntervals {
    public static ArrayList<Interval> mergeIntervals(ArrayList<Interval> A){
        int N = A.size();

        A.sort(Comparator.comparing(Interval::getStartTime));

        ArrayList<Interval> list = new ArrayList<>();

        list.add(A.get(0));

        int j=0;

        for(int i=1;i<N;i++){
            if(A.get(i).startTime <= list.get(j).endTime){
                list.get(j).endTime = Math.max(A.get(i).endTime,list.get(j).endTime);
            }else{
                list.add(A.get(i));
                j++;
            }
        }

        return list;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of Interval list: ");
        int N = sc.nextInt();
        ArrayList<Interval> A = new ArrayList<>(N);
        System.out.println("Enter intervals: ");
        for(int i=0;i<N;i++){

            int start = sc.nextInt();
            int end = sc.nextInt();
            A.add(i, new Interval(start, end));
        }
        ArrayList<Interval> B = mergeIntervals(A);
        System.out.println("Merged intervals are: ");
        for(Interval i: B){
            System.out.println(i.startTime+ " "+i.endTime);
        }

    }
}
