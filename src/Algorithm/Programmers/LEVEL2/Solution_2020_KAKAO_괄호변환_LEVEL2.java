package Algorithm.Programmers.LEVEL2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_2020_KAKAO_괄호변환_LEVEL2 {
    static String answer = "";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String p = br.readLine();


        if(p.equals("")){
            answer = "";
        }else{
            answer = recur(p);
        }
        System.out.println(answer);
    } // end of main
    private static String recur(String p){
        int index = divide(p);
        String u = p.substring(0, index+1);
        String v = p.substring(index+1, p.length());

        if(check(u)){ // u가 올바른 문자열이면
            answer += u;
        }else{ // u가 올바른 문자열이 아니면
            answer += '(';
            if(!v.equals("")){ // v가 빈문자열이 아니면
                answer += recur(v);
                v = "";
            }
            answer += ')';
            answer += resolve(u);
        }
        if(!v.equals("")){
            recur(v);
        }
        return answer;
    } // end of recur

    private static int divide(String str){
        int cnt = 0;
        int point = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '('){
                cnt++;
            }else{
                cnt--;
            }
            if(cnt == 0){
                point = i;
                break;
            }
        }
        return point;
    } // end of divide
    public static boolean check(String u) {
        int cnt = 0;
        for (int i = 0; i < u.length(); i++) {
            if(u.charAt(i) == '('){
                cnt++;
            }else{
                cnt--;
            }
            if(cnt < 0){ // 올바르지 않은 경우
                return false;
            }
        }
        // 올바른 경우
        return true;
    } // end of check
    private static String resolve(String u){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < u.length(); i++) {
            if(u.charAt(i) == '('){
                sb.append(')');
            }else{
                sb.append('(');
            }
        }
        return sb.toString();
    } // end of resolve
} // end of class
