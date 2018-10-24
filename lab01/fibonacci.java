class Fibonacci {
    private long fibonacciValues[];
    private int lastCalculated;

    Fibonacci(int size) {
        fibonacciValues = new long[size + 1];

        fibonacciValues[0] = 1;
        fibonacciValues[1] = 1;

        lastCalculated = 1;
    }

    private long calculate(int n) {
        if (n <= lastCalculated) {
            return fibonacciValues[n];
        }

        fibonacciValues[n] =  calculate(n - 1) + calculate(n - 2);
        lastCalculated = n;

        return fibonacciValues[n];
    }

    long getN(int n) {
        return calculate(n);
    }
}

class Index {
    public static void main(String args[]) {
        Fibonacci f = new Fibonacci(10);

        for (int i = 0; i <= 10; i++) {
            System.out.print(f.getN(i) + " ");
        }
        System.out.println();
    }
}