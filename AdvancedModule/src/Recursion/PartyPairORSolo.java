package Recursion;
//going to a party, each individual can decide to go in pair or solo, find the no of ways they can go to the party given N.
public class PartyPairORSolo {
    public static int totalWays(int N){
        if(N == 1)
            return 1;
        if(N == 2)
            return 2;
        return totalWays(N-1) + (N-1)*totalWays(N-2);
    }

    public static void main(String[] args) {
        System.out.println(totalWays(4) );
    }
}
