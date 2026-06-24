const password = process.argv[2];

const score =
    password.length >= 12 ? 4 :
    password.length >= 8 ? 3 :
    1;

console.log(JSON.stringify({
    score: score,
    crackTime: "Simulation Docker"
}));