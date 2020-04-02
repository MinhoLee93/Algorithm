/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        long start = 1;
        long end = n;
        while (start < end) {
            long c = (start + end) / 2;
            if (!isBadVersion((int) c)) {
                start = (int) c + 1;
            } else {
                end = (int) c;
            }
        }

        return (int) start;
    }
}