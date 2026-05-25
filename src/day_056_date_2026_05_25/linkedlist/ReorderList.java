package day_056_date_2026_05_25.linkedlist;

public class ReorderList {

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    // todo: Write your code inside this function (Modify the list in-place)
    public void reorderList(ListNode head) {
        int size = 0;
        ListNode prev = null;
        ListNode curr = head;
    }

    public static void printList(ListNode head) {
        if (head == null) {
            System.out.println("(Empty)");
            return;
        }
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + (current.next != null ? " -> " : ""));
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ReorderList solver = new ReorderList();

        // Example 1: Even number of nodes (1 -> 2 -> 3 -> 4)
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);

        System.out.print("Input 1:    "); printList(head1);
        System.out.println("Expected 1: 1 -> 4 -> 2 -> 3");
        solver.reorderList(head1);
        System.out.print("Actual 1:   "); printList(head1);
        System.out.println();

        // Example 2: Odd number of nodes (1 -> 2 -> 3 -> 4 -> 5)
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(5);

        System.out.print("Input 2:    "); printList(head2);
        System.out.println("Expected 2: 1 -> 5 -> 2 -> 4 -> 3");
        solver.reorderList(head2);
        System.out.print("Actual 2:   "); printList(head2);
        System.out.println();

        // Example 3: Single node
        ListNode head3 = new ListNode(1);

        System.out.print("Input 3:    "); printList(head3);
        System.out.println("Expected 3: 1");
        solver.reorderList(head3);
        System.out.print("Actual 3:   "); printList(head3);
    }
}
