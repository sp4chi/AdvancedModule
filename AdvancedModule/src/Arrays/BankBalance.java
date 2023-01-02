package Arrays;

import java.util.Arrays;
//https://codereview.stackexchange.com/questions/277212/figure-out-initial-balance-for-bank-accounts-to-avoid-them-going-into-negative-b
public class BankBalance {
    public static int[] solution(String recipients, int[] amounts) {
        int minA = 0;
        int minB = 0;

        int balA = 0;
        int balB = 0;

        for (int i = 0; i < recipients.length(); i++) {
            if (recipients.charAt(i) == 'A') {
                balA += amounts[i];
                balB -= amounts[i];
                if (balB < minB) {
                    minB = balB;
                }
            } else if (recipients.charAt(i) == 'B') {
                balB += amounts[i];
                balA -= amounts[i];
                if (balA < minA) {
                    minA = balA;
                }
            }
        }

        return new int[] { -minA, -minB };
    }

    public static void main(String[] args) {
        String R="ABAB";
        int[] V={10,5,10,15};
        int[] res=solution(R,V);
        System.out.println(Arrays.toString(res));
    }
}
