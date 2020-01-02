/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head;
        boolean result = false;

        if(head==null){
            return result;
        }
        
        while (slow.next != null && fast.next != null) {
			slow = slow.next;

			if (fast.next.next != null) {
				fast = fast.next.next;
			} else {
				break;
			}

			if (slow == fast) {
				result = true;
				break;
			}
		}
        
        return result;
    }
}