class Solution {
public:
    bool checkGoodInteger(int n) {
        long long sq = 0, sum = 0;

        while (n) {
            int mod = n % 10;
            sq += mod * mod;
            sum += mod;
            n /= 10;
        }
        return sq - sum >= 50;
    }
};