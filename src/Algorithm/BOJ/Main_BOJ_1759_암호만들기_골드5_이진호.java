package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_1759_암호만들기_골드5_이진호 {
    private static int L;
    private static int C;
    private static char[] str;
    private static boolean[] visited;
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        str = new char[C];
        visited = new boolean[C];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < C; i++) {
            str[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(str);

        make(0, 0);
        System.out.println(sb);
    } // end of main

    private static void make(int start, int cnt){
        if(cnt == L){
            int consonant = 0, vowel = 0;
            for (int i = 0; i < C; i++) {
                if(visited[i]){
                    sb.append(str[i]);
                    if(str[i] == 'a' || str[i] == 'e' || str[i] == 'i' || str[i] == 'o' || str[i] == 'u'){
                        vowel++;
                    }else{
                        consonant++;
                    }
                }
            }
            if(consonant >= 2 && vowel >= 1){
                sb.append("\n");
                return;
            }else{
                sb.delete(sb.length()-L, sb.length());
            }
        }
        for (int i = start; i < C; i++) {
            visited[i] = true;
            make(i+1, cnt+1);
            visited[i] = false;
        }
    } // end of comb
} // end of class
