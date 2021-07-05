package Algorithm.Programmers;

public class Solution_2018_KAKAO_n진수게임_LEVEL2 {
    public static void main(String[] args) {
        System.out.print(solution(2,4,2,1));
    } // end of main
    static char[] mod = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
    private static String solution(int n, int t, int m, int p){
        String answer = "";
        StringBuilder sb = new StringBuilder();
        sb.append("0");
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < t * m; i++) {
            sb.append(convert(i, n));
        }
        for (int i = 0; i < sb.length(); i++) {
            if(result.length() == t) break;
            else if(i % m == p-1) result.append(sb.charAt(i));
        }
        return result.toString();
    } // end of solution
    private static String convert(int number, int base){
        StringBuilder tmp = new StringBuilder();
        while(number != 0){
            tmp.append(mod[number % base]);
            number /= base;
        }
        return tmp.reverse().toString();
    } // end of convert
} // end of main

/*
1111 (+10)
제출코드

import java.util.*;
class Solution {
    static char[] mod = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        sb.append("0");
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < t * m; i++) {
            sb.append(convert(i, n));
        }
        for (int i = 0; i < sb.length(); i++) {
            if(result.length() == t) break;
            else if(i % m == p-1) result.append(sb.charAt(i));
        }
        return result.toString();
    }
    private String convert(int number, int base){
        StringBuilder tmp = new StringBuilder();
        while(number != 0){
            tmp.append(mod[number % base]);
            number /= base;
        }
        return tmp.reverse().toString();
    }
}
 */
/*
테스트 1 〉	통과 (0.04ms, 52.8MB)
테스트 2 〉	통과 (0.09ms, 53.1MB)
테스트 3 〉	통과 (0.08ms, 53MB)
테스트 4 〉	통과 (0.10ms, 52.9MB)
테스트 5 〉	통과 (0.84ms, 52.1MB)
테스트 6 〉	통과 (0.79ms, 53.6MB)
테스트 7 〉	통과 (0.67ms, 52.2MB)
테스트 8 〉	통과 (0.55ms, 53.6MB)
테스트 9 〉	통과 (0.54ms, 52.7MB)
테스트 10〉  통과 (0.58ms, 52.3MB)
테스트 11〉  통과 (1.05ms, 52.8MB)
테스트 12〉  통과 (0.37ms, 52.4MB)
테스트 13〉  통과 (0.37ms, 52.6MB)
테스트 14〉  통과 (37.76ms, 63.5MB)
테스트 15〉  통과 (35.40ms, 63.7MB)
테스트 16〉  통과 (39.13ms, 63.6MB)
테스트 17〉  통과 (6.98ms, 52.9MB)
테스트 18〉  통과 (5.48ms, 53.6MB)
테스트 19〉  통과 (1.61ms, 52.1MB)
테스트 20〉  통과 (2.78ms, 53.2MB)
테스트 21〉  통과 (17.11ms, 54.6MB)
테스트 22〉  통과 (10.46ms, 53.8MB)
테스트 23〉  통과 (16.79ms, 56.7MB)
테스트 24〉  통과 (42.58ms, 59.3MB)
테스트 25〉  통과 (37.74ms, 60.1MB)
테스트 26〉  통과 (11.85ms, 55.5MB)
 */