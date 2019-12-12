/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		ListNode result = null;
		ListNode pointer = null;

		if (l1 == null && l2 == null) {
			 return null;
		} else if (l1 == null) {
			 return l2;
		} else if (l2 == null) {
			 return l1;
		}

		if (l1.val <= l2.val) {
			result = new ListNode(l1.val);
            l1 = l1.next;
			pointer = result;
		} else {
			result = new ListNode(l2.val);
            l2 = l2.next;
			pointer = result;
		}

		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				pointer.next = new ListNode(l1.val);
				pointer = pointer.next;
				l1 = l1.next;
			} else {
				pointer.next = new ListNode(l2.val);
				pointer = pointer.next;
				l2 = l2.next;
			}
		}

		if (l1 != null) {
			pointer.next = l1;
		} else if (l2 != null) {
			pointer.next = l2;
		}

        return result;
    }
}