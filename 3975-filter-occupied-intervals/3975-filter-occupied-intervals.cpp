class Solution {
public:
    vector<vector<int>> filterOccupiedIntervals(vector<vector<int>>& o, int fs, int fe) {
        sort(o.begin(),o.end());
        vector<vector<int>> on;
        if(o.size() == 0) return on;
        on.push_back(o[0]);
        int j = 0;
        for(int i = 1; i < o.size() ;i++){
            int u = o[i][0], v = o[i][1];
            int u1 = on[j][0], v1 = on[j][1];
            if(((u1 <= u) && ((u) <= (v1+1)))){
                on[j][0] = min(u1, u);
                on[j][1] = max(v1,v);
            }
            else{
                on.push_back(o[i]);
                j++;
            }
        }
        for(auto i : on){
            cout<<i[0]<<" "<<i[1]<<endl;
        }
        vector<vector<int>> ans;
        for(int i = 0; i < on.size() ; i++){
            int u1 = on[i][0], v1 = on[i][1];
            if(u1 >= fs && v1 <= fe) continue;
            else if(u1 >= fs && v1 > fe && u1 <= fe) ans.push_back({fe+1, v1});
            else if(u1 < fs && v1 <= fe && v1 >= fs) ans.push_back({u1, fs-1});
            else if( u1 < fs && v1 > fe){
                ans.push_back({u1,fs-1});
                ans.push_back({fe+1,v1});
            }
            else{
                ans.push_back({u1,v1});
            }
        }
        return ans;   
    }
};