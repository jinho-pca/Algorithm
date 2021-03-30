package Algorithm.Programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_2021_KAKAO_신규아이디추천 {
    public static void main(String[] args) throws IOException {
//        String answer = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String answer = br.readLine();

        // 1단계
        answer = answer.toLowerCase();

        // 2단계
        for (int i = 0; i < answer.length(); i++) {
            if(!(answer.charAt(i) >= 'a' && answer.charAt(i) <= 'z') && !(answer.charAt(i) >= '0' && answer.charAt(i) <= '9') && answer.charAt(i) != '-' && answer.charAt(i) != '_' && answer.charAt(i) != '.'){
                answer = answer.substring(0, i) + answer.substring(i+1, answer.length());
                i--;
            }
        }

        // 3단계
        for (int i = answer.length()-1; i >0; i--) {
            if(answer.charAt(i) == '.' && answer.charAt(i-1) == '.'){
                answer = answer.substring(0,i-1) + answer.substring(i, answer.length());
            }
        }

        // 4단계
        if(answer.charAt(0) == '.'){
            answer = answer.substring(1, answer.length());
            // 5단계
            if(answer.length() == 0){
                answer = "a";
            }
        }
        if(answer.charAt(answer.length()-1) == '.'){
            answer = answer.substring(0, answer.length()-1);
            // 5단계
            if(answer.length() == 0){
                answer = "a";
            }
        }


        // 6단계
        if(answer.length() >= 16){
            answer = answer.substring(0,15);
        }
        if(answer.charAt(answer.length()-1) == '.'){
            answer = answer.substring(0, answer.length()-1);
        }

        // 7단계
        if(answer.length() <= 2){
            while(answer.length() < 3){
                answer += answer.charAt(answer.length()-1);
            }
        }
        System.out.println(answer);

    } // end of main
}



/*
제출용 코드
import java.io.*;
import java.util.*;

class Solution {
    public String solution(String new_id) {
        String answer = new_id;

        // 1단계
        answer = answer.toLowerCase();

        // 2단계
        for (int i = 0; i < answer.length(); i++) {
            if (!(answer.charAt(i) >= 'a' && answer.charAt(i) <= 'z') && !(answer.charAt(i) >= '0' && answer.charAt(i) <= '9') && answer.charAt(i) != '-' && answer.charAt(i) != '_' && answer.charAt(i) != '.') {
                answer = answer.substring(0, i) + answer.substring(i + 1, answer.length());
                i--;
            }
        }

        // 3단계
        for (int i = answer.length() - 1; i > 0; i--) {
            if (answer.charAt(i) == '.' && answer.charAt(i - 1) == '.') {
                answer = answer.substring(0, i - 1) + answer.substring(i, answer.length());
            }
        }

        // 4단계
        if (answer.charAt(0) == '.') {
            answer = answer.substring(1, answer.length());
            // 5단계
            if (answer.length() == 0) {
                answer = "a";
            }
        }
        if (answer.charAt(answer.length() - 1) == '.') {
            answer = answer.substring(0, answer.length() - 1);
            // 5단계
            if (answer.length() == 0) {
                answer = "a";
            }
        }


        // 6단계
        if (answer.length() >= 16) {
            answer = answer.substring(0, 15);
            if (answer.charAt(answer.length() - 1) == '.') {
            answer = answer.substring(0, answer.length() - 1);
        }
        }


        // 7단계
        if (answer.length() <= 2) {
            while (answer.length() < 3) {
                answer += answer.charAt(answer.length() - 1);
            }
        }

        return answer;
    }
}
 */