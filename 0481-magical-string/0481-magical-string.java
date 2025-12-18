class Solution {
    public int magicalString(int n) {
        if(n==0) return 0;
        if(n<=3) return 1;
        int[] s=new int[n+2];
        s[0]=1;
        s[1]=2;
        s[2]=2;
        int i=2;
        int j=3;
        int num=1;
        int ones=1;
        while(j<n){
            for(int k=0;k<s[i]&& j<n;k++){
                s[j]=num;
                if(num==1) ones++;
                j++;
            }
            num=num==1?2:1;
            i++;
        }
        return ones;
    }
}