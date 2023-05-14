package ScalerStrings;

public class CountOccurence {
    //count ouccurences of "bob" in given String
    public static int occurence(String A){
        int N = A.length();
        int cnt = 0;
        int i = 0 ;
        while(i<N){
            if(A.contains("bob")){
                cnt++;
                int left = A.indexOf("bob");
                int right = left+1;
                A = A.substring(right);
            }else{
                i++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        String A = "bobob";
        System.out.println(occurence(A));
    }
}
