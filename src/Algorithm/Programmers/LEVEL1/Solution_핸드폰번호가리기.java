package Algorithm.Programmers.LEVEL1;

public class Solution_핸드폰번호가리기 {
    public String solution(String phone_number) {
        int len = phone_number.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len-4; i++) {
            sb.append("*");
        }
        sb.append(phone_number.substring(len-4, len));
        return sb.toString();
    }
}
