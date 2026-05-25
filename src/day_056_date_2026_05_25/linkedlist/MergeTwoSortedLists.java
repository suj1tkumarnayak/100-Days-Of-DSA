package day_056_date_2026_05_25.linkedlist;

public class MergeTwoSortedLists {

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    // Write your code inside this function
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null) return list2;
        if(list2==null) return list1;
        ListNode head;
        if(list1.val<list2.val){
            head = list1;
            list1 = list1.next;
        }else{
            head = list2;
            list2 = list2.next;
        }
        ListNode dummy = head;
        while (list1!=null && list2!=null){
            if(list1.val<list2.val){
                dummy.next = list1;
                list1 = list1.next;
            }else{
                dummy.next = list2;
                list2 = list2.next;
            }
            dummy = dummy.next;
        }

        while (list1!=null){
            dummy.next = list1;
            list1 = list1.next;
            dummy = dummy.next;
        }

        while (list2!=null){
            dummy.next = list2;
            list2 = list2.next;
            dummy = dummy.next;
        }

        return head;
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
        MergeTwoSortedLists solver = new MergeTwoSortedLists();

        // Example 1: Both lists have elements
        ListNode list1_1 = new ListNode(1);
        list1_1.next = new ListNode(2);
        list1_1.next.next = new ListNode(4);

        ListNode list1_2 = new ListNode(1);
        list1_2.next = new ListNode(3);
        list1_2.next.next = new ListNode(4);

        System.out.print("Input 1:    List 1: "); printList(list1_1);
        System.out.print("            List 2: "); printList(list1_2);
        System.out.println("Expected 1: 1 -> 1 -> 2 -> 3 -> 4 -> 4");
        ListNode res1 = solver.mergeTwoLists(list1_1, list1_2);
        System.out.print("Actual 1:   "); printList(res1);
        System.out.println();

        // Example 2: Both lists are empty
        ListNode list2_1 = null;
        ListNode list2_2 = null;

        System.out.println("Input 2:    List 1: (Empty) | List 2: (Empty)");
        System.out.println("Expected 2: (Empty)");
        ListNode res2 = solver.mergeTwoLists(list2_1, list2_2);
        System.out.print("Actual 2:   "); printList(res2);
        System.out.println();

        // Example 3: One list is empty
        ListNode list3_1 = null;
        ListNode list3_2 = new ListNode(0);

        System.out.print("Input 3:    List 1: (Empty) | List 2: "); printList(list3_2);
        System.out.println("Expected 3: 0");
        ListNode res3 = solver.mergeTwoLists(list3_1, list3_2);
        System.out.print("Actual 3:   "); printList(res3);
    }
}
