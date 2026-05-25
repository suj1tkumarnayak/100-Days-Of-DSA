package day_056_date_2026_05_25.linkedlist;

public class LinkedListCycle {

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    // Write your code inside this function
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        LinkedListCycle solver = new LinkedListCycle();

        // Example 1: Cycle exists (tail connects to node at index 1)
        ListNode head1 = new ListNode(3);
        ListNode node1_1 = new ListNode(2);
        ListNode node1_2 = new ListNode(0);
        ListNode node1_3 = new ListNode(-4);

        head1.next = node1_1;
        node1_1.next = node1_2;
        node1_2.next = node1_3;
        node1_3.next = node1_1; // Creates the cycle back to 2

        System.out.println("Expected 1: true");
        boolean res1 = solver.hasCycle(head1);
        System.out.println("Actual 1:   " + res1);
        System.out.println();

        // Example 2: Cycle exists (tail connects to node at index 0)
        ListNode head2 = new ListNode(1);
        ListNode node2_1 = new ListNode(2);

        head2.next = node2_1;
        node2_1.next = head2; // Creates the cycle back to 1

        System.out.println("Expected 2: true");
        boolean res2 = solver.hasCycle(head2);
        System.out.println("Actual 2:   " + res2);
        System.out.println();

        // Example 3: No cycle
        ListNode head3 = new ListNode(1);

        System.out.println("Expected 3: false");
        boolean res3 = solver.hasCycle(head3);
        System.out.println("Actual 3:   " + res3);
    }
}
