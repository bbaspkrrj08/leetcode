class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length()==0) return true;
        int j=0;
        for(char ct:t.toCharArray()){
            if(ct==s.charAt(j)){
                j++;
            }
            if(j==s.length()) return true;
        }
        return false;
    }
}