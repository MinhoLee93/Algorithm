class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<String, Integer> hash = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            String t = magazine.substring(i, i + 1);
            if (hash.containsKey(t)) {
                hash.replace(t, hash.get(t) + 1);
            } else {
                hash.put(t, 1);
            }
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            String t = ransomNote.substring(i, i + 1);
            if (hash.containsKey(t)) {
                hash.replace(t, hash.get(t) - 1);
                if (hash.get(t) == 0) {
                    hash.remove(t);
                }
            } else {
                return false;
            }
        }

        return true;
    }
}