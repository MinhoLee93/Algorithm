class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> m1 = new HashMap<>();

        for (int n1 : nums1) {
            if (!m1.containsKey(n1)) {
                m1.put(n1, 1);
            }
        }

        List<Integer> list = new ArrayList<>();

        for (int n2 : nums2) {
            if (m1.containsKey(n2)) {
                list.add(n2);
                m1.remove(n2);
            }
        }

        int[] result = new int[list.size()];
        int index = 0;
        for (int i : list) {
            result[index++] = i;
        }

        return result;
    }
}