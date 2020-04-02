class Solution {
    public int longestPalindrome(String s) {
        int result = 0;
        Map<String, Integer> hash = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            String temp = s.substring(i, i + 1);

            if (hash.containsKey(temp)) {
                hash.replace(temp, hash.get(temp) + 1);
            } else {
                hash.put(temp, 1);
            }
        }

        Iterator<String> iter = hash.keySet().iterator();
        while (iter.hasNext()) {
            String key = iter.next();
            if (hash.get(key) / 2 > 0) {
                result += (hash.get(key) / 2) * 2;
            }
        }

        if (result != s.length()) {
            return result + 1;
        } else {
            return result;
        }
    }
}