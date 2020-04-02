package leetcode;

import java.util.HashMap;
import java.util.Map;

public class leet_290 {
    public static void main(String[] args) {
        String pattern = "aaa";
        String str = "aa aa aa aa";

        wordPattern(pattern, str);
    }

    static void wordPattern(String pattern, String str) {
        char[] pArr = pattern.toCharArray();
        String[] sArr = str.split(" ");

        if (pArr.length != sArr.length) {
            System.out.println("false");
        }

        Map<Character, String> hashP = new HashMap<>();
        Map<String, Character> hashS = new HashMap<>();

        for (int i = 0; i < pArr.length; i++) {
            if (!hashP.containsKey(pArr[i]) && !hashS.containsKey(sArr[i])) {
                System.out.println(pArr[i] + " : " + sArr[i]);
                hashP.put(pArr[i], sArr[i]);
                hashS.put(sArr[i], pArr[i]);
            } else if (hashP.containsKey(pArr[i]) && !hashS.containsKey(sArr[i])) {
                System.out.println("false");
                break;
            } else if (!hashP.containsKey(pArr[i]) && hashS.containsKey(sArr[i])) {
                System.out.println("false");
                break;
            } else {
                if ((hashP.get(pArr[i]).equals(sArr[i]) && hashS.get(sArr[i]) == pArr[i])) {

                } else {
                    System.out.println("false");
                }
            }
        }
    }
}
