import java.util.*;

class Solution {
    public boolean isValid(String s) {
        char[] ch = s.toCharArray();
		Stack<Character> stack = new Stack<>();

		for (char c : ch) {
			switch (c) {
			case '(':
				stack.add('(');
				break;

			case ')':
				if (!stack.isEmpty() && stack.peek() == '(') {
					stack.pop();
				} else {
					return false;
				}
				break;

			case '{':
				stack.add('{');
				break;
			case '}':
				if (!stack.isEmpty() && stack.peek() == '{') {
					stack.pop();
				} else {
					return false;
				}
				break;

			case '[':
				stack.add('[');
				break;

			case ']':
				if (!stack.isEmpty() && stack.peek() == '[') {
					stack.pop();
				} else {
					return false;
				}
				break;
			}
		}
		
		if(stack.size()==0) {
			return true;
		}else {
			return false;
		}
    }
}