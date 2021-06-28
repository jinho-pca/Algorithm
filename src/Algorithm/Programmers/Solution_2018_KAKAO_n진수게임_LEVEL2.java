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