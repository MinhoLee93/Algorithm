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
    static List<String> result;

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        result = new ArrayList<>();
        solve("", root);
        return result;
    }

    public void solve(String path, TreeNode root) {
        // System.out.println(path);

        if (path.length() == 0) {
            path += root.val;
        } else {
            path += "->" + root.val;
        }

        if (root.left == null && root.right == null) {
            result.add(path);
            return;
        }

        if (root.left != null) {
            solve(path, root.left);
        }

        if (root.right != null) {
            solve(path, root.right);
        }

    }
}