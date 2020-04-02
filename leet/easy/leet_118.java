package leetcode;

import java.util.ArrayList;
import java.util.List;

public class leet_118 {
    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
        int numRows = 3;

        if (numRows == 0) {
            // return null;
        }

        result.add(new ArrayList<Integer>());
        result.get(0).add(1);

        if (numRows == 1) {
            // return result;
        } else {
            // 2
            result.add(new ArrayList<Integer>());
            result.get(1).add(1);
            result.get(1).add(1);

            for (int i = 2; i < numRows; i++) {
                result.add(i, solve(i, result.get(i - 1)));
            }
        }

        for (List<Integer> c : result) {
            for (int i : c) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    static List<Integer> solve(int end, List<Integer> temp) {
        List<Integer> ne = new ArrayList<Integer>();
        ne.add(0, 1);
        for (int i = 1; i < end; i++) {
            ne.add(i, temp.get(i - 1) + temp.get(i));
        }
        ne.add(end, 1);
        return ne;
    }
}
