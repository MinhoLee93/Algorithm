class MinStack {
		Stack<Integer> numStack;
		Stack<Integer> minStack;
		int min;

		/** initialize your data structure here. */
		public MinStack() {
			numStack = new Stack();
			minStack = new Stack();
			min = Integer.MAX_VALUE;
		}

		public void push(int x) {
			if (x < min) {
				min = x;
			}

			numStack.push(x);
			minStack.push(min);
		}

		public void pop() {
			numStack.pop();
			minStack.pop();
            
           if(numStack.size()==0) {
				min = Integer.MAX_VALUE;
			}else {
				min = minStack.peek();
			}
		}

		public int top() {
			return numStack.peek();
		}

		public int getMin() {
			return minStack.peek();
		}
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */