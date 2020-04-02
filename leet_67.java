class Solution {
    public String addBinary(String a, String b) {

        int aIndex = a.length() - 1;
        int bIndex = b.length() - 1;

        int up = 0;
        StringBuilder sb = new StringBuilder();
        while (aIndex >= 0 || bIndex >= 0) {
            int sum = 0;

            if (aIndex >= 0) {
                sum += (a.charAt(aIndex) - 48);
                aIndex--;
            }

            if (bIndex >= 0) {
                sum += (b.charAt(bIndex) - 48);
                bIndex--;
            }

            sum += up;

            if (sum > 1) {
                up = 1;
            } else {
                up = 0;
            }

            sb.append(sum % 2);
        }

        if (up == 1) {
            sb.append(1);
        }


        return sb.reverse().toString();
    }
}