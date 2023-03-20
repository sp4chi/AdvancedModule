package ArrayScaler;

//Along one side of a road there is a sequence of vacant plots of land. Each plot has a different area (non-zero).
// So, the areas form a sequence A[1], A[2], … A[N]. You want to buy K acres of land to build a house.
// You want to find a segment of contiguous plots (i.e., a subsection in the sequence) of minimum length whose sum is exactly K.
//A=[1,2,3,4]
//pf=[1,3,6,10]
public class ContinuousPlot {
//    public static int[] prefixSum(int[] A){
//        int N=A.length;
//        int[] pf=new int[N];
//        pf[0]=A[0];
//        for(int i=1;i<N;i++){
//            pf[i]=pf[i-1]+A[i];
//        }
//        return pf;
//    }
//    public static int prefixSumAndBinarySearch(int[] A,int k){
//        int minlength=Integer.MAX_VALUE;
//        int N=A.length;
//        int[] pf=prefixSum(A);
//        for (int i=0;i<N;i++){
//            int index = Arrays.binarySearch(pf,k-pf[i]);
//            minlength=Math.min(minlength,index-i+1);
//        }
//        return minlength;
//    }
//    public static int twoSum(int[] A,int k){
//        int N=A.length;
//        HashSet<Integer> hs=new HashSet<>();
//        int[] pf=prefixSum(A);
//        for(int i=0;i<N;i++){
//           int target=Math.abs(k-pf[i]);
//           if(!hs.contains(target)){
//               hs.add(target);
//           } else {
//               System.out.println();
//               return i;
//           }
//        }
//        return ;
//    }
    public static int slidingWindow(int[] A,int k){
        int N=A.length; int i=0; int j=0;  int minLength=N+1;  int sum=A[0];
        while(j<N && j-i>=0){
            if(sum<k){
                sum+=A[j];
                j++;
            } else if (sum>k) {
                sum -= A[i];
                i++;
            } else {
                //the case where sum == k
                sum=0;
                minLength=Math.min(minLength,j-i+1);
                i=j;
            }
        }
        return minLength;
    }

    public static void main(String[] args) {
        //pf=[3,8,10,17,21,26,27,33]
        int[] A={3,5,2,7,4,5,1,6};
        int k=9;
        int ans=slidingWindow(A,k);
        System.out.println(ans);
    }
}
