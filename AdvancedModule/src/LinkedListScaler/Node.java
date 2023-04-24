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

    //return head
    Node getHead() {
        return head;
    }

    //set head
    Node setHead(Node head) {
        Node.head = head;
        return Node.head;
    }

    //insert at front of LL, time = O(1)
    void add(int data) {
        Node n = new Node(data);
        n.next = head;
        head = n;
    }

    //insert at the end, time = O(n)
    void append(int data) {
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
    void put(int k, int data) {

        if (k > length) {
            System.out.println("Invalid position");
            return;
        }
        if (k == 0) {
            Node n = new Node(data);
            n.next = head;
            head = n;
            return;
        }
        if (head == null) {
            Node n = new Node(data);
            head = n;
            n.next = null;
            return;
        }
        Node temp = head;
        int cnt = 1;
        while (cnt < k - 1) {
            cnt++;
            temp = temp.next;
        }
        Node n = new Node(data);
        n.next = temp.next;
        temp.next = n;
    }

    //printing the LL
    void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.print("Null");
    }

    void delete(int position) {
        Node slow = head;
        if (position > length) {
            System.out.println();
            System.out.print("invalid position");
            return;
        }
        if (head.next == null) {
            head = null;
            length--;
            return;
        }
        Node fast = head.next;
        int cnt = 1;

        while (slow.next != null && cnt < position - 1) {
            cnt++;
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = fast.next;
        fast.next = null;
        length--;
    }

    void reverse() {
        Node slow = null;
        Node fast = head;
        Node temp;
        while (fast.next != null) {
            temp = fast.next;
            fast.next = slow;
            slow = fast;
            fast = temp;
        }
        fast.next = slow;
        head = fast;
    }

    void deleteMid() {
        if (head.next == null) return;
        Node fast = head, slow = head, lastslow = head;
        while (fast != null && fast.next != null) {
            lastslow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        lastslow.next = lastslow.next.next;
        length--;
    }

    static int length(Node head) {
        Node temp = head;
        int cnt = 0;
        while (temp != null) {
            cnt++;
            temp = temp.next;
        }
        return cnt;
    }
}
