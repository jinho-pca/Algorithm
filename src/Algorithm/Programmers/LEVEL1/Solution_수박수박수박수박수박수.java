package Algorithm.Programmers.LEVEL1;

public class Solution_수박수박수박수박수박수 {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append("수박");
        for(int i = 1; i < (n+1)/2; i++) {
            sb.append("수박");
        }
        if(n % 2 != 0) sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}
