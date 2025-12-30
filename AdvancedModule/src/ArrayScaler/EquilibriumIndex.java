package ArrayScaler;
/**
 * Equilibrium Index or Pivot Index-
 * Index i where - sum of left side elements = sum of right side elements
 * Example:
 * A = [-7, 1, 5, 2, -4, 3, 0]
 * Equilibrium indices: 3, 6
 */
public class EquilibriumIndex {
    public static void main(String[] args) {
        int []arr = {-7,1,5,2,-4,3,0};
        int []prefixArr = new int[arr.length];

        prefixArr[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            prefixArr[i] = prefixArr[i-1] + arr[i];
        }

        for(int i = 0; i < arr.length; i++){
            int leftSum = i == 0 ? 0 : prefixArr[i-1];
            int rightSum = prefixArr[prefixArr.length - 1] - prefixArr[i];
            if(leftSum == rightSum) {
                System.out.println(i);
            }
        }

    }
}
