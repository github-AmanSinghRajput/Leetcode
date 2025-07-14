package LinkedList.Easy;

public class ReverseLinkedList {
    public ListNode reverseListBrute(ListNode head) {
        // Brute-force / Iterative logic will go here
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;

    }

    public static void main(String[] args) {

    }
}
