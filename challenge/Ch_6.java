class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        int[] check = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            // already added
            if (check[i] == 1) {
                continue;
            }

            List<String> set = new ArrayList<>();
            set.add(strs[i]);
            check[i]++;
            for (int j = i + 1; j < strs.length; j++) {
                if(check[j]==1){
                    continue;
                }

                //System.out.println(strs[i] + " <=> " + strs[j]);
                // is anagram?
                if (checkAnagrams(strs[i], strs[j])) {
                    // then add
                    //System.out.println(">>>>>");
                    set.add(strs[j]);
                    check[j]++;
                }
            }
            result.add(set);
        }
        return result;
    }

    private boolean checkAnagrams(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        for (int i = 0; i < a.length(); i++) {
            if (b.length() == 0) {
                return false;
            }
            String temp = a.substring(i, i+1);
            if(b.indexOf(temp)==-1){
                return false;
            }
            b = b.replaceFirst(temp, "");
        }

        System.out.println(a + "," + b);

        if (b.equals("")) {
            return true;
        }

        return false;
    }
}