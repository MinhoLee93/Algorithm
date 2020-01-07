class Solution {
    static Set<Integer> set;
    public boolean isHappy(int n) {
       set = new HashSet<Integer>();
       boolean result = false;
       result = solve(n);
        
       return result;
    }
    
    public boolean solve(int n){
        if (set.contains(n)) {
			return false;
		} else {
			set.add(n);
		}

		int sum = 0;
		while (n != 0) {
			int temp = n % 10;
			sum += temp * temp;
			n = n / 10;
		}

		if (sum == 1) {
			return true;
		} else {
			return solve(sum);
		}
    }
}