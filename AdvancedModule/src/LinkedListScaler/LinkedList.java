package LinkedListScaler;

public class LinkedList {
    public static void main(String[] args) {
        Node n = new Node();
        n.put(0,999);
        for (int i = 1; i <= 10; i++) {
            n.add(i * i);
        }
        n.append(99);
        n.print();
        System.out.println();
        n.put(5,666);
        n.print();
        System.out.println();
        System.out.println("Length is "+n.length);
    }
}




