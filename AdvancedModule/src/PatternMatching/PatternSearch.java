package PatternMatching;

public class PatternSearch {
    //Brute Force
    //time - O(N^3)
    //space - O(N)
    //chrome-extension://efaidnbmnnnibpcajpcglclefindmkaj/https://scaler-production-new.s3.ap-southeast-1.amazonaws.com/attachments/attachments/000/025/589/original/pattern_matching_1.pdf?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAIDNNIRGHAQUQRWYA%2F20230415%2Fap-southeast-1%2Fs3%2Faws4_request&X-Amz-Date=20230415T140807Z&X-Amz-Expires=86400&X-Amz-SignedHeaders=host&X-Amz-Signature=e9ae35ed272ae766c5e644708f5cc1127606c22074d2f7c262a9f67e71768ceb
    public static int[] LPSArray(String S, String target) {
        String P = target + "$" + S;
        StringBuilder sb = new StringBuilder(P);
        int N = P.length();
        int[] LPS = new int[N];
        int lenOfSalt = 1;
        int lenOfTarget = target.length();
        int len =lenOfTarget + lenOfTarget + lenOfSalt;
        int cnt = 0;
        int startIndex = 0;
        LPS[0] = 0;
        for (int i = 1; i < N ; i++) {
            StringBuilder temp = new StringBuilder(sb.substring(0, i+1 ));
            LPS[i] = getLPS(temp);
            if (LPS[i] == lenOfTarget) {
                cnt++;
                startIndex = i - len + 1;
            }
        }
        return new int[]{cnt, startIndex};
    }

    public static int getLPS(StringBuilder S) {
        int N = S.length();
        int len = 0;
        for (int i = 0; i < N - 1; i++) {
            StringBuilder prefixString = new StringBuilder(getPrefixString(S, i));
            StringBuilder suffixString = new StringBuilder(getSuffixString(S.reverse(), i));
            if (prefixString.toString().equals(suffixString.toString())) {
                len = Math.max(len, prefixString.length());
            }
        }
        return len;
    }

    public static StringBuilder getPrefixString(StringBuilder S, int currentIdx) {
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i <= currentIdx; i++) {
            char s = S.charAt(i);
            temp.append(s);
        }
        return temp;
    }

    public static StringBuilder getSuffixString(StringBuilder S, int currentIdx) {
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i <= currentIdx; i++) {
            char s = S.charAt(i);
            temp.append(s);
        }
        return temp.reverse();
    }


    //Efficient Approach- Knuth-Morris-Pratt
    //time - O(N)
    public static int[] LPSArrayEfficient(String S){
        int N = S.length();
        int[] LPS = new int[N];
        LPS[0] = 0;
        //building lps array
        for(int i=1;i<N;i++){
            int x = LPS[i-1];
            while(S.charAt(i)!=S.charAt(x) ){
                if(x == 0) {
                    x = -1;
                    break;
                }
                x = LPS[x-1];
            }
            LPS[i] = x + 1;
        }
        return LPS;
    }
    public static int countingOccurence(String text, String pattern){
        String S = pattern+"$"+text;
        int[] LPS = LPSArrayEfficient(S);
        int N = S.length();
        int cnt  = 0;
        for(int i=0;i<N;i++){
            if(LPS[i] == pattern.length()){
                cnt++;
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        String text = "aabacdabac";
        String pattern = "abac";
        /*int[] ans = LPSArray(S, target);

        System.out.println("pattern :"+pattern + ", occurs " + ans[0] + " times" + " and last occurrence is at index " + ans[1]);*/
        System.out.println("pattern "+ pattern+" occured "+countingOccurence(text,pattern)+ " times.");

    }
}
