package Recursion;

public class IndianMoneyChange {
    public static int change1(int[] money,int note){
        if(note == 0)
            return 0;
        System.out.println();
        return (1+change1( money, note - money[ search(money, note)-1]));
    }

    public static int change2(int[] money,int note){
        if(note ==0) {
            System.out.print("total changes: ");
            return 0;
        }
        int index=search(money,note)-1;
        System.out.println("denomiations: "+money[index] +" number: "+ note/money[index]);
        return note/money[index] + change2(money,note % money[index]);
    }

    public static int search(int[] money, int target) {
        int i = 0;
        for (; i < money.length;i++){
            if(target < money[i])
                break;
        }
        return i;
    }

    public static void main(String[] args) {
        int[] money={1,2,5,10,20,50,100,200,500,1000,2000};

        System.out.println(change2(money,476));
    }
    //time complexity:worst case--> O(len(money array))= O(1)
    //space complexity: O(1)
}
