class Solution {
public:
    long long maxSum(vector<int>& nums, int k, int mul) {
        long long ts=0;
        long long mul1 = mul;
        sort(nums.begin(), nums.end(),greater<int>());
        for(int i= 0;i < k; i++){
            if(mul1 > 0){
                ts += (nums[i]*mul1);
            }
            else{
                ts += nums[i];
            }
            mul1--;
        }
        return ts;
    }
};