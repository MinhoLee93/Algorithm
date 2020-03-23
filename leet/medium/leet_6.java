class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1){
            return s;
        }
        
        
        List<StringBuilder> arr = new ArrayList<>();
		// add empty stringbuilder
		for (int i = 0; i < numRows; i++) {
			arr.add(new StringBuilder());
		}

		int cnt = 0;
		int index = 0;
		boolean flag = true;
		while (cnt < s.length()) {
			String temp = s.substring(cnt, cnt + 1);
			//System.out.println("index : " + index + " , temp : " + temp);
			arr.get(index).append(temp);
			cnt++;
			// + 방향
			if (flag) {
				if (index < numRows - 1) {
					index++;
				} else {
					flag = false;
					index--;
				}
				// - 방향
			} else {
				if (index > 0) {
					index--;
				} else {
					flag = true;
					index++;
				}
			}
		}

		StringBuilder result = new StringBuilder();
		for (int i = 0; i < arr.size(); i++) {
			result.append(arr.get(i).toString());
		}

		return result.toString();
    }
}