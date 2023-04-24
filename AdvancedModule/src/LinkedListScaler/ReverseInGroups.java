package LinkedListScaler;

public class ReverseInGroups {
    //function to Reverse a LL in groups of size K
    public static Node reverseInGroups(Node head, int k){
        int N=Node.length(head);
        if(N<k){
            return head;
        }
        Node slow = null;
        Node fast = head;
        if(head == null){
            return null;
        }
        Node temp ;
        int cnt=0;
        while( cnt<k){
            temp = fast.next;
            fast.next = slow;
            slow = fast;
            fast = temp;
            cnt++;
        }

        head.next = reverseInGroups(fast,k);

        return slow;
    }

    public static void main(String[] args) {
        Node n = new Node();
        n.add(11);
        n.add(22);
        n.add(33);
        n.add(44);
        n.add(55);
        n.add(66);
        n.add(77);
        Node head = n.getHead();
        n.print(head);
        System.out.println();
        System.out.println("After reverse in groups of "+2);
        n.print(reverseInGroups(head,2));
        System.out.println();
        System.out.println("length is "+ Node.length(head));


    }
}
