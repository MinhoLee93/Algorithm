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
    public boolean isSymmetric(TreeNode root) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        if (root == null) {
            return true;
        }

        solve(s1, root.left);
        reverse(s2, root.right);

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

    static void reverse(StringBuilder s, TreeNode n) {
        if (n == null) {
            s.append("null");
            return;
        }

        s.append(n.val);
        reverse(s, n.right);
        reverse(s, n.left);
    }
}