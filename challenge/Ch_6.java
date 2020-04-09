package com.example.demo.challenge;

import org.junit.Test;

import java.awt.print.Pageable;
import java.util.*;

public class Ch_6 {

    @Test
    public void test() {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams(strs);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hash = new HashMap<>();
        for (String s : strs) {
            int[] scores = new int[26];
            for(char c : s.toCharArray()){
                scores[c - 'a']++;
            }
            String key = Arrays.toString(scores);
            System.out.println(Arrays.toString(scores));
            hash.putIfAbsent(key, new ArrayList<>());
            hash.get(key).add(s);
        }

        return new ArrayList(hash.values());
    }
}
