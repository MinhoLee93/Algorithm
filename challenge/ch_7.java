package com.example.demo.challenge;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class Ch_7 {

    @Test
    public void test() {
        int[] arr = {1,1,2,2};
        int result = countElements(arr);

        assertThat(result).isEqualTo(2);
    }

    public int countElements(int[] arr) {
        // sort (log n)
        Arrays.sort(arr);

        int result = 0;
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];
            if (hash.containsKey(current)) {
                result += hash.get(current);
                hash.remove(current);
            }
            if (hash.containsKey(current + 1)) {
                hash.replace(current + 1, hash.get(current + 1) + 1);
            } else {
                hash.put(current+1, 1);
            }
        }
        return result;
    }
}
