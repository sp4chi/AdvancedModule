package BitManipulation;

public class AddBinaryString {
    public static String addBinary(String A, String B) {
        StringBuilder sb=new StringBuilder();
        int i=A.length()-1;
        int j=B.length()-1;
        int carry=0;
        while(i>=0 || j>=0){
            int sum=carry;
            if(i>=0)
                sum=sum+A.charAt(i)-'0';
            if(j>=0)
                sum=sum+B.charAt(j)-'0';

            sb.append(sum%2);
            carry=sum/2;

            i--;
            j--;
        }
        if(carry>0)
            sb.append(carry);

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String A="101";
        String B="111";
        System.out.println(addBinary(A,B));
    }
}
