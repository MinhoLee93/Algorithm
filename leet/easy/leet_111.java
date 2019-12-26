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
    static int Min = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        Min = Integer.MAX_VALUE;
        if(root==null){
            return 0;
        }
        
        solve(1, root);
        return Min;
    }
    
    static void solve(int depth, TreeNode node){
        if (node.left == null && node.right == null) {
			if (depth < Min) {
				Min = depth;
			}

			return;
		}

        
        if(node.left != null) {
			solve(depth + 1, node.left);
		}
		
		if(node.right != null) {
			solve(depth + 1, node.right);
		}

    }
}