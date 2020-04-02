class Solution {
    public int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();
        sb.append(chars[0]);
        int cnt = 1;

        for (int i = 1; i < chars.length; i++) {
            // �ٸ� ���
            if (chars[i] != sb.charAt(sb.length() - 1)) {
                if (cnt > 1) {
                    sb.append(cnt);
                }
                cnt = 1;
                sb.append(chars[i]);
            } else {
                cnt++;
            }
        }

        if (cnt > 1) {
            sb.append(cnt);
        }

        for (int i = 0; i < sb.length(); i++) {
            chars[i] = sb.charAt(i);
        }

        return sb.length();
    }
}