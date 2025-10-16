
    class Solution {
    public String truncateSentence(String s, int k) {
        StringBuilder sb=new StringBuilder();
        String[] str=s.split(" ");
        int i=0;

        for(String st : str){
            if(i==k){
                break;
            }
            sb.append(st + " ");
            i++;
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
    }
        
    

