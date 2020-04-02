class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> hash = new HashMap<Integer, Integer>();
        int maxIndex = 0;
        int maxNum = 0;

        for (int r : nums) {
            if (hash.containsKey(r)) {
                int temp = hash.get(r) + 1;
                hash.put(r, temp);

                if (temp > maxIndex) {
                    maxIndex = temp;
                    maxNum = r;
                }
            } else {
                hash.put(r, 1);
                if (1 > maxIndex) {
                    maxIndex = 1;
                    maxNum = r;
                }
            }
        }

        return maxNum;
    }
}