package Algorithm.Programmers.LEVEL2;

import java.util.Arrays;

public class Solution_월간코드챌린지시즌2_2개이하로다른비트_LEVEL2 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        long[] numbers = {2, 7};
        System.out.print(Arrays.toString(solution(numbers)));
    } // end of main
    public static long[] solution(long[] numbers){
        long[] answer = new long[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            Long x = numbers[i];
            if(x % 2 != 0) {
                String strX = Long.toBinaryString(x);
                int rightZero = strX.lastIndexOf("0");
                int firstOne = strX.indexOf("1", rightZero);
                sb.append(strX);
                if(rightZero == -1){
                    sb.insert(1, 0);
                    answer[i] = Long.parseLong(sb.toString(), 2);
                }else{
                    strX = strX.substring(0,rightZero)+"1"+
                            strX.substring(rightZero+1,firstOne)+"0"+
                            strX.substring(firstOne+1,strX.length());
                    answer[i] = Long.parseLong(strX, 2);
                }
            }else answer[i] = x + 1;
        }
        return answer;
    } // end of solution
} // end of class

/*
제출코드1
1157 (+17)
정확성: 100.0
합계: 100.0 / 100.0

class Solution {
    static StringBuilder sb;
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            Long x = numbers[i];
            if(x % 2 != 0) {
                sb = new StringBuilder();
                String strX = Long.toBinaryString(x);
                int rightZero = strX.lastIndexOf("0");
                int firstOne = strX.indexOf("1", rightZero);
                sb.append(strX);
                if(rightZero == -1){
                    sb.insert(1, 0);
                    answer[i] = Long.parseLong(sb.toString(), 2);
                }else{
                    strX = strX.substring(0,rightZero)+"1"+
                            strX.substring(rightZero+1,firstOne)+"0"+
                            strX.substring(firstOne+1,strX.length());
                    answer[i] = Long.parseLong(strX, 2);
                }
            }else answer[i] = x + 1;
        }
        return answer;
    }
}

제출코드2
정확성: 81.8
합계: 81.8 / 100.0

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            Long x = numbers[i];
            Long y = x + 1;
            while(true){
                if(Long.bitCount(x^y) <= 2)
                    break;
                else y++;
            }
            answer[i] = y;
        }
        return answer;
    }
}
*/