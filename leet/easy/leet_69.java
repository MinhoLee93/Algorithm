class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }

        if (x == 1) {
            return 1;
        }

        int s = 0;
        int e = x;

        while (s != e) {
            long temp = (s + e) / 2;
            if (temp * temp > x) {
                e = (int) temp;
            } else if (temp * temp < x) {
                if (s == temp) {
                    return s;
                }
                s = (int) temp;
            } else {
                return (int) temp;
            }
        }

        return s;
    }
}