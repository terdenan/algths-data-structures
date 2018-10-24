class Fibonacci:
    def _quick_calc(self, n):
        if not self.fibonacci_values[n]:
            self.fibonacci_values[n] = self._quick_calc(n - 1) + self._quick_calc(n - 2)

        return self.fibonacci_values[n]

    def _slow_calc(self, n):
        if (n <= 1): return 1;

        return self._slow_calc(n - 1) + self._slow_calc(n - 2)

    def fibonacci(self, n, mode='quick'):
        self.n = n
        self.fibonacci_values = [0 for _ in range(n + 1)]

        self.fibonacci_values[0] = 1
        self.fibonacci_values[1] = 1

        if (mode == 'quick'):
            return self._quick_calc(n)
        elif (mode == 'slow'):
            return self._slow_calc(n)
        
        

if __name__ == '__main__':

    import timeit

    spended_time = timeit.timeit(
        'fibonacci.fibonacci(n, "quick")', 
        'from __main__ import Fibonacci; fibonacci = Fibonacci(); n = int(input())', 
        number=10)
    average_time = spended_time / 10

    print('In average spent {:.7f} s in 10 executions'.format(average_time))