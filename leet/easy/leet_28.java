package leetcode;

public class leet_28 {

	public static void main(String[] args) {
		String heystack = "hello";
		String needle = "ll";

		int hLength = heystack.length();
		int nLength = needle.length();

		if (hLength == 0 || nLength == 0) {
			// return -1;
		}

		if (hLength < nLength) {
			// return -1;
		}

		for (int i = 0; i <= hLength - nLength; i++) {
			if (heystack.substring(i, i + nLength).equals(needle)) {
				System.out.println(i);
				return;
			}
		}
		
		// return -1;
	}
}
