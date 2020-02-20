class Solution {
    public int getSum(int a, int b) {
        while(b!=0){
            // find carry
            int carry = a & b;
            
            // do addition
            a = a ^ b;
            
            // move <<
            b = carry << 1; 
        }
        
        return a;
    }
}