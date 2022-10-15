package BitManipulation;

public class PowerFunction {
    public static int PF(int M, int N){
        int ans=1;

        while (N>0){
            int lastbit=N&1;
            if(lastbit==1)
                ans=ans*M;
            M=M*M;
            N=N>>1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(PF(7,4));
    }
}
