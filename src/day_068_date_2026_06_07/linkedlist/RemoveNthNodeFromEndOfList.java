package day_068_date_2026_06_07.linkedlist;

// Definition for singly-linked list.
//class ListNode {
//    int val;
//    ListNode next;
//    ListNode() {}
//    ListNode(int val) { this.val = val; }
//    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//}

public class RemoveNthNodeFromEndOfList {

    // Write your removal logic inside this method
    public ListNode removeNthFromEnd(ListNode head, int n) {

        //create a dummy
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;

        while(n-->0 && fast.next!=null){
            fast = fast.next;
        }

        while (fast!=null){
            fast = fast.next;
            slow = slow.next;
        }

        if(slow.next!= null && slow.next.next!=null){
            slow.next = slow.next.next;
        }else{
            slow.next = null;
        }
        return head;
    }

    // Helper method to print the linked list
    public static void printList(ListNode head) {
        if (head == null) {
            System.out.println("null");
            return;
        }
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList solution = new RemoveNthNodeFromEndOfList();

        // --- Test Case 1: Remove from middle (1 -> 2 -> 3 -> 4 -> 5, n = 2) ---
        System.out.println("--- Test Case 1 (Remove from Middle) ---");
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        int n1 = 2;
        System.out.print("Before: ");
        printList(head1);
        head1 = solution.removeNthFromEnd(head1, n1);
        System.out.print("After:  ");
        printList(head1);
        System.out.println();

        // --- Test Case 2: Remove the head node (1 -> 2, n = 2) ---
        System.out.println("--- Test Case 2 (Remove the Head) ---");
        ListNode head2 = new ListNode(1, new ListNode(2));
        int n2 = 2;
        System.out.print("Before: ");
        printList(head2);
        head2 = solution.removeNthFromEnd(head2, n2);
        System.out.print("After:  ");
        printList(head2);
        System.out.println();

        // --- Test Case 3: Single node list (1, n = 1) ---
        System.out.println("--- Test Case 3 (Single Node) ---");
        ListNode head3 = new ListNode(1);
        int n3 = 1;
        System.out.print("Before: ");
        printList(head3);
        head3 = solution.removeNthFromEnd(head3, n3);
        System.out.print("After:  ");
        printList(head3);
        System.out.println();

        // --- Test Case 4: Remove the tail node (1 -> 2 -> 3, n = 1) ---
        System.out.println("--- Test Case 4 (Remove the Tail) ---");
        ListNode head4 = new ListNode(1, new ListNode(2, new ListNode(3)));
        int n4 = 1;
        System.out.print("Before: ");
        printList(head4);
        head4 = solution.removeNthFromEnd(head4, n4);
        System.out.print("After:  ");
        printList(head4);
        System.out.println();
    }
}
