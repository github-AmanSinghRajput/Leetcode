package LinkedList.Easy;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {

    // brute force using Hashset O(n) space
    private boolean hasCycleBrute(ListNode head){
        Set<ListNode> visited = new HashSet<>();
        ListNode current = head;
        while(current != null){
            if(visited.contains(current)){
                return true;
            }
            visited.add(current);
            current = current.next;
        }
        return false;

    }

    // optimized using floyd's tortoise and Hare Algorithm

    public boolean hasCycleOptimized(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            if(slow == fast) return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }


    public static void main(String[] args){
        // ✅ No cycle
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        a.next = b;
        b.next = c;

        LinkedListCycle checker = new LinkedListCycle();
        System.out.println(checker.hasCycleOptimized(a)); // false

        // ✅ With cycle (c -> b)
        ListNode x = new ListNode(1);
        ListNode y = new ListNode(2);
        ListNode z = new ListNode(3);
        x.next = y;
        y.next = z;
        z.next = y; // creates a cycle

        System.out.println(checker.hasCycleOptimized(x)); // true

    }

}
