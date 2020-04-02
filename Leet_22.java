class Solution {
    public List<String> generateParenthesis(int n) {

        List<String> output = new ArrayList<>();

        solve("", 0, 0, n, output);

        return output;
    }

    public void solve(String s , int left, int right, int target, List<String> output){
        if(s.length() == target*2){
            output.add(s);
            return;
        }

        if(left < target){
            solve(s + "(" , left+1, right, target, output);
        }

        if(right < left) {
            solve(s + ")" , left, right + 1, target ,output);
        }
    }
}