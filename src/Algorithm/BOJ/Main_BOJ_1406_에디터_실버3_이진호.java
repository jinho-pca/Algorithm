package Algorithm.BOJ;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
/*
50%에서 시간초과 -> BufferedWriter 사용 -> 성공
 */
public class Main_BOJ_1406_에디터_실버3_이진호 {
    static Stack<Character> front = new Stack<>();
    static Stack<Character> back = new Stack<>();
    static Stack<Character> result = new Stack<>();
    static int N, M, size;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String tmp = br.readLine();
        N = tmp.length();
        // front stack 에 시작 문자열 push && size 따로 저장
        for (int i = 0; i < N; i++) {
            front.push(tmp.charAt(i));
            size++;
        }
        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            String cmd = br.readLine();
            switch(cmd.charAt(0)){
                case 'L':
                    if(!front.isEmpty()) back.push(front.pop());
                    break;
                case 'D':
                    if(!back.isEmpty()) front.push(back.pop());
                    break;
                case 'B':
                    if(!front.isEmpty()) front.pop();
                    break;
                case 'P':
                    front.push(cmd.charAt(2));
                    break;
            }
        }
        while(!front.empty()){
            result.push(front.pop());
        }
        while(!result.isEmpty()){
//            System.out.print(result.pop());
            bw.write(result.pop());
        }
        while(!back.empty()){
//            System.out.print(back.pop());
            bw.write(back.pop());
        }
        br.close();
        bw.flush();
        bw.close();
    } // end of main
} // end of class
