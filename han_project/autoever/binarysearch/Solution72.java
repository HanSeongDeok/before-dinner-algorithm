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

    private static void buildAllKeys(String[] four, int idx, StringBuilder sb, List<String> keys) {
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


    private final Map<String, List<Integer>> map = new HashMap<>();
    /**
     * 방법1: 선형 탐색으로 풀이
     */
    public int[] solution2(String[] info, String[] query) {
        int[] answer = new int[query.length];
        
        for (String i : info) {
            String[] infos = i.split(" ");
            String[] is = Arrays.copyOfRange(infos, 0, 4);
            int score = Integer.parseInt(infos[4]);
            List<StringBuilder> keys = new ArrayList<>();
            dfs(is, new ArrayList<>(), keys, 0);
            for (StringBuilder key : keys) {
                map.computeIfAbsent(key.toString(), k -> new ArrayList<>()).add(score);
            }
        }

        int idx = 0;
        for (String q : query) {
            q = q.replaceAll(" and ", " ");
            String[] querys = q.split(" ");
            String[] qs = Arrays.copyOfRange(querys, 0, 4);
            int score = Integer.parseInt(querys[4]);
            answer[idx++] = counts(qs, score);
        }

        return answer;
    }

    private int counts(String[] qs, int score) {
        String key = qs[0] + " " + qs[1] + " " + qs[2] + " " +qs[3];
        if (!map.containsKey(key)) return 0;
        int cnt = 0;
        for (int s : map.get(key)) {
            if (s >= score) cnt++;
        }
        return cnt;
    }

    private void dfs(String[] is, List<String> targets, List<StringBuilder> list, int idx) {
        if (idx == 4) {
            StringBuilder sb = new StringBuilder();
            for (int i=0; i < targets.size(); i++) {
                if (i == targets.size()-1) {
                    sb.append(targets.get(i));
                    break;
                }
                sb.append(targets.get(i)).append(" ");
            }
            list.add(sb);
            return;
        }

        targets.add(is[idx]);
        dfs(is, targets, list, idx + 1);
        targets.remove(targets.size()-1);

        targets.add("-");
        dfs(is, targets, list, idx + 1);
        targets.remove(targets.size()-1);
    }

    public static void main(String[] args) {
        Solution72 s72 = new Solution72();
        // 예시 추가
        String[] info = {
            "java backend junior pizza 150",
            "python frontend senior chicken 210",
            "python frontend senior chicken 150",
            "cpp backend senior pizza 260",
            "java backend junior chicken 80",
            "python backend senior chicken 50"
        };

        String[] query = {
            "java and backend and junior and pizza 100",
            "python and frontend and senior and chicken 200",
            "cpp and - and senior and pizza 250",
            "- and backend and senior and - 150",
            "- and - and - and chicken 100",
            "- and - and - and - 150"
        };

        int[] result = s72.solution(info, query);
        System.out.println(Arrays.toString(result));
    }
}
