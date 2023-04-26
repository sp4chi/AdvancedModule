package LinkedListScaler;

import java.util.HashSet;

public class DetectCycle {
    static Node findIntersection(Node head){
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){

            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                slow = head;
                Node prevfast = fast;
                while(slow!=fast){
                    prevfast=fast;
                    slow=slow.next;
                    fast=fast.next;
                }
                prevfast.next=null;
                return fast;
            }
        }
        return head;
    }
    static boolean isCycleUsingRunner(Node head){
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }
    static boolean isCycle(Node head){
        Node temp = head;
        HashSet<Node> hs = new HashSet<>();
        while(temp!=null){
            if(hs.contains(temp.next)){
                return true;
            }
            hs.add(temp);
            temp=temp.next;
        }
        return false;
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
        a.head.next.next.next.next.next.next.next = a.head.next.next;
        System.out.println(isCycle(a.head));
        System.out.println(isCycleUsingRunner(a.head));
        Node temp = findIntersection(a.head);
        if(temp!=null){
            System.out.println("Cycle present at Node "+ temp.data);
        }else{
            System.out.println("Cycle not present");
        }
        System.out.println(isCycleUsingRunner(a.head));
    }
}
