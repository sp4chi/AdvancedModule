package ArrayScaler;

public class PickFromBothSides {
    public static int solve(int[] A, int B) {
        // greedy strategy -  compare left and right, pick highest, move that higher
        // pointer -- will fail for output - [1,100,4,5] , B = 2
        // realized that selecting a value(peeling) might reveal a value much larger or
        // much smaller, peeling should be done carefully
        // What if we keep adding values from a side till B elements, do same for other side,
        // compare them and store max, than use the greedy approach and compare greedy's
        // solution with previously stored max - will fail, we are still not checking all
        // possible sets
        // final solution - add B elements from one side, store it, from the ans keep removing
        // 1 element from that side and add element from other side, check for max in each pass
        // TC - O(B)
        int N = A.length;
        int max = 0;
        int sum = 0;
        for(int i=0;i<B;i++){
            sum += A[i];
        }

        max = sum;

        for(int i=B-1;i>=0;i--){
            sum = sum + A[N-B+i] - A[i];
            max = Math.max(max,sum);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] A = {
                -533, -666, -500, 169, 724, 478, 358, -38, -536, 705, -855, 281, -173,
                961, -509, -5, 942, -173, 436, -609, -396, 902, -847, -708, -618, 421,
                -284, 718, 895, 447, 726, -229, 538, 869, 912, 667, -701, 35, 894, -297,
                811, 322, -667, 673, -336, 141, 711, -747, -132, 547, 644, -338, -243,
                -963, -141, -277, 741, 529, -222, -684, 35 };
        int B = 48;
        System.out.println(solve(A,B)); //ans = 6253

    }
}





