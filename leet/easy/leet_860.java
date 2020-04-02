class Solution {
    static int[] change;

    public boolean lemonadeChange(int[] bills) {
        change = new int[3];

        if (bills[0] > 5) {
            return false;
        }

        for (int bill : bills) {
            if (bill - 5 > 0) {
                if (!back(bill - 5)) {
                    return false;
                }
            }

            if (bill == 5) {
                change[0]++;
            } else if (bill == 10) {
                change[1]++;
            } else {
                change[2]++;
            }
        }

        return true;
    }

    public boolean back(int amount) {

        int index = 2;
        while (amount > 0) {

            if (index < 0) {
                return false;
            }

            if (change[index] > 0) {
                if (index == 0 && amount >= 5) {
                    amount -= 5;
                    change[index]--;
                } else if (index == 1 && amount >= 10) {
                    amount -= 10;
                    change[index]--;
                } else if (index == 2 && amount >= 20) {
                    amount -= 20;
                    change[index]--;
                } else {
                    index--;
                }
            } else {
                index--;
            }

        }

        return true;
    }
}