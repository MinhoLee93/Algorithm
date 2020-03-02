class Solution {
    public String addStrings(String num1, String num2) {
        int n1 = num1.length() - 1;
		int n2 = num2.length() - 1;
		StringBuilder sb = new StringBuilder();
		int carry = 0;

		while (n1 >= 0 || n2 >= 0) {
			int m1 = n1 >= 0 ? num1.charAt(n1--) - '0' : 0;
			int m2 = n2 >= 0 ? num2.charAt(n2--) - '0' : 0;

			int sum = m1 + m2 + carry;
			if (sum >= 10) {
				carry = sum / 10;
				sum = sum - 10;
			}else{
                carry = 0;
            }

			sb.append(sum);
		}
		
		if(carry > 0) {
			sb.append(carry);
		}

		return sb.reverse().toString();
    }
}