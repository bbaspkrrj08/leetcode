class Solution {
public:
    int numOfSubarrays(vector<int>& arr) {
        int n=arr.size();
        unordered_map<int,int>mp;
        int mod=1e9+7;
        mp[0]=1;
        int sum=0;
        int ans=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(sum%2==0){
                if(mp.find(1)!=mp.end())
                ans=(ans%mod+mp[1]%mod)%mod;
                mp[0]++;            
        }else{
            if(mp.find(0)!=mp.end())
            ans=(ans%mod+mp[0]%mod)%mod;
            mp[1]++;
        }
    }
    return ans;
    }

};