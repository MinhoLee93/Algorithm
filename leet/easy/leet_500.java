class Solution {
    public String[] findWords(String[] words) {
        String[] s = {"QWERTYUIOP", "ASDFGHJKL", "ZXCVBNM"};
        List<String> result = new ArrayList<>();
        for (String word : words) {
            String temp = word.substring(0, 1).toUpperCase();
            int index;
            // 0
            if (s[0].indexOf(temp) != -1) {
                index = 0;
            } else if (s[1].indexOf(temp) != -1) {
                // 1
                index = 1;
            } else {
                // 2
                index = 2;
            }

            boolean check = true;
            for (int i = 1; i < word.length(); i++) {
                String t = word.substring(i, i + 1).toUpperCase();
                // ���� row�� �������� �ʴ´ٸ�
                if (s[index].indexOf(t) == -1) {
                    check = false;
                    break;
                }
            }

            // ���� row�� �����Ѵٸ�
            if (check) {
                result.add(word);
            }
        }

        return result.toArray(new String[result.size()]);
    }
}