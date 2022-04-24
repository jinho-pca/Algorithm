package Algorithm.Programmers.LEVEL2;

public class Solution_피보나치수 {
    static int[] dp = new int[100001];
    public int solution(int n) {
        dp[0] = 0;
        dp[1] = 1;
        return fibonacci(n);
    }
    private static int fibonacci(int n) {
        if(dp[n] != 0 || n <= 1) {
            return dp[n];
        }
        return dp[n] = (fibonacci(n-1) + fibonacci(n-2)) % 1234567;
    }
}
