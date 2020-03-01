class Solution {
    public int thirdMax(int[] nums) {
        Stack<Integer> ss = new Stack<>();
		for (int n : nums) {
			if (ss.isEmpty()) {
				ss.push(n);
			} else {
				Stack<Integer> temp = new Stack<>();
				// 추출 (n이 작을때까지)
				while (!ss.isEmpty() && ss.peek() <= n) {
					// 넣어둔다
					if (ss.peek() != n) {
						temp.push(ss.pop());
					}else {
						ss.pop();
					}
				}
				// 넣는다
				if (ss.size() < 3) {
					ss.push(n);
				}
				// 다시 쌓기 (size =3)
				if (ss.size() < 3) {
					while (!temp.isEmpty() && ss.size() != 3) {
						ss.push(temp.pop());
					}
				}
			}
		}
		
		if(ss.size()==3) {
			return ss.peek();
		}else {
			return ss.get(0);
		}
    }
}