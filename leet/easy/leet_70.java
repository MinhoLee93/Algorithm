class Solution {
    static Map<Integer, Integer> hash = new HashMap<>();

    public int climbStairs(int n) {
        return climb(n);
    }

    static int climb(int sum) {
        if (sum < 0) {
            return 0;
        }

        if (sum == 0) {
            return 1;
        }

        if (hash.containsKey(sum)) {
            return hash.get(sum);
        } else {
            hash.put(sum, climb(sum - 1) + climb(sum - 2));
            return hash.get(sum);
        }
    }
}