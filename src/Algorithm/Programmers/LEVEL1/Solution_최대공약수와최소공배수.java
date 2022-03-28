package Algorithm.Programmers.LEVEL1;

public class Solution_최대공약수와최소공배수 {
    class Solution {
        public int[] solution(int n, int m) {
            int[] answer = new int[2];
            int gcd = gcd(n, m);
            int lcm = (n * m) / gcd;
            answer[0] = gcd;
            answer[1] = lcm;

            return answer;
        }
        public int gcd(int a, int b) {
            int num = a % b;
            if(num == 0) return b;

            return gcd(b, num);
        }
    }
}
