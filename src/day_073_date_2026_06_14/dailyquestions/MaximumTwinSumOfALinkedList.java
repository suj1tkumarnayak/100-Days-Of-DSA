package day_073_date_2026_06_14.dailyquestions;

// https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/?envType=daily-question&envId=2026-06-14

import java.util.ArrayList;
import java.util.Stack;

public class MaximumTwinSumOfALinkedList {

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        // Test Case 1: [5, 4, 2, 1]
        // Twins: (5, 1) -> sum 6; (4, 2) -> sum 6. Max = 6
        ListNode head1 = createLinkedList(new int[]{5, 4, 2, 1});
        System.out.println("Test Case 1 Output: " + pairSum(head1)); // Expected: 6

        // Test Case 2: [4, 2, 2, 3]
        // Twins: (4, 3) -> sum 7; (2, 2) -> sum 4. Max = 7
        ListNode head2 = createLinkedList(new int[]{4, 2, 2, 3});
        System.out.println("Test Case 2 Output: " + pairSum(head2)); // Expected: 7

        // Test Case 3: [1, 100000]
        // Twins: (1, 100000) -> sum 100001. Max = 100001
        ListNode head3 = createLinkedList(new int[]{1, 100000});
        System.out.println("Test Case 3 Output: " + pairSum(head3)); // Expected: 100001
    }

    public static int pairSum(ListNode head) {
        if(head==null) return 0;

        // step 1: Find the middle of the Linked List
        ListNode slow = head;
        ListNode fast = head;
        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // step 2: Reverse the second half of the Linked List starting from the slow
        ListNode prev = null;
        ListNode curr = slow;

        while (curr!=null){
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        // 'prev' is now the head of the reversed second half
        ListNode firstHalf = head;
        ListNode secondHalf = prev;
        int maxSum = 0;

        // Step 3: Pair them up and find the maximum sum
        while (secondHalf!=null){
            maxSum = Math.max(maxSum, firstHalf.val+ secondHalf.val);
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return maxSum;
    }

    public static int betterApproach(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        Stack<Integer> stack = new Stack<>();

        // push only the first half of the list onto the stack
        while (fast!=null && fast.next!=null){
            stack.add(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }

        // slow is now the start of the
        int max = 0;

        while (slow!=null){
            max = Math.max(max, slow.val+stack.pop());
            slow = slow.next;
        }

        return max;
    }

    // this approach straight forwardly copies the linklist compares ith and n-1-ith pairs sum
    public static int bruteForce(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head!=null){
            list.add(head.val);
            head = head.next;
        }
        int n = list.size();
        int max = Integer.MIN_VALUE;
        int i = 0, j = n-1;

        while (i<j){
            int sum = list.get(i)+list.get(j);
            max = Math.max(sum, max);
            i++;
            j--;
        }

        return max;
    }

    // Helper method to build a linked list from an array
    private static ListNode createLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int val : arr) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }
}