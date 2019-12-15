class Solution {
    public String addBinary(String a, String b) {
        
        String result = "";

		int aIndex = a.length() - 1;
		int bIndex = b.length() - 1;

		int up = 0;
		if (a.length() > b.length()) {
			while (aIndex >= 0) {
				int aa = Integer.parseInt(a.substring(aIndex, aIndex + 1));
				if (bIndex >= 0) {
					int bb = Integer.parseInt(b.substring(bIndex, bIndex + 1));
					if (up + aa + bb >= 2) {
						result = String.valueOf(up + aa + bb - 2) + result;
						up = 1;
					} else {
						result = String.valueOf(up + aa + bb) + result;
						up = 0;
					}
				} else {
					if (up + aa >= 2) {
						result = String.valueOf(up + aa - 2) + result;
						up = 1;
					} else {
						result = String.valueOf(up + aa) + result;
						up = 0;
					}
				}
				aIndex--;
				bIndex--;
			}
		} else {
			while (bIndex >= 0) {
				int bb = Integer.parseInt(b.substring(bIndex, bIndex + 1));
				if (aIndex >= 0) {
					int aa = Integer.parseInt(a.substring(aIndex, aIndex + 1));
					if (up + aa + bb >= 2) {
						result = String.valueOf(up + aa + bb - 2) + result;
						up = 1;
					} else {
						result = String.valueOf(up + aa + bb) + result;
						up = 0;
					}
				} else {
					if (up + bb >= 2) {
						result = String.valueOf(up + bb - 2) + result;
						up = 1;
					} else {
						result = String.valueOf(up + bb) + result;
						up = 0;
					}
				}
				aIndex--;
				bIndex--;
			}
		}
		
		if(up==1) {
			result = "1" + result;
		}
		
		return result;
    }
}