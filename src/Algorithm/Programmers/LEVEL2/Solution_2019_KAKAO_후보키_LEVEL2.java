package Algorithm.Programmers.LEVEL2;

import java.util.ArrayList;
import java.util.HashSet;

public class Solution_2019_KAKAO_후보키_LEVEL2 {
    static ArrayList<HashSet<String>> setlist;

    public static void main(String[] args) {
        String[][] relation = {{"100","rian","music","2"},{"200","apeach","math","2"}
                ,{"300","tube","computer","3",},{"400","con","computer","4"},
                {"500","muzi","music","3"},{"600","apeach","music","2"}};
        System.out.print(solution(relation));
    } // end of main

    public static int solution(String[][] relation){
        int answer = 0;
        boolean[] candidate = new boolean[8];
        setlist = new ArrayList<HashSet<String>>();
        ArrayList<int[]> duplicate = new ArrayList<>(); // 중복된 relation 인덱스를 저장
        int rnum = relation.length; // tuple 개수
        int cnum = relation[0].length; // attribute 개수
        for (int i = 0; i < cnum; i++) {
            HashSet<String> columset = new HashSet<>();
            for (int j = 0; j < rnum; j++) {
                int before = columset.size();
                columset.add(relation[j][i]);
                if(before == columset.size()){
                    duplicate.add(new int[] {j, i});
                }
            }
            if(rnum == columset.size()){ // 중복없는 경우
                answer++;
                candidate[i] = true; // 단일후보키 칼럼 체크
            }
            setlist.add(columset);
        }

        return answer;
    } // end of solution

} // end of class
