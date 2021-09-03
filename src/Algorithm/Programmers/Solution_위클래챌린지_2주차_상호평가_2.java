package Algorithm.Programmers;

import java.util.Arrays;

public class Solution_위클래챌린지_2주차_상호평가_2 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int[][] scores = {{100,90,98,88,65}, {50,45,99,85,77},{47,88,95,80,67},{61,57,100,80,65},{24,90,94,75,65}};
        System.out.print(solution(scores));
    } // end of main
    public static String solution(int[][] scores) {
        int length = scores.length;

        for(int i = 0; i < length; i++){
            int self = scores[i][i];
            int sum = 0;
            boolean isMax = true;
            boolean isMin = true;
            boolean isSame = false;

            for(int j = 0; j < length; j++){
                sum += scores[j][i];
                if(self > scores[j][i]) isMax = false;
                if(self < scores[j][i]) isMin = false;
                if( i != j && self == scores[j][i]) isSame = true;
            }
            int cnt = length;
            if(!isSame && (isMax || isMin)){
                cnt--;
                sum -= self;
            }
            int average = sum / cnt;

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
        } // end of for
        return sb.toString();
    } // end of solution
} // end of class

/*
1165(+8)
제출코드

import java.util.*;

class Solution {
    public String solution(int[][] scores) {
        StringBuilder sb = new StringBuilder();
        int length = scores.length;

        for(int i = 0; i < length; i++){
            int self = scores[i][i];
            int sum = 0;
            boolean isMax = true;
            boolean isMin = true;
            boolean isSame = false;

            for(int j = 0; j < length; j++){
                sum += scores[j][i];
                if(self > scores[j][i]) isMax = false;
                if(self < scores[j][i]) isMin = false;
                if( i != j && self == scores[j][i]) isSame = true;
            }
            int cnt = length;
            if(!isSame && (isMax || isMin)){
                cnt--;
                sum -= self;
            }
            int average = sum / cnt;

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
        return sb.toString();
    }
}
 */