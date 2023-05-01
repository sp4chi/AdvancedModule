package LinkedListScaler;

public class MergeLL {
    public static Node merge(Node a, Node b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        Node head;
        if (a.data <= b.data) {
            head = a;
            head.next = merge(a.next, b);
        } else {
            head = b;
            head.next = merge(a, b.next);
        }
        return head;
    }

    public static void main(String[] args) {
        Node a = new Node();
        a.add(33);
        a.add(22);
        a.add(11);

        Node b = new Node();
        b.add(77);
        b.add(26);
        b.add(17);
        b.add(5);

        Node temp = merge(a.getHead(), b.getHead());
        a.print(temp);

    }
}
