class Solution {
    public int[] separateDigits(int[] nums) {
        String s = "";
        for (int x : nums) {
            s += x;
        }
        
        int[] res = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            res[i] = s.charAt(i) - '0';
        }
        
        return res;
    }
}