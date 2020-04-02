/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode before = head;
        ListNode pointer = head.next;
        int x = before.val;

        while (pointer != null) {
            // new number
            if (x != pointer.val) {
                x = pointer.val;
                before.next = pointer;
                before = pointer;
                pointer = pointer.next;
            } else {
                // existing number
                pointer = pointer.next;
                before.next = pointer;
            }
        }

        return head;
    }
}