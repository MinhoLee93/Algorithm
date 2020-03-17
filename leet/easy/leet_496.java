class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nextGreaterElement = getNextGreaterElement(nums2);
        
        int[] greaterElements = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            greaterElements[i] = nextGreaterElement.containsKey(nums1[i]) ? 
                                 nextGreaterElement.get(nums1[i]) : -1;
        }
        
        return greaterElements;
    }
    
    private HashMap<Integer, Integer> getNextGreaterElement(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int num: nums) {
            while (stack.size() != 0 && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            
            stack.push(num);
        }
        
        return map;
    }
}