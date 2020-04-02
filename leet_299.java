class Solution {
    public String getHint(String secret, String guess) {
        int[] secretArr = new int[10];
        int[] guessArr = new int[10];

        int A = 0;

        for (int i = 0; i < secret.length(); i++) {
            String s = secret.substring(i, i + 1);
            String g = guess.substring(i, i + 1);

            if (s.equals(g)) {
                A++;
            } else {
                secretArr[Integer.parseInt(s)]++;
                guessArr[Integer.parseInt(g)]++;
            }
        }

        int B = 0;
        for (int i = 0; i < 10; i++) {
            if (secretArr[i] * guessArr[i] != 0) {
                if (secretArr[i] > guessArr[i]) {
                    B += guessArr[i];
                } else {
                    B += secretArr[i];
                }
            }
        }

        return A + "A" + B + "B";
    }
}