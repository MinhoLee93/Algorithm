// Runtime: 2 ms, faster than 81.38% of Java online submissions for Add Two Numbers.
// Memory Usage: 43.8 MB, less than 87.15% of Java online submissions for Add Two Numbers.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
      	ListNode result = null;
		ListNode pointer = null;

		boolean flag = false;
		boolean first = true;

		while (l1 != null || l2 != null) {

			int value1 = 0;
			int value2 = 0;
			if (l1 != null) {
				value1 = l1.val;
			}

			if (l2 != null) {
				value2 = l2.val;
			}

			int temp = 0;
			if (flag) {
				temp = (value1 + value2) + 1;
			} else {
				temp = (value1 + value2);
			}

			if (temp >= 10) {
				// 한자리수로 변경
				temp = temp - 10;
				// 다음자리 1 더해야 된다.
				flag = true;
			} else {
				// 다음자리 1 더하지 않아도 된다.
				flag = false;
			}

			if (first) {
				ListNode n = new ListNode(temp);
				result = n;
				pointer = n;
				first = false;
			} else {
				ListNode n = new ListNode(temp);
				pointer.next = n;
				pointer = pointer.next;
			}

			if (l1 != null) {
				l1 = l1.next;
			}

			if (l2 != null) {
				l2 = l2.next;
			}
		}
        
        if(flag){
            pointer.next = new ListNode(1);
        }
        
        return result;
    }
}