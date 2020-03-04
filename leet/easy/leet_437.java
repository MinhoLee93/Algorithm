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
    int count = 0;
    public int pathSum(TreeNode root, int sum) {
        if(root == null){
            return 0;
        }

        findPath(root,sum);
        pathSum(root.left,sum);
        pathSum(root.right,sum);
        
        return count;
    }
    public void findPath(TreeNode root, int sum){
        if(root == null){
            return;
        }

        if(root.val == sum){
            count++;
        }
        
        findPath(root.left, sum - root.val);
        findPath(root.right, sum - root.val);
    }
}