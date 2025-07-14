package LinkedList.Easy;

public class MergeSortedLists {

    public ListNode mergeTwoLists(ListNode list1,ListNode list2){
        ListNode resultSortedList = new ListNode(0);
        ListNode tail = resultSortedList;

        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                tail.next = list1;
                list1 = list1.next;
            }
            else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        if(list1 != null) tail.next = list1;
        else tail.next = list2;


        return resultSortedList.next;


    }

    public static void main(String[] args) {
        MergeSortedLists solution = new MergeSortedLists(); // Replace with your actual class name

        // 🧪 Test Case 1: Both lists non-empty
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(5);

        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(6);

        ListNode result = solution.mergeTwoLists(list1, list2);
        printList(result); // Expected: 1 -> 2 -> 3 -> 4 -> 5 -> 6

        // 🧪 Test Case 2: One list is empty
        ListNode list3 = null;
        ListNode list4 = new ListNode(0);
        list4.next = new ListNode(9);

        result = solution.mergeTwoLists(list3, list4);
        printList(result); // Expected: 0 -> 9

        // 🧪 Test Case 3: Both lists are empty
        result = solution.mergeTwoLists(null, null);
        printList(result); // Expected: (prints nothing)
    }

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }
}
