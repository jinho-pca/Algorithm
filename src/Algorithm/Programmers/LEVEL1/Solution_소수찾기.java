package Algorithm.Programmers.LEVEL1;

public class Solution_소수찾기 {
    public int solution(int n) {
        int answer = 0;
        int[] numbers = new int[n+1];

        for(int i = 0; i < n+1; i++) numbers[i] = i;

        for(int i = 1; i <= n; i++) {
            if(isPrime(i)) answer++;
            else continue;
        }

        return answer;
    }
    private static boolean isPrime(int n) {
        if(n < 2) return false;
        for(int i = 2; i*i <= n; i++) {
            if(n % i == 0) return false;
        }
        return true;
    }
}
