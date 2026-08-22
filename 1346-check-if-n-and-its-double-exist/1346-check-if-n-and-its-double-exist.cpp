class Solution {
public:
    bool checkIfExist(vector<int>& arr) {
        set<int> set;

        for(int a : arr){
            if(set.count(a)){
                return true;
            }
            set.insert(a*2);
            if(a%2 == 0){
                set.insert(a/2);
            }
        }

        return false;
    }
};