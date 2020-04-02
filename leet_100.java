/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        solve(s1, p);
        solve(s2, q);

        if (s1.toString().equals(s2.toString())) {
            return true;
        } else {
            return false;
        }
    }

    static void solve(StringBuilder s, TreeNode n) {
        if (n == null) {
            s.append("null");
            return;
        }

        s.append(n.val);
        solve(s, n.left);
        solve(s, n.right);
    }
}