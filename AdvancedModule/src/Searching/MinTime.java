package Searching;

public class MinTime {
    public static int minTime(int[] tasks, int workers){
        int ans = 0;
        int start=-1;
        int end=0;
        for (int task : tasks) {
            start = Math.max(start, task);
            end += task;
        }
        while(start<=end){
            int mid = start + (end-start)/2;
            if(validConfig(tasks,mid,workers)){
                ans = mid ;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
    public static boolean validConfig(int[] tasks, int mid, int workers){
        int worker=0;
        int countOfWorkers=1;
        for (int task : tasks) {

            if (worker + task <= mid) {
                worker += task;
            } else {
                worker = task;
                countOfWorkers++;
                if (countOfWorkers > workers)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] tasks={3,5,7,6,10,2,4};
        System.out.println(minTime(tasks,3));
    }
}
