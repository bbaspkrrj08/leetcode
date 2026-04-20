class Solution {
public:
    int makeMax(int x){
        string s = to_string(x);
        char prevNum;
        for(int i=0;i<s.size();i++){
            if (s[i] != '9'){
                prevNum = s[i];
                break;
            }
        }
        
        for(int i=0;i<s.size();i++){
            if(s[i]==prevNum)s[i]='9';
        }
        int maxNum= stoi(s);
        return maxNum;
    }

    int makeMin(int x){
        string s = to_string(x);
        char prevNum='z';
        if(s[0]=='1'){
            for(int i=1;i<s.size();i++){
                if(s[i]!='1' && s[i]!='0'){
                    prevNum=s[i];
                    break;
                }
            }
            
            for(int i=0;i<s.size();i++){
                if(s[i]==prevNum)s[i]='0';
            }
        }
        else{
            prevNum=s[0];
            for(int i=0;i<s.size();i++){
                if(s[i]==prevNum)s[i]='1';
            }
        }
        return stoi(s);
        
    }
    int maxDiff(int num) {
        cout<<makeMax(num)<<" "<<makeMin(num);
        return makeMax(num)-makeMin(num);
    }
};