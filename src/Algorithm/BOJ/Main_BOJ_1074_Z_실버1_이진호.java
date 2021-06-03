package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1074_Z_실버1_이진호 {
    static int N, r, c, value;
    static int[][] map = {{0, 1}, {2, 3}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int center = (int)Math.pow(2, N-1);
        for (int i = 1; i < N; i++) { // N-1번 사분면 이동하면 2*2칸에서의 좌표 획득 가능
            if(r < center){ // 상
                if(c < center){ // 좌상(0)
                    center/=2;
                    continue;
                }else{ // 우상(1)
                    c -= center;
                    value += Math.pow(center, 2);
                }
            }else{ // 하
                if(c < center){ // 좌하(2)
                    r -= center;
                    value += 2 * Math.pow(center, 2);
                }else{ // 우하(3)
                    r -= center;
                    c -= center;
                    value += 3 * Math.pow(center, 2);
                }
            }
            center /= 2;
        }

        System.out.println(map[r][c] + value);

    } // end of main
} // end of class