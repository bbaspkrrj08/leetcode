class Solution {
    public char findTheDifference(String s, String t) {
        int ansh=0;
        for(int i=0;i<t.length();i++){
            ansh=ansh+t.charAt(i);
        }
        for(int i=0;i<s.length();i++){
           ansh=ansh-s.charAt(i);
        }
        return (char)ansh;
    }
}