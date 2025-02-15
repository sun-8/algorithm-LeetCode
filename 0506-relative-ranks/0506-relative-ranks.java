import java.util.*;

class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        int[] sCopy = new int[n];
        
        // score의 요소들을 sCopy배열에 복사
        System.arraycopy(score, 0, sCopy, 0, n);

        // 각 요소에 대한 인덱스를 map으로 저장
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            map.put(sCopy[i], i);
        }

        // sCopy 변수 오름차순 정렬
        Arrays.sort(sCopy);

        // 순위 매기기
        String[] answer = new String[n];
        for(int i=0; i<n; i++) {
            if (i == 0) {
                answer[map.get(sCopy[n-i-1])] = "Gold Medal";
            } else if (i == 1) {
                answer[map.get(sCopy[n-i-1])] = "Silver Medal";
            } else if (i == 2) {
                answer[map.get(sCopy[n-i-1])] = "Bronze Medal";
            } else {
                answer[map.get(sCopy[n-i-1])] = Integer.toString(i+1);
            }
        }

        return answer;
    }
}