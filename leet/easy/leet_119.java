class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
		result.add(1);

		if (rowIndex == 0) {
			return result;
		} else {
			solve(rowIndex, result);
		}
        
        return result;
    }
    
    static void solve(int cnt, List<Integer> s) {
		if (cnt == 0) {
			return;
		}

		for (int i = 0; i < s.size() - 1; i++) {
			s.set(i, s.get(i) + s.get(i + 1));
		}

		s.add(0, 1);

		solve(cnt - 1, s);
	}
}