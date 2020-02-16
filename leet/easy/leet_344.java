package leetcode;

public class leet_344 {

	public static void main(String[] args) {
		char[] s = { 'h', 'e', 'l', 'l', 'o' };
		for (int i = 0; i < s.length / 2; i++) {
			char temp = s[s.length - 1 - i];
			s[s.length - 1 - i] = s[i];
			s[i] = temp;
		}

		for (char c : s) {
			System.out.print(c + " ");
		}
	}
}
