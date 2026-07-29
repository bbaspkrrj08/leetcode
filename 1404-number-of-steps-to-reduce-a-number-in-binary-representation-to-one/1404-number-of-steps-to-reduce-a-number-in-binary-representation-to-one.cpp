class Solution {
public:
    void addOne(string &s){
        bool change = false;
        for(int i = s.length()-1; i >= 0 ; i--){
            if(s[i] == '1') s[i] = '0';
            else {
                s[i] = '1';
                change = true;
                break;
            }
        }
        if(change == false)    s = '1' + s;
    }
    int numSteps(string s) {
        int ans = 0;
        while(s != "1"){
            if(s[s.length()-1] == '1')    addOne(s);
            else    s.pop_back();
            ans++;
        }
        return ans;
    }
};