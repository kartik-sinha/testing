package DynamicProgramming;

import java.util.Arrays;
class GfG2 {

    // Function to calculate the nth Fibonacci number using iteration
    static int nthFibonacci(int n) {
        // Handle the edge cases
        if (n <= 1) return n;

        // Create an array to store Fibonacci numbers
        int[] dp = new int[n + 1];

        // Initialize the first two Fibonacci numbers
        dp[0] = 0;
        dp[1] = 1;

        // Fill the array iteratively
        for (int i = 2; i <= n; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        // Return the nth Fibonacci number
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;
        int result = nthFibonacci(n);
        System.out.println(result);
    }
}


class GfG {

    // Function to calculate the nth Fibonacci number using memoization
    static int nthFibonacciUtil(int n, int[] memo) {

        // Base case: if n is 0 or 1, return n
        if (n <= 1) {
            return n;
        }

        // Check if the result is already in the memo table
        if (memo[n] != -1) {
            return memo[n];
        }

        // Recursive case: calculate Fibonacci number
        // and store it in memo
        memo[n] = nthFibonacciUtil(n - 1, memo)
                + nthFibonacciUtil(n - 2, memo);

        return memo[n];
    }

    // Wrapper function that handles both initialization
    // and Fibonacci calculation
    static int nthFibonacci(int n) {

        // Create a memoization table and initialize with -1
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);

        // Call the utility function
        return nthFibonacciUtil(n, memo);
    }

    public static void main(String[] args) {
        int n = 5;
        int result = nthFibonacci(n);
        System.out.println(result);
    }
}