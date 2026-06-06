package day_068_date_2026_06_07.linkedlist;

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class ReorderList {

    // Write your reorder logic inside this method
    public void reorderList(ListNode head) {

        if(head==null || head.next==null){
            return;
        }

        ListNode slow = head;
        ListNode fast = head;
        // find the middle point
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse the linked list after middle point
        ListNode curr = slow.next;
        slow.next = null;

        ListNode prev = null;

        while (curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // merge the the first part and second part
        ListNode first = head;
        ListNode second = prev;

        while (second!=null){
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }
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
        ReorderList solution = new ReorderList();

        // --- Test Case 1: Even Number of Nodes (1 -> 2 -> 3 -> 4) ---
        System.out.println("--- Test Case 1 (Even Nodes) ---");
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        System.out.print("Before: ");
        printList(head1);
        solution.reorderList(head1);
        System.out.print("After:  ");
        printList(head1);
        System.out.println();

        // --- Test Case 2: Odd Number of Nodes (1 -> 2 -> 3 -> 4 -> 5) ---
        System.out.println("--- Test Case 2 (Odd Nodes) ---");
        ListNode head2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.print("Before: ");
        printList(head2);
        solution.reorderList(head2);
        System.out.print("After:  ");
        printList(head2);
        System.out.println();

        // --- Test Case 3: Single Node (1) ---
        System.out.println("--- Test Case 3 (Single Node) ---");
        ListNode head3 = new ListNode(1);
        System.out.print("Before: ");
        printList(head3);
        solution.reorderList(head3);
        System.out.print("After:  ");
        printList(head3);
        System.out.println();

        // --- Test Case 4: Empty List ---
        System.out.println("--- Test Case 4 (Empty List) ---");
        ListNode head4 = null;
        System.out.print("Before: ");
        printList(head4);
        solution.reorderList(head4);
        System.out.print("After:  ");
        printList(head4);
        System.out.println();
    }
}
