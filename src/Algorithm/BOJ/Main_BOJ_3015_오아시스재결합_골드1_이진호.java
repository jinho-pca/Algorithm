package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_BOJ_3015_오아시스재결합_골드1_이진호 {
    static class People{
        int height;
        int cnt;

        public People(int height, int cnt) {
            this.height = height;
            this.cnt = cnt;
        }
    }
    static int N;
    static long result;
    static Stack<People> stack = new Stack<People>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(br.readLine());
            People people = new People(height, 1);

            while(!stack.empty() && stack.peek().height <= height){
                People tmp = stack.pop();
                result += tmp.cnt;
                if(tmp.height == height) people.cnt += tmp.cnt;
            }
            if(!stack.empty()) result++;

            stack.push(people);
        }
        System.out.print(result);
    } // end of main
} // end of class
