public class Fibonacci {
    private static long[] fibonacciCache;

    public static void main(String[] args) {
        int fibNumberIndex = 6;
        fibonacciCache = new long[fibNumberIndex + 1];
        System.out.println(fibonacci(6));
    }

    // It should return the nth fibonacci number.
    // Method 1: recursive
//    private static long fibonacci(int n) {
//        if (n <= 1) {
//            return n;
//        }
//        return fibonacci(n - 1) + fibonacci(n - 2);
//    }

    // Method 2: memoization
    private static long fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        if (fibonacciCache[n] != 0) {
            return fibonacciCache[n];
        }
        long nthFibonacciNumber = fibonacci(n - 1) + fibonacci(n - 2);
        fibonacciCache[n] = nthFibonacciNumber;
        return nthFibonacciNumber;
    }
}
