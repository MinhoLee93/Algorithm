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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        solve(1, root, result);
        return result;
    }

    static void solve(int depth, TreeNode node, List<List<Integer>> result) {
        if (node == null) {
            return;
        }

        if (result.size() < depth) {
            result.add(0, new ArrayList<Integer>());
        }

        List<Integer> temp = result.get(result.size() - depth);
        temp.add(temp.size(), node.val);

        if (node.left != null) {
            solve(depth + 1, node.left, result);
        }

        if (node.right != null) {
            solve(depth + 1, node.right, result);
        }

    }
}