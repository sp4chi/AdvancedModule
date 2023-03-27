package UniqueOccurence;

//form: 3k+1
public class UniqueOccurrence {
    public static int UO(int[] A){
        int[] sum=new int[32];
        for(int x: A){
            int pos=0;
            while(x>0){
                int lastBit=x&1;
                sum[pos]+=lastBit;
                pos++;
                x=x>>1;
            }
        }
        int power=1;
        int ans=0;
        for(int i=0;i<32;i++){
            sum[i]=sum[i]%3;
            ans=ans+sum[i]*power;
            power=power<<1;
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] A={4,4,4,6,5,6,6};
        System.out.println(UO(A));

    }

}
