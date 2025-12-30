package ArrayScaler;
/**
* prefix-sum can also be used to calculate prefix-xor,
* which can be used to find the xor of values in the index range L to R.
*/
public class XorPrefixSum {
    static int prefixXorSum(int[] xor, int l, int r) {
        int N = xor.length;
        int []prefixSum = new int[N];

        //l = 1, r = 3 (index)
        prefixSum[0] = xor[0];

        for(int i=1;i<N;i++) {
            prefixSum[i] = xor[i] ^ prefixSum[i - 1];
        }

        return prefixSum[r] -  prefixSum[l-1];
    }
    public static void main(String[] args) {
        int []xor = {5,1,3,2};
        System.out.println(prefixXorSum(xor,1,3));

    }
}
