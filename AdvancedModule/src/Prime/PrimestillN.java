package Prime;


//1 is false, 0 is true ---Assume
public class PrimestillN {
    public static void primetillN(int N){
        int[] prime=new int[N+1];

        prime[0]=1;
        prime[1]=1;
        for(int i=2;i*i<=N;i++){
            if(prime[i]==0){
                for(int j=i*i;j<=N;j=j+i)
                    prime[j]=1;
            }
        }
        for(int i=2;i<=N;i++){
            if(prime[i]==0)
                System.out.print(i+" ");
        }
    }

    public static void main(String[] args) {
        primetillN(100);
    }
}
//Tc--O(N*log(log N))
//Sc--O(N+1);
