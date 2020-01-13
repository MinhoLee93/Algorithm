class Solution {
    public List<String> commonChars(String[] A) {
        List<String> result = new ArrayList<>();
		Map<String, Integer> base = new HashMap<>();
		// base
		for (int i = 0; i < A[0].length(); i++) {
			String s = A[0].substring(i, i + 1);

			if (base.containsKey(s)) {
				base.replace(s, base.get(s) + 1);
			} else {
				base.put(s, 1);
			}
		}

		// compare
		for (int i = 1; i < A.length; i++) {

			// make temp
			Map<String, Integer> temp = new HashMap<>();
			for (int j = 0; j < A[i].length(); j++) {
				String s = A[i].substring(j, j + 1);

				if (temp.containsKey(s)) {
					temp.replace(s, temp.get(s) + 1);
				} else {
					temp.put(s, 1);
				}
			}

			//System.out.println(temp.get("o"));

			// compare with base
			Iterator<String> iter = base.keySet().iterator();
			while (iter.hasNext()) {
				String key = iter.next();
				// System.out.println(key);

				if (temp.containsKey(key)) {
					// smaller
					if (base.get(key) > temp.get(key)) {
						base.replace(key, temp.get(key));
					}
				} else {
					iter.remove();
				}
			}
			// System.out.println("--------");
		}

		// compare with base
		Iterator<String> iter = base.keySet().iterator();
		while (iter.hasNext()) {
			String key = iter.next();
			for (int i = 0; i < base.get(key); i++) {
				result.add(key);
			}
		}

		// for (String e : result) {
		// 	System.out.println(e);
		// }
        
        return result;
    }
}