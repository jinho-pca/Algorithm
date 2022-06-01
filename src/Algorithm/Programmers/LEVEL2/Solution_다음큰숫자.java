package Algorithm.Programmers.LEVEL2;

public class Solution_다음큰숫자 {
    public int solution(int n) {
        int cnt = Integer.bitCount(n);
        for(int i = n+1; ; i++) {
            if(Integer.bitCount(i) == cnt) {
                return i;
            }
        }
    }
}
