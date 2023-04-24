package LinkedListScaler;

public class LinkedList {
    public static void main(String[] args) {
        Node n = new Node();
        n.put(0,999);
        for (int i = 1; i <= 10; i++) {
            n.add(i * i);
        }
        n.append(99);
        //n.print();
        System.out.println();
        n.put(5,666);
        n.print(n.getHead());
        //n.delete(5);
        n.deleteMid();
        System.out.println();
        n.print(n.getHead());
        int N = Node.length;
        System.out.println();
//        System.out.print("Deleting all the nodes from the end!! And printing is N^2 algorithm...");
//        for(int i=N;i>=1;i--){
//            System.out.println();
//            n.delete(i);
//            n.print(Node.getHead());
//            System.out.print("  length is "+n.length);
//        }
        n.reverse();
//        System.out.println("Reversing the list.. ");
//        //n.print();
//        System.out.println();
        System.out.println("Length is "+ Node.length);
    }
}




