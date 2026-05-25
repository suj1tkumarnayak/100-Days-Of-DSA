package day_056_date_2026_05_25.linkedlist;

public class ReverseALinkedList {

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    // todo: Write your code inside this function
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr!=null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + (current.next != null ? " -> " : ""));
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ReverseALinkedList solver = new ReverseALinkedList();

        // Example 1: Standard List
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);

        System.out.print("Input 1:    ");
        printList(head1);
        System.out.println("Expected 1: 5 -> 4 -> 3 -> 2 -> 1");
        ListNode res1 = solver.reverseList(head1);
        System.out.print("Actual 1:   ");
        printList(res1);
        System.out.println();

        // Example 2: Two Elements
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);

        System.out.print("Input 2:    ");
        printList(head2);
        System.out.println("Expected 2: 2 -> 1");
        ListNode res2 = solver.reverseList(head2);
        System.out.print("Actual 2:   ");
        printList(res2);
        System.out.println();

        // Example 3: Empty List
        ListNode head3 = null;

        System.out.println("Input 3:    (Empty)");
        System.out.println("Expected 3: (Empty)");
        ListNode res3 = solver.reverseList(head3);
        System.out.print("Actual 3:   ");
        printList(res3);
    }
}
