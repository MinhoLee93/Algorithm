package leetcode;

public class leet_108 {

    public static void main(String[] args) throws InterruptedException {
        int[] nums = {-3, 0, 5};

        TreeNode root = build(0, nums.length - 1, nums);
        System.out.println(root.val);
        System.out.println(root.left.val);
        System.out.println(root.right.val);
    }

    static TreeNode build(int start, int end, int[] nums) throws InterruptedException {
        int index = (start + end) / 2;
        //System.out.println(start + "," + end);
        //Thread.sleep(1000);

        if (end < start || start > end) {
            return null;
        } else {
            TreeNode root = new TreeNode(nums[index]);
            root.left = build(start, index - 1, nums);
            root.right = build(index + 1, end, nums);

            return root;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
