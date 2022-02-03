package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_16953_AtoB_실버1 {
    static long A, B, cnt = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        while(B != A) {
            if(B < A)  {
                cnt = -1;
                break;
            }
            String str = String.valueOf(B);
            if(str.charAt(str.length()-1) != '1' && B % 2 != 0) {
                cnt = -1;
                break;
            }
            if(B % 2 == 0) B /= 2;
            else B  /= 10;
            cnt++;
        }
        System.out.print(cnt);
    }
}