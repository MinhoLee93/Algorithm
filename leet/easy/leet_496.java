class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> hash = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums2.length; i++) {
            int temp = nums2[i];
            // push if empty
            if (stack.isEmpty()) {
                stack.push(temp);
            } else {
                // pop
                while (!stack.isEmpty() && stack.peek() < temp) {
                    int head = stack.pop();
                    hash.put(head, temp);
                }
                stack.push(temp);
            }
        }

        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int temp = nums1[i];
            if (hash.containsKey(temp)) {
                result[i] = hash.get(temp);
            } else {
                result[i] = -1;
            }
        }

        return result;
    }
}