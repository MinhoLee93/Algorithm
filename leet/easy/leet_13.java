package leetcode;

public class leet_13 {

	public static void main(String[] args) {

		String ss = "MCMXCIV";
		char[] ch = ss.toCharArray();

		int result = 0;

		for (int i = 0; i < ch.length; i++) {

			if (i == ch.length - 1) {
				result += getValue(ch[i]);
				break;
			}

			int t1 = getValue(ch[i]);
			int t2 = getValue(ch[i + 1]);

			// ±âº»°ª
			if (t1 >= t2) {
				result += t1;
			} else {
				// minus
				result += (t2 - t1);
				i = i + 1;
			}
		}
		
		System.out.println(result);
	}

	static int getValue(char s) {

		switch (s) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		default:
			return 0;
		}
	}
}
