class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
		Arrays.sort(s);

		int result = 0;
		int gIndex = 0;
		int sIndex = 0;

		while (gIndex < g.length && sIndex < s.length) {
			if (g[gIndex] <= s[sIndex]) {
				result++;
				gIndex++;
				sIndex++;
			} else {
				sIndex++;
			}
		}
        
        return result;
    }
}