/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        StringBuilder base = new StringBuilder();

        while (head != null) {
            base.append((char) head.val);
            head = head.next;
        }

        if (base.toString().equals(base.reverse().toString())) {
            return true;
        } else {
            return false;
        }
    }
}