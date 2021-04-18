package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/*
540ms
 */
public class Main_BOJ_5052_전화번호목록_골드4_이진호 {
    static int num, count;
    static String result = "";
    static ArrayList<String> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            num = Integer.parseInt(br.readLine());
            result = "";
            list = new ArrayList<>();
            for (int i = 0; i < num; i++) {
                String tmp = br.readLine();
                list.add(tmp);
            }

            Collections.sort(list);
            for (int i = 1; i < list.size(); i++) {
                if(list.get(i).startsWith(list.get(i-1))){
                    result = "NO";
                    break;
                }
            }

            if(!result.equals("NO")){
                result = "YES";
            }
            sb.append(result).append("\n");
        } // end of for tc
        System.out.print(sb);
    } // end of main
} // end of class
