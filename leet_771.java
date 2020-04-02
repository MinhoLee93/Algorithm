class Solution {
    public int numJewelsInStones(String J, String S) {

        int result = 0;

        Map<Character, Integer> jewels = new HashMap<>();
        for (int i = 0; i < J.length(); i++) {
            char c = J.charAt(i);
            jewels.put(c, 1);
        }

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (jewels.containsKey(c)) {
                result++;
            }
        }

        return result;
    }
}
