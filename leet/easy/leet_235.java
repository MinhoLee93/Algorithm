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
    static TreeNode p;
	static TreeNode q;
    static TreeNode result;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.p = p;
        this.q = q;
        result = null;
        
        solve(root);
        return result;
    }
    
    public int solve(TreeNode node) {
		if (node == null) {
			return 0;
		}

		int temp = solve(node.left) + solve(node.right);

		if (temp == 2) {
			result = node;
			//System.out.println(node.val);
			return 0;
		}

		if (node == p || node == q) {
			if (temp == 1) {
				//System.out.println("temp : " + temp + " , " + node.val);
				result = node;
				return 0;
			} else {
				//System.out.println("temp : " + temp + " , " + node.val);
				return 1;
			}
		}

		return temp;
	}
}