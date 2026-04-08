var mod = 1000000007;

var countPermutations = function(complexity) {
    let first = complexity[0];

    for (let i = 1; i < complexity.length; i++) {
        if (complexity[i] <= first) {
            return 0;
        }
    }

    return fact(complexity.length - 1);
};

function fact(n) {
    let res = 1n;

    for (let i = 2n; i <= BigInt(n); i++) {
        res = (res * i) % 1000000007n;
    }

    return Number(res);
}