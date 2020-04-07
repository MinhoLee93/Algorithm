/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode h = dummy;

        while (h != null && h.next != null){
            System.out.println(h.val);

            ListNode left = h.next;
            // right exist
            if(left.next !=null){
                ListNode right = left.next;
                left.next = right.next;
                right.next = left;
                h.next = right;
            }

            // move head
            h = h.next.next;
        }

        return  dummy.next;
    }
}