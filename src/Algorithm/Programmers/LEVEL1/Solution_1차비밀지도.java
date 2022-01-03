package Algorithm.Programmers.LEVEL1;

public class Solution_1차비밀지도 {
    class Solution {
        public String[] solution(int n, int[] arr1, int[] arr2) {
            StringBuilder sb = new StringBuilder();
            String[] answer = new String[n];
            for(int i = 0; i < n; i++) {
                int tmp = arr1[i] | arr2[i];
                String res = Integer.toBinaryString(tmp);
                if(res.length() < n) {
                    int depth = n - res.length();
                    for (int k = 0; k < depth; k++) {
                        res = "0" + res;
                    }
                }
                answer[i] = res;
            }
            for(int i = 0; i < n; i++) {
                char[] tmp = new char[n];
                for(int j = 0; j < n; j++) {
                    if(answer[i].charAt(j) == '1') {
                        tmp[j] = '#';
                    } else tmp[j] = ' ';
                }
                answer[i] = String.valueOf(tmp);
            }

            return answer;
        }
    }
}
