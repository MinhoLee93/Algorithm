class Solution {
    public List<String> letterCombinations(String digits) {
        String[] base = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new ArrayList<>();
        if(digits.length()==0 || digits==null){
            return result;
        }
        solve("", 0, digits, result, base);

        return result;
    }

    public void solve(String s, int index, String digits, List<String> result, String[] base) {
        if (index == digits.length()) {
            result.add(s);
            return;
        }

        int t = Integer.valueOf(digits.substring(index, index + 1));
        //System.out.println("digit : " + t);
        String alpha = base[t];
        for (int i = 0; i < alpha.length(); i++) {
            solve(s + alpha.substring(i, i+1), index+1, digits, result, base);
        }
    }
}