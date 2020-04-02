/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        // head
        while (head != null && head.val == val) {
            head = head.next;
        }

        ListNode pointer = head;
        while (pointer != null) {
            // System.out.println(pointer.val);
            if (pointer.next != null && pointer.next.val == val) {
                pointer.next = pointer.next.next;
            } else {
                pointer = pointer.next;
            }
        }

        return head;
    }
}