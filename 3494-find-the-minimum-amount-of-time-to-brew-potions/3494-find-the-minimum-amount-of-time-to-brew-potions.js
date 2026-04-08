var minTime = function(wizard, potions) {
    let n = wizard.length;
    let m = potions.length;

    let prev = new Array(n).fill(0);

    prev[0] = potions[0] * wizard[0];

    for (let i = 1; i < n; i++) {
        prev[i] = prev[i - 1] + potions[0] * wizard[i];
    }

    for (let i = 1; i < m; i++) {
        let timetaken = new Array(n).fill(0);
        let presum = new Array(n).fill(0);

        let maxtimetostart = prev[0];

        for (let j = 0; j < n; j++) {
            let time = potions[i] * wizard[j];

            timetaken[j] = time;
            presum[j] = j === 0 ? time : presum[j - 1] + time;

            if (j > 0) {
                maxtimetostart = Math.max(maxtimetostart, prev[j] - presum[j - 1]);
            }
        }

        prev[0] = maxtimetostart + timetaken[0];

        for (let j = 1; j < n; j++) {
            prev[j] = prev[j - 1] + timetaken[j];
        }
    }

    return prev[n - 1];
};