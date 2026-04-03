package implementation;

import java.util.*;

/**
 * PROGRAMMERS
 * 의상
 */
public class Solution68 {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, List<String>> clothesMap = new HashMap<>();
        for (String[] c : clothes) {
            clothesMap.computeIfAbsent(c[1], k -> new ArrayList<>()).add(c[0]);
        }

        for (String k : clothesMap.keySet()) {
            answer *= clothesMap.get(k).size() + 1;
        }

        return answer - 1;
    }

    public StringBuilder sb = new StringBuilder();
    public int answer = 0;
    public int solution2(String[][] clothes) {
        Map<String, List<String>> clothesMap = new HashMap<>();
        Map<String, Boolean> stateMap = new HashMap<>();
        for (String[] c : clothes) {
            clothesMap.computeIfAbsent(c[1], k -> new ArrayList<>()).add(c[0]);
        }
        List<String> keyList = new ArrayList<>();
        for (String k : clothesMap.keySet())
            keyList.add(k);

        dfs(clothesMap, new ArrayList<>(), keyList, 0);
        System.out.println(sb.toString());
        return answer;
    }

    private void dfs(Map<String, List<String>> clothesMap, List<String[]> list, List<String> keyList, int idx) {
        if (list.size() > 0) {
            Set<String> valid = new HashSet<>();
            boolean isCheck = true;
            for (String[] info : list) {
                if (!valid.add(info[0])) {
                    isCheck = false;
                    break;
                }
            }
            if (isCheck) {
                answer++;
                list.forEach(info -> sb.append(info[1]).append(" "));
                sb.append("\n");
            }
        }

        for (int k = idx; k < keyList.size(); k++) {
            for (String c : clothesMap.get(keyList.get(k))) {
                list.add(new String[] { keyList.get(k), c });
                dfs(clothesMap, list, keyList, k + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    /** 의상: 종류별 최대 1벌, 1벌 이상 — depth(종류 인덱스)마다 안 입음 / 하나 입음 백트래킹 */
    public int solution3(String[][] clothes) {
        Map<String, List<String>> clothesMap = new HashMap<>();
        for (String[] c : clothes) {
            clothesMap.computeIfAbsent(c[1], k -> new ArrayList<>()).add(c[0]);
        }
        List<String> types = new ArrayList<>(clothesMap.keySet());
        int[] count = new int[1];
        dfsBacktrackClothes(clothesMap, types, 0, new ArrayList<>(), count);
        return count[0];
    }

    private void dfsBacktrackClothes(
            Map<String, List<String>> clothesMap,
            List<String> types,
            int depth,
            List<String> worn,
            int[] count) {
        if (depth == types.size()) {
            if (!worn.isEmpty()) {
                count[0]++;
            }
            return;
        }
        dfsBacktrackClothes(clothesMap, types, depth + 1, worn, count);
        for (String item : clothesMap.get(types.get(depth))) {
            worn.add(item);
            dfsBacktrackClothes(clothesMap, types, depth + 1, worn, count);
            worn.remove(worn.size() - 1);
        }
    }
}
