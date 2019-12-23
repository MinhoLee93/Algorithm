/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    static boolean result = true;
    public boolean isBalanced(TreeNode root) {
        result = true;
        solve(root);
		return result;
	}

	static int solve(TreeNode node) {
		if (node == null) {
			return 0;
		}

		int left = solve(node.left);
		int right = solve(node.right);

		if (Math.abs(left - right) > 1) {
			result = false;
		}

		return 1 + Math.max(left, right);
	}

}