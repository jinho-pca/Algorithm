package Algorithm.BOJ;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
/*
ArrayList -> 시간초과
ArrayList, size()호출시간 고려 size 따로 저장 -> 5%에서 시간초과
 */
public class Main_BOJ_1406_에디터_실버3_이진호_시간초과 {
    static int M, size; // 1 <= M <= 500000
    static ArrayList<Character> str = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String tmp = br.readLine();
        for (int i = 0; i < tmp.length(); i++) {
            str.add(tmp.charAt(i));
            size++;
        }
        int cursor = str.size(); // 커서 위치
        M = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        for (int i = 0; i < M; i++) {
            String cmd = br.readLine();
            switch(cmd.charAt(0)){
                // 커서를 왼쪽으로 한 칸 옮김 (커서가 문장의 맨 앞이면 무시됨)
                case 'L':
                    cursor = cursor > 0 ? cursor - 1 : 0;
                    break;
                // 커서를 오른쪽으로 한 칸 옮김 (커서가 문장의 맨 뒤이면 무시됨)
                case 'D':
                    cursor = cursor < size ? cursor + 1 : size;
                    break;
                // 커서 왼쪽에 있는 문자를 삭제함 (커서가 문장의 맨 앞이면 무시됨)
                case 'B':
                    if(cursor == 0) break;
                    else {
                        str.remove(--cursor);
                        size--;
                    }
                    break;
                // $라는 문자를 커서 왼쪽에 추가함
                case 'P':
                    if(cursor == 0) str.add(cursor++, cmd.charAt(2));
                    else str.add(cursor++, cmd.charAt(2));
                    size++;
                    break;
            }
        }
        for (int i = 0; i < size; i++) {
            bw.write(str.get(i));
        }
        br.close();
        bw.flush();
        bw.close();
    } // end of main
} // end of class
