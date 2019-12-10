class Solution {
    public int reverse(int x) {
        int result = 0;
	   
        while (x != 0) {
			int c = x % 10;
			int temp = result * 10 + c;

			if ((temp - c) / 10 != result) {
				return 0;
			}

			result = temp;
			x = x / 10;
		}
        
        return result;
    }
}
