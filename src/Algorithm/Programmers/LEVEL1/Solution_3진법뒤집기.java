package Algorithm.Programmers.LEVEL1;

public class Solution_3진법뒤집기 {
    public int solution(int n) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        if(n < 3) return n;

        while(true) {
            int r = n % 3;
            sb.append(r);
            n /= 3;
            if(n == 0) break;
        }
        String result = sb.toString();
        System.out.println(result);
        for(int i = 0; i < result.length(); i++) {
            if(result.charAt(i) == '0') continue;
            else answer+= (result.charAt(i) - '0') * Math.pow(3, result.length()-i-1);
        }
        return answer;
    }
}
