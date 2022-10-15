package Combinatorics;

//Given a word "VIEW" find its rank , in all the permutations of this word
//solution using recursion: Rank(len(string)) = (cnt of alphabets less than current alphabet)*(N-1)! + Rank(len(string)-1)
public class Rank {
    //factorial function
    public static int factorial(int N){
        if(N==1)
            return 1;
        return (N*factorial(N-1))%1000003;
    }
    //Rank Function
    public static int Rank(String A){


        int N=A.length();
        int rank=1;
        for(int i=0;i<N-1;i++){
            int cnt=0;
            for(int j=i+1;j<N;j++){
                if(A.charAt(i)>A.charAt(j))
                    cnt++;
            }
            rank= (rank%1000003 +(cnt*factorial(N-i-1))%1000003)%1000003;

        }
        return rank;
    }

    public static void main(String[] args) {
        String A="view";
        System.out.println(Rank(A));
    }

}
