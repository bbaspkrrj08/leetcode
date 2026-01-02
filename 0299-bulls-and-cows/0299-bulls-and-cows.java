class Solution{
    public String getHint(String secret,String guess){
        int bulls=0;
        int cows=0;
        HashMap<Character,Integer> count=new HashMap<>();
        for(char x:secret.toCharArray())
            count.put(x,count.getOrDefault(x,0)+1);
        for(int i=0;i<guess.length();i++){
            if(guess.charAt(i)==secret.charAt(i)){
                bulls++;
                count.put(secret.charAt(i),count.get(secret.charAt(i))-1);
            }
        }
        for(int i=0;i<guess.length();i++){
            char ch=guess.charAt(i);
            if(ch!=secret.charAt(i)&&count.getOrDefault(ch,0)>0){
                cows++;
                count.put(ch,count.get(ch)-1);
            }
        }
        return bulls+"A"+cows+"B";
    }
}
