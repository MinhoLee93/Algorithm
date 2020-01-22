class MyQueue {
    Stack<Integer> stack;

		/** Initialize your data structure here. */
		public MyQueue() {
			stack = new Stack<>();
		}

		/** Push element x to the back of queue. */
		public void push(int x) {
			stack.push(x);
		}

		/** Removes the element from in front of queue and returns that element. */
		public int pop() {
			Stack<Integer> temp = new Stack<>();

			while (!stack.isEmpty()) {
				temp.add(stack.pop());
			}

			int val = temp.pop();

			stack = new Stack<>();
			while (!temp.isEmpty()) {
				stack.add(temp.pop());
			}

			return val;
		}

		/** Get the front element. */
		public int peek() {
			Stack<Integer> temp = new Stack<>();

			while (!stack.isEmpty()) {
				temp.add(stack.pop());
			}

			int val = temp.peek();

			stack = new Stack<>();
			while (!temp.isEmpty()) {
				stack.add(temp.pop());
			}

			return val;
		}

		/** Returns whether the queue is empty. */
		public boolean empty() {
			return stack.isEmpty();
		}
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */class MyQueue {
	    Stack<Integer> stack;

			/** Initialize your data structure here. */
			public MyQueue() {
				stack = new Stack<>();
			}

			/** Push element x to the back of queue. */
			public void push(int x) {
				stack.push(x);
			}

			/** Removes the element from in front of queue and returns that element. */
			public int pop() {
				Stack<Integer> temp = new Stack<>();

				while (!stack.isEmpty()) {
					temp.add(stack.pop());
				}

				int val = temp.pop();

				stack = new Stack<>();
				while (!temp.isEmpty()) {
					stack.add(temp.pop());
				}

				return val;
			}

			/** Get the front element. */
			public int peek() {
				Stack<Integer> temp = new Stack<>();

				while (!stack.isEmpty()) {
					temp.add(stack.pop());
				}

				int val = temp.peek();

				stack = new Stack<>();
				while (!temp.isEmpty()) {
					stack.add(temp.pop());
				}

				return val;
			}

			/** Returns whether the queue is empty. */
			public boolean empty() {
				return stack.isEmpty();
			}
	}

	/**
	 * Your MyQueue object will be instantiated and called as such:
	 * MyQueue obj = new MyQueue();
	 * obj.push(x);
	 * int param_2 = obj.pop();
	 * int param_3 = obj.peek();
	 * boolean param_4 = obj.empty();
	 */