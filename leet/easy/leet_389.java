class Solution {
    public char findTheDifference(String s, String t) {
      	Map<Character, Integer> hash = new HashMap<>();
		char[] ss = s.toCharArray();
		for (char temp : ss) {
			if (hash.containsKey(temp)) {
				hash.replace(temp, hash.get(temp) + 1);
			} else {
				hash.put(temp, 1);
			}
		}
		
		char[] tt = t.toCharArray();
        char result = 'r';
		for(char temp : tt) {
			if (hash.containsKey(temp)) {
				hash.replace(temp, hash.get(temp) - 1);
				if(hash.get(temp)==0) {
					hash.remove(temp);
				}
			} else {
				result = temp;
                break;
			}
		}
        
        return result;
    }
}