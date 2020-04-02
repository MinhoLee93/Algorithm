class Solution {
    public int thirdMax(int[] nums) {
        Stack<Integer> ss = new Stack<>();
        for (int n : nums) {
            if (ss.isEmpty()) {
                ss.push(n);
            } else {
                Stack<Integer> temp = new Stack<>();
                // ���� (n�� ����������)
                while (!ss.isEmpty() && ss.peek() <= n) {
                    // �־�д�
                    if (ss.peek() != n) {
                        temp.push(ss.pop());
                    } else {
                        ss.pop();
                    }
                }
                // �ִ´�
                if (ss.size() < 3) {
                    ss.push(n);
                }
                // �ٽ� �ױ� (size =3)
                if (ss.size() < 3) {
                    while (!temp.isEmpty() && ss.size() != 3) {
                        ss.push(temp.pop());
                    }
                }
            }
        }

        if (ss.size() == 3) {
            return ss.peek();
        } else {
            return ss.get(0);
        }
    }
}