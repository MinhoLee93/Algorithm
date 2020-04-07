/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // dummy
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // slow & fast
        ListNode slow = dummy;
        ListNode fast = dummy;

        // move fast
        for(int i=1; i<=n+1; i++){
            fast = fast.next;
        }

        // find n-1
        while (fast != null){
            slow = slow.next;
            fast = fast.next;
        }

        // remove n
        slow.next = slow.next.next;

        // return result
        return dummy.next;

    }
}