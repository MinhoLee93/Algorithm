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
    static int result;
    public int sumOfLeftLeaves(TreeNode root) {
        result = 0;
        solve(root);
        return result;
    }
    
    public void solve(TreeNode n) {
		if (n == null) {
			return;
		}

		if (n.left != null) {
			if (n.left.left == null && n.left.right == null) {
				result += n.left.val;
			} else {
				solve(n.left);
			}
		}

		solve(n.right);
	}
}