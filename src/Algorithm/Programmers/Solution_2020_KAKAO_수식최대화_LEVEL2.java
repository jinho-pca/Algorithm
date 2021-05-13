package Algorithm.Programmers;

import java.util.*;
/*
1034(+8)
 */
public class Solution_2020_KAKAO_수식최대화_LEVEL2 {
    static char[] kind = {'*', '+', '-'};
    static char[] comb = new char[3]; //모든 연산자 조합
    static boolean[] visited = new boolean[3];
    static ArrayList<Long> nums = new ArrayList<Long>(); //주어진 숫자 담기
    static ArrayList<Character> ops = new ArrayList<Character>(); //주어진 문자 담기
    static long answer;

    public static long solution(String expression) {
        String str = "";
        for (int i = 0; i < expression.length(); i++) {
            char tmp = expression.charAt(i);
            if (tmp >= '0' && tmp <= '9') str += tmp; // 수식에서 숫자가 등장하면 str에 그대로 이어붙인다.
            else { // 수식에서 연산자가 등장하면
                nums.add(Long.parseLong(str)); // 앞에서 쌓인 수를 숫자리스트에 담는다.
                str = ""; // 연산자가 나왔으므로 초기화한다.
                ops.add(expression.charAt(i)); // 연산자리스트에 연산자를 담는다.
            }
        }
        nums.add(Long.parseLong(str)); // expression 맨 마지막은 숫자이기 때문에 마지막에 강제로 추가한다.

        dfs(0);

        return answer;
    } // end of solution
    private static void dfs(int start) {
        // * + -
        // * - +
        // + * -
        // + - *
        // - * +
        // - + *
        if (start == 3)  calc();
        else {
            for (int i = 0; i < 3; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    comb[start] = kind[i];
                    dfs(start + 1);
                    visited[i] = false;
                }
            }
        }
    } // end of dfs
    private static void calc() {
        ArrayList<Long> copyNums = new ArrayList<>(nums);
        ArrayList<Character> copyOps = new ArrayList<Character>(ops);

        for (int i = 0; i < comb.length; i++) {
            for (int j = 0; j < copyOps.size(); j++) {
                if (comb[i] == copyOps.get(j)) { // 연산자조합 차례와 연산자리스트 차례가 일치하는 경우
                    Long res = choice(copyNums.remove(j), copyNums.remove(j), comb[i]); // 연산자 기준으로 좌우 숫자 연산하기
                    copyNums.add(j, res); // 먼저 연산한 결과를 원래 위치에 넣기
                    copyOps.remove(j); // 수행한 연산자 지우기
                    j--; // 앞에서부터 진행하기때문에 그 자리부터 다시 진행해야 되므로 j 감소시킨다.
                }
            }
        }
        answer = Math.max(answer, Math.abs(copyNums.get(0))); // 위의 과정을 완료하면 copyNums엔 결과값하나만 남아있게 된다.
    } // end of clac
    public static Long choice(Long num1, Long num2, char op) {
        switch (op) {
            case '+': {
                return num1 + num2;
            }
            case '-': {
                return num1 - num2;
            }
            case '*': {
                return num1 * num2;
            }
        }
        return 0l;
    } // end of chioce
    public static void main(String[] args){
        String expression = "100-200*300-500+20";
        System.out.print(solution(expression));
    } // end of main
} // end of class
/*
테스트 1 〉	통과 (12.30ms, 53MB)
테스트 2 〉	통과 (18.47ms, 53.2MB)
테스트 3 〉	통과 (17.84ms, 54.7MB)
테스트 4 〉	통과 (16.91ms, 53.4MB)
테스트 5 〉	통과 (13.58ms, 52.9MB)
테스트 6 〉	통과 (12.46ms, 53.5MB)
테스트 7 〉	통과 (13.59ms, 52.9MB)
테스트 8 〉	통과 (14.06ms, 53.7MB)
테스트 9 〉	통과 (12.93ms, 53.2MB)
테스트 10 〉	통과 (11.47ms, 53.5MB)
테스트 11 〉	통과 (16.30ms, 52.7MB)
테스트 12 〉	통과 (13.41ms, 53.9MB)
테스트 13 〉	통과 (14.90ms, 53.8MB)
테스트 14 〉	통과 (14.01ms, 53.5MB)
테스트 15 〉	통과 (12.53ms, 53.2MB)
테스트 16 〉	통과 (12.58ms, 53.5MB)
테스트 17 〉	통과 (13.38ms, 52.9MB)
테스트 18 〉	통과 (13.23ms, 52.8MB)
테스트 19 〉	통과 (12.44ms, 53.5MB)
테스트 20 〉	통과 (12.45ms, 54.2MB)
테스트 21 〉	통과 (13.75ms, 54.9MB)
테스트 22 〉	통과 (12.98ms, 53.8MB)
테스트 23 〉	통과 (12.83ms, 53.5MB)
테스트 24 〉	통과 (13.10ms, 53.9MB)
테스트 25 〉	통과 (13.88ms, 52.7MB)
테스트 26 〉	통과 (12.82ms, 53.7MB)
테스트 27 〉	통과 (15.96ms, 54.1MB)
테스트 28 〉	통과 (14.33ms, 53.6MB)
테스트 29 〉	통과 (12.61ms, 53.9MB)
테스트 30 〉	통과 (13.99ms, 53.4MB)
 */