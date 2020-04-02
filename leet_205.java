class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        if (s == null || s.length() == 0) {
            return true;
        }

        Map<Character, Character> hash = new HashMap<>();
        Set<Character> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ss = s.charAt(i);
            char tt = t.charAt(i);

            if (hash.containsKey(ss)) {
                sb.append(hash.get(ss));
            } else {
                if (set.contains(tt)) {
                    return false;
                } else {
                    hash.put(ss, tt);
                    sb.append(tt);
                    set.add(tt);
                }
            }
        }

        if (sb.toString().equals(t)) {
            return true;
        } else {
            return false;
        }
    }
}