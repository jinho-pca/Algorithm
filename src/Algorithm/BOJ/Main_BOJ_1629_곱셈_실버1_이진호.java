package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1629_곱셈_실버1_이진호 {
    static long A, B, C, result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        result = A % C;
        result = divide(result, B);
        System.out.print(result);
    } // end of main
    private static long divide(long x, long y){
        long tmp;
        if(y == 0) return 1;
        if(y % 2 == 1){
            return divide(x, y-1) * x % C;
        }else{
            tmp = divide(x, y/2);
            return tmp * tmp % C;
        }
    } // end of devide
} // end of class
