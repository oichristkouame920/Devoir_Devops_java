const zxcvbn = require("zxcvbn");

const password = process.argv[2];

const result = zxcvbn(password);

console.log(JSON.stringify({
    score: result.score,
    crackTime:
        result.crack_times_display
            .offline_fast_hashing_1e10_per_second
}));