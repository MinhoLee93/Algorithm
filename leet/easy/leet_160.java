/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> arr = new HashSet<>();
		while (headA != null) {
			arr.add(headA);
			headA = headA.next;
		}

		while (headB != null) {
			if (arr.contains(headB)) {
				return headB;
			} else {
				headB = headB.next;
			}
		}
        
        return null;
    }
}