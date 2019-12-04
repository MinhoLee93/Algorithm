package leetcode;

public class N58 {
	public static void main(String[] args) {

		String s = "   ";

		if (s.length() == 0) {
			System.out.println(0);
		} else {
			String[] ss = s.split(" ");
			if(ss.length==0) {
				System.out.println(0);
			}else {
				System.out.println(ss[ss.length-1].length());
			}
		}
	}
}
