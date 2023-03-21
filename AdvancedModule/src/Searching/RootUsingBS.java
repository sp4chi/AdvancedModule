package Searching;

public class RootUsingBS {
    //Given N, find square root of N upto k places after decimal.
    public static float decimalPart(int N ,int p){
        float ans= IntegerPart(N);
        float inc = 0.1f;

        while(p>0){
            while(ans*ans<=N){
                ans+=inc;
            }
            ans-=inc;
            inc/=10;
            p--;
        }
        return ans;
    }
    public static int IntegerPart(int N){
        int ans=0;
        int start = 0;
        int end = N;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(mid <= N/mid){
                start = (mid + 1);
                ans = mid;
            }else{
                end = mid - 1;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(IntegerPart(930675566));
    }
}
