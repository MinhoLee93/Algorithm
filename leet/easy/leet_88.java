class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
	    int mIndex = m - 1;
		int nIndex = n - 1;
		int back = nums1.length - 1;

		while (nIndex >= 0) {
			while ((nIndex < 0 && mIndex >= 0) || mIndex >= 0 && nums1[mIndex] >= nums2[nIndex]) {
				nums1[back--] = nums1[mIndex--];
			}
			while ((mIndex < 0 && nIndex >= 0) || nIndex >= 0 && nums1[mIndex] < nums2[nIndex]) {
				nums1[back--] = nums2[nIndex--];
			}
		}
    }
}