class Solution {
    public int findComplement(int num) {

        String binary = Integer.toBinaryString(num);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < binary.length(); i++) {
            String c = binary.substring(i, i + 1);

            if (c.equals("0")) {
                sb.append("1");
            } else {
                sb.append("0");
            }
        }

        return Integer.parseInt(sb.toString(), 2);
    }
}