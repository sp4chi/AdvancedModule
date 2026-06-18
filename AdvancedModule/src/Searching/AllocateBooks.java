package Searching;

public class AllocateBooks {
    public static boolean canAllocate(int mid, int[] pages,int students){
        int N = pages.length;
        int studentCnt = 1;
        int pagesAssigned = 0;
        for(int page : pages){
            pagesAssigned += page;
            if(pagesAssigned > mid){
                studentCnt++;
                if(studentCnt > students) return false;
                pagesAssigned = page;
            }
        }

        return true;
    }
    public static int books(int[] A, int B) {
        int N = A.length;

        if(B > N) return -1;

        // lower bound logic - if 4 students are there and 4 books are there then someone
        // is assigned the max value of this array(...pt 2), if students are less then no.
        // of books then min value is >= max(arr).

        int low = Integer.MIN_VALUE ;
        for(int i : A){
            low = Math.max(low,i);
        }

        // upper bound logic -  if only 1 student is there and 4 books then he is assigned
        // all the books and if 2 students are there then they are assigned values < sum(arr)

        int high = 0;
        for(int i : A){
            high += i;
        }

        // the optimal value - (max of min pages) lies in between low and high.
        // strategy - binary search on the value and check if a mid is Valid
        // what is mid? mid is the max no. of pages we can allocate to a student
        // - if yes store the value and go left(...because we want to minimize the value)
        // - no go right
        // the model is FFFFTTTTT, we want to find the first mid value that is true.
        // Valid ? Greedy approach - keep allocating pages until <= mid, go to next student
        // allocate rest of the pages, repeat. Now check if total students <= B.
        // if yes then valid, store value go left
        // no then not valid go right
        int ans = high;
        while(low <= high){
            int mid = (high - low)/2 + low;

            if(canAllocate(mid,A,B)){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] A = {10,20,30,40};
        int B = 2;
        System.out.println(books(A,B));
    }
}



