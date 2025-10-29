class Solution {
    public int numberOfBeams(String[] bank) {
        int ansh=0;
        int akki=0;
        for(String s:bank){
            int aa=0;
            for(char c:s.toCharArray()){
                if(c=='1'){
                    aa+=1;
                }
            }
            if(aa>0){
                akki+=ansh*aa;
                ansh=aa;
            }
        }
        return akki;
    }
}