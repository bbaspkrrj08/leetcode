/**
 * @param {number[]} position
 * @param {number} m
 * @return {number}
 */
var maxDistance = function (position, m) {
    let sorted = position.sort((a, b) => a - b);
    let left = 1;
    let right = Math.max(...position) - sorted[0];
    let res = 0;

    while (left <= right) {
        let mid = Math.floor((left + right) / 2);
        let ballsPlaced = 1;
        let currBall = sorted[0];

        for (let i = 0; i < sorted.length; i++) {
            if (sorted[i] >= currBall + mid) {
                ballsPlaced++
                currBall = sorted[i]
            }
        }

        if (ballsPlaced >= m) {
            res = mid;
            left = mid + 1;
        }
        else {
            right = mid - 1;
        }
    }
    return res;
};