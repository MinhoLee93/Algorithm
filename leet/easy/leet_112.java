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
    static int target;
    static boolean result = false;

    public boolean hasPathSum(TreeNode root, int sum) {
        target = sum;
        result = false;

        if (root == null) {
            return result;
        }

        solve(root.val, root);
        return result;
    }


    static void solve(int s, TreeNode node) {
        if (node.left == null && node.right == null) {
            if (s == target) {
                result = true;
            }
        }

        if (node.left != null) {
            solve(s + node.left.val, node.left);
        }

        if (node.right != null) {
            solve(s + node.right.val, node.right);
        }
    }
}