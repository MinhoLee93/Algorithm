class Solution {
    public int firstUniqChar(String s) {
        Map<String, Integer> hash = new HashMap<>();
		List<String> list = new ArrayList<>();

		for (int i = 0; i < s.length(); i++) {
			String temp = s.substring(i, i + 1);
			if (hash.containsKey(temp)) {
				if (list.indexOf(temp) != -1) {
					list.remove(temp);
				}
			} else {
				hash.put(temp, i);
				list.add(temp);
			}
		}

		if (list.size() > 0) {
			return hash.get(list.get(0));
		} else {
			return -1;
		}
    }
}