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
                dfs(clothesMap, list, keyList, idx + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}
