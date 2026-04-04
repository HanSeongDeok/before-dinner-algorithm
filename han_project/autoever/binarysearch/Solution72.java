package binarysearch;

import java.util.*;

/**
 * PROGRAMMERS
 * 72. 순위 검색 (카카오)
 * 알고리즘 유형: 해시 + 이분 탐색
 *
 * 지원자 1명당 조건 4칸을 각각 실제값 또는 "-"로 둔 2^4개 키에 점수를 넣고,
 * 쿼리 키로 리스트를 조회한 뒤 정렬된 점수에서 하한 이분 탐색으로 인원 수를 센다.
 */
public class Solution72 {

    private final Map<String, List<Integer>> byKey = new HashMap<>();

    public int[] solution(String[] info, String[] query) {
        for (String line : info) {
            String[] parts = line.split(" ");
            String[] four = Arrays.copyOf(parts, 4);
            int score = Integer.parseInt(parts[4]);
            List<String> keys = new ArrayList<>();
            buildAllKeys(four, 0, new StringBuilder(), keys); // 모든 조합의 key 생성
            for (String key : keys) {
                byKey.computeIfAbsent(key, k -> new ArrayList<>()).add(score);
            }
        }
        for (List<Integer> scores : byKey.values()) {
            Collections.sort(scores);
        }

        int[] answer = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            String normalized = query[i].replace(" and ", " ");
            String[] parts = normalized.split(" ");
            int minScore = Integer.parseInt(parts[4]);
            String key = parts[0] + " " + parts[1] + " " + parts[2] + " " + parts[3];
            answer[i] = countAtLeast(key, minScore);
        }
        return answer;
    }

    private static void buildAllKeys(
            String[] four, int idx, StringBuilder sb, List<String> keys) {
        if (idx == 4) {
            keys.add(sb.toString().trim());
            return;
        }

        int len = sb.length();

        // 해당 위치의 값 사용
        sb.append(four[idx]);
        sb.append(' ');
        buildAllKeys(four, idx + 1, sb, keys);
        sb.setLength(len);

        // '-' 사용
        sb.append('-');
        sb.append(' ');
        buildAllKeys(four, idx + 1, sb, keys);
        sb.setLength(len);
    }

    private int countAtLeast(String key, int minScore) {
        List<Integer> list = byKey.get(key);
        if (list == null) return 0;
        int count = 0;
        for (int score : list) {
            if (score >= minScore) {
                count++;
            }
        }
        return count;
    }
}
