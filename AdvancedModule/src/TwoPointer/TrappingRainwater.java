package TwoPointer;

public class TrappingRainwater {
    public static int trap(int[] height) {
        int N = height.length;

        int l = 0;
        int r = N - 1;

        int area = 0;
        int maxSoFarLeft = height[l];
        int maxSoFarRight = height[r];
        while (l < r) {
            if (maxSoFarLeft <= maxSoFarRight) {
                if (maxSoFarLeft < height[l]) {
                    maxSoFarLeft = height[l];
                } else {
                    area += maxSoFarLeft - height[l];
                    l++;
                }

            } else {
                if (maxSoFarRight < height[r]) {
                    maxSoFarRight = height[r];
                } else {
                    area += maxSoFarRight - height[r];
                    r--;
                }

            }
        }

        return area;
    }

    public static void main(String[] args) {
        int[] A = {5,5,1,7,1,1,5,2,7,6};
        System.out.println(trap(A));
    }
}
