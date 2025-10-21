class Solution {
    public boolean doesAliceWin(String s) {
        Set<Character> vowels=new HashSet<>(Arrays.asList('a','e','i','o','u'));
         int ansh=0;
        for(char ch:s.toCharArray()){
            if(vowels.contains(ch)){
                ansh++;
            }
        }
        return ansh>0;
    }
}