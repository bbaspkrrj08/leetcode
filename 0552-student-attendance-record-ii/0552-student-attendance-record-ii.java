class Solution {
public int checkRecord(int n) {
int MOD = 1_000_000_007;
long[][][] state = new long[n + 1][2][3];
    for (int ab = 0; ab < 2; ab++) {
        for (int l = 0; l < 3; l++) {
            state[n][ab][l] = 1;
        }
    }
    
    for (int i = n - 1; i >= 0; i--) {
        for (int ab = 0; ab < 2; ab++) {
            for (int l = 0; l < 3; l++) {
                long c1 = state[i + 1][ab][0];
                long c2 = 0;
                if (ab == 0) {
                    c2 = state[i + 1][1][0];
                }
                long c3 = 0;
                if (l < 2) {
                    c3 = state[i + 1][ab][l + 1];
                }
                state[i][ab][l] = ((c1 + c2) % MOD + c3) % MOD;
            }
        }
    }
    
    return (int) state[0][0][0];
}
}