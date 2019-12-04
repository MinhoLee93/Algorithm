// Runtime: 2 ms, faster than 48.56% of Java online submissions for Defanging an IP Address.
// Memory Usage: 34.4 MB, less than 100.00% of Java online submissions for Defanging an IP Address.

class Solution {
    public String defangIPaddr(String address) {
        return address.replace(".","[.]");
    }
}