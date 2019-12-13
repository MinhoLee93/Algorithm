package leetcode;

public class leet_38 {

	public static void main(String[] args) {
		int n = 5;
		StringBuilder sb = new StringBuilder();
		sb.append("1");

		if (n == 1) {
			System.out.println(1);
			return;
		}

		for (int i = 1; i < n; i++) {
			String temp = sb.toString();
			int cnt = 1;
			char num = temp.charAt(0);
			sb = new StringBuilder();
			for (int j = 1; j < temp.length(); j++) {
				char t = temp.charAt(j);
				if (t != num) {
					sb.append(cnt);
					sb.append(num);
					cnt = 1;
					num = t;
				} else {
					cnt++;
				}
			}
			sb.append(cnt);
			sb.append(num);
		}
		
		System.out.println(sb.toString());
	}
}
