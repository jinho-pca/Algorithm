package Algorithm.BOJ;

import java.io.*;

public class Main_BOJ_1259_팰린드롬수_브론즈1_이진호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
        StringBuilder result = new StringBuilder();
        while(true) {
            sb = new StringBuilder(br.readLine());
            if(sb.toString().equals("0")) break;
            if(sb.toString().equals(sb.reverse().toString())) result.append("yes");
            else result.append("no");
            result.append("\n");
        }
        System.out.print(result);
    }
}
