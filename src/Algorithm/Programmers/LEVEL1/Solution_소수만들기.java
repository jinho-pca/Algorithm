package Algorithm.Programmers.LEVEL1;

public class Solution_소수만들기 {
    static int[] numbers = new int[3];
    static int result;
    public int solution(int[] nums) {
        comb(0,0, nums);
        return result;
    }
    private static boolean isPrime(int n) {
        if(n <= 1) return false;
        for(int i = 2; i*i <= n; i++) {
            if(n % i == 0) return false;
        }
        return true;
    }
    private static void comb(int cnt, int start, int[] nums) {
        if(cnt == 3) {
            int sum = numbers[0] + numbers[1] + numbers[2];
            if(isPrime(sum)) {
                result++;
            }
            return;
        }
        for(int i = start; i < nums.length; i++) {
            numbers[cnt] = nums[i];
            comb(cnt+1, i+1, nums);
        }
    }
}
