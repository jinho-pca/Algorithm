package Algorithm.Programmers;

public class Solution_SummerWinterCoding2018_배달_LEVEL3 {
    static int INF = 500001, cnt;

    public static void main(String[] args) {
        int[][] road = {{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}};
        System.out.print(solution(6, road, 4));
    } // end of main
    public static int solution(int N, int[][] road, int K) {
        int[][] map = new int[N][N];


        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[0].length; j++){
                if(i ==j){
                    map[i][j] = 0;
                    continue;
                }
                map[i][j] = INF;
            }
        }

        for(int i = 0; i < road.length; i++){
            // 원래 있는 길이 더 빠른 길이면 무시
            if(map[road[i][0] - 1][road[i][1] - 1] < road[i][2]) continue;
            map[road[i][0] - 1][road[i][1] - 1] = map[road[i][1] - 1][road[i][0] - 1] = road[i][2];
        }

        for(int k = 0; k < N; k++){
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(i == j) continue;
                    if(map[i][j] > map[i][k] + map[k][j]) map[i][j] = map[i][k] + map[k][j];
                }
            }
        }

        // 1번 도시에 연결된 도시들 까지의 거리가 K이하인 경우만큼 cnt 증가
        for(int i = 0; i < map[0].length; i++){
            if(map[0][i] <= K) cnt++;
        }

        return cnt;
    } // end of solution
} // end of class

/*
1180(+15)

제출코드

class Solution {
    static int INF = 500001, cnt;
    public int solution(int N, int[][] road, int K) {
        int[][] map = new int[N][N];


        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[0].length; j++){
                if(i ==j){
                    map[i][j] = 0;
                    continue;
                }
                map[i][j] = INF;
            }
        }

        for(int i = 0; i < road.length; i++){
            // 원래 있는 길이 더 빠른 길이면 무시
            if(map[road[i][0] - 1][road[i][1] - 1] < road[i][2]) continue;
            map[road[i][0] - 1][road[i][1] - 1] = map[road[i][1] - 1][road[i][0] - 1] = road[i][2];
        }

        for(int k = 0; k < N; k++){
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(i == j) continue;
                    if(map[i][j] > map[i][k] + map[k][j]) map[i][j] = map[i][k] + map[k][j];
                }
            }
        }

        // 1번 도시에 연결된 도시들 까지의 거리가 K이하인 경우만큼 cnt 증가
        for(int i = 0; i < map[0].length; i++){
            if(map[0][i] <= K) cnt++;
        }

        return cnt;
    }
}
 */
