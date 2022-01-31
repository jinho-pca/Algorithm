package Algorithm.Programmers.LEVEL1;

public class Solution_시저암호 {
    class Solution {
        public String solution(String s, int n) {
            StringBuilder sb = new StringBuilder();
            char[] tmp = new char[s.length()];
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i)>= 65 && s.charAt(i) <= 90) {
                    // 대문자인 경우
                    tmp[i] = ((int)s.charAt(i) + n) > 90 ? (char)(s.charAt(i) + n - 26) : (char)(s.charAt(i) + n);
                }else if(s.charAt(i) >= 97) {
                    // 소문자인 경우
                    tmp[i] = ((int)s.charAt(i) + n) > 122 ? (char)(s.charAt(i) + n - 26) : (char)(s.charAt(i) + n);
                } else tmp[i] = s.charAt(i);
            }

            return String.valueOf(tmp);
        }
    }
}
