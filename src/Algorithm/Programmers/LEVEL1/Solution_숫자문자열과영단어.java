package Algorithm.Programmers.LEVEL1;

public class Solution_숫자문자열과영단어 {
    public int solution(String s) {
        int answer = 0;
        String[] alphabet = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for(int i = 0; i < 10; i++) {
            s = s.replace(alphabet[i], Integer.toString(i));
        }
        return Integer.parseInt(s);
    }
}
