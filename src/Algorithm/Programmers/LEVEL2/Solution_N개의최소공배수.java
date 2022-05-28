package Algorithm.Programmers.LEVEL2;

public class Solution_N개의최소공배수 {
    public int solution(int[] arr) {
        int answer = 0;
        int tmp = arr[0];
        for(int i = 1; i < arr.length; i++) {
            int mul = arr[i] * tmp;
            tmp = mul / gcd(tmp, arr[i]);
        }
        return tmp;
    }
    private static int gcd(int a, int b) {
        int tmp = a % b;
        if(tmp == 0) return b;
        return gcd(b, a % b);
    }
}
