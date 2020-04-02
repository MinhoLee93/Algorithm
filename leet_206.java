/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode pointer = head;
        List<ListNode> list = new ArrayList<>();
        while (pointer != null) {
            list.add(0, pointer);
            pointer = pointer.next;
        }

        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).next = list.get(i + 1);
        }

        list.get(list.size() - 1).next = null;

        return list.get(0);
    }
}