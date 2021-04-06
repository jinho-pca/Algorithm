package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_5430_AC_실버2_이진호 {
    static String p,str;
    static int TC, n;
    static int[] arr;
    static int cnt; // D연산 개수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        TC = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= TC; testCase++) {
            cnt = 0;
            p = br.readLine();
            n = Integer.parseInt(br.readLine());
            str = br.readLine();

            for (int i = 0; i < p.length(); i++) {
                if(p.charAt(i) == 'D'){
                    cnt++;
                }
            }

            if(str.equals("[]")){ // 빈배열일때
                if(cnt >= 1){
                    sb.append("error").append("\n");
                    continue;
                }else{
                    sb.append("[").append("]").append("\n");
                    continue;
                }
            }

            str = str.substring(1, str.length()-1);
            arr = new int[n];
            StringTokenizer st = new StringTokenizer(str, ",");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            if(cnt > n){
                sb.append("error").append("\n");
                continue;
            }
            if(cnt == n){
                sb.append("[").append("]").append("\n");
                continue;
            }

            int start = 0;
            int end = arr.length - 1;
            int change = 0;
            for (int i = 0; i < p.length(); i++) {
                if(p.charAt(i) == 'R'){
                    int trash = start;
                    start = end;
                    end = trash;
                    change++;
                }else if(change % 2 == 0){
                    start++;
                }else{
                    start--;
                }
            }
            sb.append("[");
            if(start <= end){
                for (int i = start; i <= end; i++) {
                    sb.append(arr[i]).append(',');
                }
                sb.setLength(sb.length() - 1);
            }else{
                for (int i = start; i >= end ; i--) {
                    sb.append(arr[i]).append(',');
                }
                sb.setLength(sb.length() - 1);
            }
            sb.append("]").append("\n");

        } // end of for testCase
        System.out.print(sb);
    } // end of main
} // end of class
