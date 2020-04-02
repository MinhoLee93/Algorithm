class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        sb.append("");

        int index = 0;
        boolean flag = true;

        if (strs.length == 0) {
            return sb.toString();
        }

        while (flag) {

            char temp = ' ';
            for (int i = 0; i < strs.length; i++) {
                if (strs[i].length() < (index + 1)) {
                    flag = false;
                    break;
                }

                if (temp == ' ') {
                    temp = strs[i].charAt(index);
                } else {
                    if (temp != strs[i].charAt(index)) {
                        flag = false;
                        break;
                    }
                }
            }

            if (flag) {
                sb.append(temp);
            }

            index++;
        }

        return sb.toString();
    }
}