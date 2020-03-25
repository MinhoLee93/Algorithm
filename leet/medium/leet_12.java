class Solution {
    static int[] arr = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
	static Map<Integer, String> hash = new HashMap<>();
    public String intToRoman(int num) {
        hash.put(1000, "M");
		hash.put(900, "CM");
		hash.put(500, "D");
		hash.put(400, "CD");
		hash.put(100, "C");
		hash.put(90, "XC");
		hash.put(50, "L");
		hash.put(40, "XL");
		hash.put(10, "X");
		hash.put(9, "IX");
		hash.put(5, "V");
		hash.put(4, "IV");
		hash.put(1, "I");

		String result = find(num, 0);
		return result;
    }
    
    public String find(int num, int index) {
		if (num == 0) {
			return "";
		}
		if (num - arr[index] >= 0) {
			return hash.get(arr[index]) + find(num - arr[index], index);
		} else {
			return find(num, index + 1);
		}
	}
}