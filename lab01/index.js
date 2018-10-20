const readline = require('readline').createInterface({
    input: process.stdin,
    output: process.stdout
})
const fibonacci_values = [];
fibonacci_values.push(1);
fibonacci_values.push(1);

let maxN = 1;

function fibonacci(n) {
    if (maxN < n) {
        fibonacci_values.push(fibonacci(n - 1) + fibonacci(n - 2));
        maxN = n;
    }

    return fibonacci_values[n];
}

readline.question('', (value) => {
    const n = parseInt(value, 10)
    console.log(fibonacci(n));
    readline.close()
});