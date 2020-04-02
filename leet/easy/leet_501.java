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
    private int max = 0;
    private Map<Integer, Integer> hash;
    public int[] findMode(TreeNode root) {
        max = 0;
        hash = new HashMap<>();

        // temp
        List<Integer> arr = new ArrayList<>();

        // find element
        find(root);

        Iterator<Integer> iter = hash.keySet().iterator();
        while (iter.hasNext()){
            int t = iter.next();

            // max
            if(hash.get(t)==max){
                arr.add(t);
            }
        }

        int[] result = new int[arr.size()];
        int index = 0;
        for(int i : arr){
            result[index++] = i;
        }

        return result;
    }

    public void find(TreeNode root){

        if(root==null){
            return;
        }

        //System.out.println(root.val);

        // first
        if(!hash.containsKey(root.val)){
            hash.put(root.val , 1);
            if(max==0){
                max = 1;
            }
        }else{
            // else
            hash.put(root.val, hash.get(root.val)+1);
            if(hash.get(root.val) > max){
                max = hash.get(root.val);
            }
        }

        find(root.left);
        find(root.right);
    }
}