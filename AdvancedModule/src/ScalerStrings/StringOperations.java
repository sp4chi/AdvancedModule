package ScalerStrings;

public class StringOperations {
    public static String solve(String A) {
        StringBuilder sb = new StringBuilder(A);
        sb.append(sb);
        int N = sb.length();
        int i=0;
        while(i<N){
            int temp = sb.charAt(i);
            if(temp<'a' && temp>'#') {
                sb.deleteCharAt(i);
                N--;
            }else{
                i++;
            }
        }


        i=0;
        N = sb.length();
        while(i<N){
            char temp = sb.charAt(i);
            if(temp == 'a' || temp == 'e' || temp=='i' || temp=='o' || temp=='u'){
                sb.setCharAt(i,'#');
            }
            i++;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String A = "GrNvsMcsyQEiEfzikav";
        //String A = "hgUe";
        String B = solve(A);
        System.out.println(B);
        for(int i=0;i<B.length();i++){
            int temp = B.charAt(i);
            System.out.print(temp+" ");
        }
    }
}
