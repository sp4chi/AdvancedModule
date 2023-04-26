package LinkedListScaler;

public class MergeSortLL {
    static Node mergeSort(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node a = head;
        Node b = getMid(head).next;
        getMid(head).next = null;
        a = mergeSort(a);
        b = mergeSort(b);
        return merge(a,b);
    }
    static Node merge(Node a, Node b){
        if(a == null){
            return b;
        }
        if(b == null){
            return a;
        }
        Node head ;
        if(a.data<=b.data){
            head=a;
            head.next = merge(a.next,b);
        }else{
            head = b;
            head.next = merge(a,b.next);
        }
        return head;
    }
    static Node getMid(Node head) {
        if (head.next == null) return head;
        Node fast = head, slow = head ,lastslow=head;
        while (fast != null && fast.next != null) {
            lastslow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return lastslow;
    }

    public static void main(String[] args) {
        Node a = new Node() ;
        a.add(11);
        a.add(22);
        a.add(33);
        a.add(55);
        a.add(55);
        a.add(11);
        a.add(-1);
        a.add(9000);
        a.add(88);
        a.print(a.head);
        a.print(mergeSort(a.head));
    }
}
