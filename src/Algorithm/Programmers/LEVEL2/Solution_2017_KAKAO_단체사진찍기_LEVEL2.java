package Algorithm.Programmers.LEVEL2;

public class Solution_2017_KAKAO_단체사진찍기_LEVEL2 {
    public static void main(String[] args) {
        String[] data = {"N~F=0", "R~T>2"};
        System.out.print(solution(2, data));
    } // end of main
    static char[] kakao = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    static int[] numbers; // 순열로 서있는 위치저장할 배열
    static boolean[] visited; // 순열 중복 체크 배열
    static int cnt;
    private static int solution(int n, String[] data) {
        int answer = 0;
        numbers = new int[8];
        visited = new boolean[8];
        cnt = 0;

        perm(0, data);
        return answer = cnt;
    }
    private static void perm(int index, String[] data){
        if(index == 8){
            if(check(data)) cnt++;
            return;
        }

        for(int i = 0; i < 8; i++){
            if(!visited[i]){
                visited[i] = true;
                numbers[index] = i;
                perm(index + 1, data);
                visited[i] = false;
            }
        }
    } // end of perm
    private static boolean check(String[] data){
        for(int i = 0; i < data.length; i++){
            int x = numbers[find(data[i].charAt(0))];
            int y = numbers[find(data[i].charAt(2))];
            char op = data[i].charAt(3);
            int v = data[i].charAt(4) - '0';
            switch(op){
                case '=':
                    if(Math.abs(x - y) - 1 != v) return false;
                    break;
                case '<':
                    if(Math.abs(x - y) - 1 >= v) return false;
                    break;
                case '>':
                    if(Math.abs(x - y) - 1 <= v) return false;
                    break;
            }
        }
        return true;
    } // end of check
    private static int find(char c){
        int result = -1;
        for(int i = 0; i < 8; i++){
            if(kakao[i] == c){
                result = i;
                break;
            }
        }
        return result;
    }
} // end of class

/*
1134 (+10)
제출 코드

class Solution {
    static char[] kakao = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    static int[] numbers; // 순열로 서있는 위치저장할 배열
    static boolean[] visited; // 순열 중복 체크 배열
    static int cnt;

    public int solution(int n, String[] data) {
        int answer = 0;
        numbers = new int[8];
        visited = new boolean[8];
        cnt = 0;

        perm(0, data);
        return answer = cnt;
    }
    private static void perm(int index, String[] data){
        if(index == 8){
            if(check(data)) cnt++;
            return;
        }

        for(int i = 0; i < 8; i++){
            if(!visited[i]){
                visited[i] = true;
                numbers[index] = i;
                perm(index + 1, data);
                visited[i] = false;
            }
        }
    } // end of perm
    private static boolean check(String[] data){
        for(int i = 0; i < data.length; i++){
            int x = numbers[find(data[i].charAt(0))];
            int y = numbers[find(data[i].charAt(2))];
            char op = data[i].charAt(3);
            int v = data[i].charAt(4) - '0';
            switch(op){
                case '=':
                    if(Math.abs(x - y) - 1 != v) return false;
                    break;
                case '<':
                    if(Math.abs(x - y) - 1 >= v) return false;
                    break;
                case '>':
                    if(Math.abs(x - y) - 1 <= v) return false;
                    break;
            }
        }
        return true;
    } // end of check
    private static int find(char c){
        int result = -1;
        for(int i = 0; i < 8; i++){
            if(kakao[i] == c){
                result = i;
                break;
            }
        }
        return result;
    }
}
 */