package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
/*
시간 초과
 */
public class Main_BOJ_5052_전화번호목록_골드4_시간초과 {
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
                if(!check(i)){
                    result = "NO";
                    break;
                }else{
                    continue;
                }
            }
            if(!result.equals("NO")){
                sb.append("YES").append("\n");
            }

            sb.append(result).append("\n");
        } // end of for tc
        System.out.print(sb);
    } // end of main
    private static boolean check(int a){
        String tmp = list.get(a);
        for (int i = 0; i < list.size(); i++) {
            if(i == a) continue;
            if(list.get(i).contains(tmp) || tmp.contains(list.get(i))){
                return false;
            }
        }
        return true;
    }
} // end of class
