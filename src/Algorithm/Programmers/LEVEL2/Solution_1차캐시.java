package Algorithm.Programmers.LEVEL2;

import java.util.ArrayList;

public class Solution_1차캐시 {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        ArrayList<String> cache = new ArrayList<>();

        if(cacheSize == 0) return cities.length * 5;

        for(int i = 0; i < cities.length; i++) {
            if(!cache.contains(cities[i].toLowerCase())) {
                // 캐시에 포함되어 있지 않은 경우 -> 캐시의 첫도시를 제거하고 해당 도시를 추가한다.
                if(cache.size() == cacheSize) {
                    // 캐시가 꽉 찬 경우 -> 첫 도시 제거
                    cache.remove(0);
                }
                cache.add(cities[i].toLowerCase());
                answer+= 5;
            } else {
                // 캐시에 포함되어 있는 경우 -> 캐시에서 사용된 부분을 제거하고 맨 끝에 삽입
                if(cache.size() == cacheSize) {
                    int idx = cache.indexOf(cities[i].toLowerCase());
                    cache.remove(idx);
                }
                cache.add(cities[i].toLowerCase());
                answer += 1;
            }
        }
        return answer;
    }
}
