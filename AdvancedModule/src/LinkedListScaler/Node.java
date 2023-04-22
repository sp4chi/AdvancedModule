package LinkedListScaler;

public class Node {
    static Node head = null;
    int data;
    static int length;

    Node next;

    Node(int data) {
        this.data = data;
        next = null;
        length++;
    }

    Node() {
        //empty constructor
    }

    //insert at front of LL, time = O(1)
    static void add(int data) {
        Node n = new Node(data);
        n.next = head;
        head = n;
    }

    //insert at the end, time = O(n)
    static void append(int data) {
        Node n = new Node(data);
        if (head == null) {
            head = n;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = n;
        n.next = null;
    }
    //insert at kth position, indexed at 0
    static void put(int k,int data){

        if(k> length){
            System.out.println("Invalid position");
            return ;
        }
        if(k == 0){
            Node n = new Node(data);
            n.next = head;
            head = n;
            return;
        }
        if(head == null){
            Node n = new Node(data);
            head = n;
            n.next = null;
            return;
        }
        Node temp = head;
        int cnt = 1;
        while(cnt<k-1){
            cnt++;
            temp = temp.next;
        }
        Node n = new Node(data);
        n.next = temp.next;
        temp.next = n;
    }
    //printing the LL
    static void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.print("Null");
    }
}
