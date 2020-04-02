class Solution {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();

        int cnt = 0;
        for (int i = S.length() - 1; i >= 0; i--) {
            char c = S.charAt(i);

            if (c == '-') {
                continue;
            }

            if (cnt == K) {
                sb.append("-");
                cnt = 0;
            }

            sb.append(S.charAt(i));
            cnt++;

        }

        return sb.reverse().toString().toUpperCase();
    }
}