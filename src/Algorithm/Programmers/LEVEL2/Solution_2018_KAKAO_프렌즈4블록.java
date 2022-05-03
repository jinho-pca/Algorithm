package Algorithm.Programmers.LEVEL2;

import java.util.*;

public class Solution_2018_KAKAO_프렌즈4블록 {
    static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "r=" + r +
                    ", c=" + c +
                    '}';
        }

        @Override
        public boolean equals(Object obj) {
            if(obj instanceof Point) {
                Point tmp = (Point) obj;
                return r == tmp.r && c == tmp.c;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r,c);
        }
    }
    static HashSet<Point> set = new HashSet<>();
    static boolean possible = true;
    static int cnt = 0;
    static char[][] map;
    public static void main(String[] args) {
        int m = 4;
        int n = 5;
        String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
        System.out.println(solution(m, n, board));
    } // end of main

    public static int solution(int m, int n, String[] board) {
        map = new char[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                String tmp = board[i];
                map[i][j] = tmp.charAt(j);
            }
        }

//        System.out.println("이동전");
//        for (int i = 0; i < map.length; i++) {
//            System.out.println(Arrays.toString(map[i]));
//        }
//        System.out.println();


        while(true) {
            if(!possibleNext()) break;
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if(check(i, j)) {
                        pushSet(i, j);
                    }
                }
            }
            changeToZ();
            cnt+= set.size();
            set.clear();
            map = move(map);
        }

//        System.out.println("이동후");
//        for (int i = 0; i < map.length; i++) {
//            System.out.println(Arrays.toString(map[i]));
//        }
//        System.out.println();

        return cnt;
    }

    private static char[][] move(char[][] map) { // 블록 삭제 후 중력 적용
        int m = map.length;
        int n = map[0].length;
        char[][] resultMap = new char[m][n];
        for (int i = 0; i < m; i++) { // 초기화
            for (int j = 0; j < n; j++) {
                resultMap[i][j] = 'z';
            }
        }

        // 큐를 만들어서 배열을 열별로 삽입하고 꺼내면서 0이면 새로운 배열에 넣지 않는 식으로 구현
        Queue<Character> queue = new LinkedList<>();
        for(int i = 0; i < n; i++) { // 열부터 탐색
            for(int j = m-1; j >= 0; j--) {
                if(map[j][i] != 'z') { // 삭제되지 않았다면
                    queue.offer(map[j][i]);
                }
            }
            // 하나의 열을 큐에 담았다면 새로운 배열에 복사하기
            int rIdx = m-1;
            while(!queue.isEmpty()) {
                char tmp = queue.poll();
                resultMap[rIdx--][i] = tmp;
            }
        }
        return resultMap;
    }
    private static boolean check(int r, int c) { // 삭제가능한지 체크
        if(map[r][c] != 'z' && map[r][c] == map[r][c+1] && map[r][c] == map[r+1][c] && map[r][c] == map[r+1][c+1]) {
            return true;
        }
        return false;
    }
    private static void pushSet(int r, int c) { // set에 추가 및 배열 값 변경
        set.add(new Point(r, c));
        set.add(new Point(r, c+1));
        set.add(new Point(r+1, c));
        set.add(new Point(r+1, c+1));
        return;
    }
    private static void changeToZ() {
        for(Point c : set) {
            map[c.r][c.c] = 'z';
        }
    }
    private static boolean possibleNext() {
        for(int i = 0; i < map.length-1; i++) {
            for(int j = 0; j < map[i].length-1; j++) {
                if(check(i, j)) { // 하나라도 삭제할 것이 존재한다면 true 리턴
                    return true;
                }
            }
        }
        return false;
    }
}
