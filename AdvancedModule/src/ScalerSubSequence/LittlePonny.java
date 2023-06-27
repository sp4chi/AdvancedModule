package ScalerSubSequence;

public class LittlePonny {
    public static void minSubsequence(String A) {
        int N = A.length();
        int min = Integer.MAX_VALUE;
        int firstIdx = 0;
        for(int i=0;i<N-1;i++){
            int idx = A.charAt(i);
            if(min>idx){
                firstIdx = i;
                min = idx;
            }
        }
        min = Integer.MAX_VALUE;
        int secondIdx = 0;
        for(int i=firstIdx+1;i<N;i++){
            int idx = A.charAt(i);
            if(i == firstIdx) continue;
            if(min>=idx){
                secondIdx = i;
                min = idx;
            }
        }
        String S = ""+A.charAt(firstIdx)+A.charAt(secondIdx) ;
        System.out.println(S);
    }

    public static void main(String[] args) {
        //String A = "bcdsfhajgj";
        String A = "epujxwjiad";
        minSubsequence(A);
    }
}
