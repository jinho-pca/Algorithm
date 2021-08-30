package Algorithm.Programmers;

import java.util.Arrays;

public class Solution_위클래챌린지_2주차_상호평가_1 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int[][] scores = {{100,90,98,88,65}, {50,45,99,85,77},{47,88,95,80,67},{61,57,100,80,65},{24,90,94,75,65}};
        System.out.print(solution(scores));
    } // end of main
    public static String solution(int[][] scores) {
        String answer = "";

        int length = scores.length;

        for(int i = 0; i < length; i++){
            int sum = 0;
            int[] tmp = new int[length];
            int self = scores[i][i];
            for(int j = 0; j < length; j++){
                tmp[j] = scores[j][i];
            }
            Arrays.sort(tmp);
            boolean unique = false;
            if(self == tmp[0]){ // 자기자신에게 평가한 점수가 최하점인 경우 -> 다음 값과 비교해서 유일한지 판단
                if(self == tmp[1]){ // 유일한 최하점이 아닌 경우 -> 평균에 포함한다.
                    sum = 0;
                }else{ // 유일한 최하점인 경우 -> 평균에서 제외한다.
                    sum -= self;
                    unique = true;
                }
            }else if(self == tmp[length-1]){ // 자기자신에게 평가한 점수가 최고점인 경우 -> 이전 값과 비교해서 유일한지 판단
                if(self == tmp[length-2]){ // 유일한 최고점이 아닌 경우 -> 평균에 포함한다.
                    sum = 0;
                }else{ // 유일한 최고점인 경우 -> 평균에서 제외한다.
                    sum -= self;
                    unique = true;
                }
            }
            for(int j = 0; j < length; j++){
                sum += tmp[j];
            }
            int average = 0;
            if(unique){
                average = sum / (length-1);
            }else average = sum / length;

            if(average >= 90){
                sb.append("A");
                continue;
            }else if(average >= 80){
                sb.append("B");
                continue;
            }else if(average >= 70){
                sb.append("C");
                continue;
            }else if(average >= 50){
                sb.append("D");
                continue;
            }else{
                sb.append("F");
                continue;
            }
        }
        answer = sb.toString();
        return answer;
    }
}

/*
1165(+8)
제출코드

import java.util.*;

class Solution {
    StringBuilder sb = new StringBuilder();
    public String solution(int[][] scores) {
        String answer = "";

        int length = scores.length;

        for(int i = 0; i < length; i++){
            int sum = 0;
            int[] tmp = new int[length];
            int self = scores[i][i];
            for(int j = 0; j < length; j++){
                tmp[j] = scores[j][i];
            }
            Arrays.sort(tmp);
            boolean unique = false;
            if(self == tmp[0]){ // 자기자신에게 평가한 점수가 최하점인 경우 -> 다음 값과 비교해서 유일한지 판단
                if(self == tmp[1]){ // 유일한 최하점이 아닌 경우 -> 평균에 포함한다.
                    sum = 0;
                }else{ // 유일한 최하점인 경우 -> 평균에서 제외한다.
                    sum -= self;
                    unique = true;
                }
            }else if(self == tmp[length-1]){ // 자기자신에게 평가한 점수가 최고점인 경우 -> 이전 값과 비교해서 유일한지 판단
                if(self == tmp[length-2]){ // 유일한 최고점이 아닌 경우 -> 평균에 포함한다.
                    sum = 0;
                }else{ // 유일한 최고점인 경우 -> 평균에서 제외한다.
                    sum -= self;
                    unique = true;
                }
            }
            for(int j = 0; j < length; j++){
                sum += tmp[j];
            }
            int average = 0;
            if(unique){
                average = sum / (length-1);
            }else average = sum / length;

            if(average >= 90){
                sb.append("A");
                continue;
            }else if(average >= 80){
                sb.append("B");
                continue;
            }else if(average >= 70){
                sb.append("C");
                continue;
            }else if(average >= 50){
                sb.append("D");
                continue;
            }else{
                sb.append("F");
                continue;
            }
        }
        answer = sb.toString();
        return answer;
    }
}
 */