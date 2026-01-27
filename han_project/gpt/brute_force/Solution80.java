package brute_force;

import java.util.*;

public class Solution80 {
    static int N;
    static Map<String, Integer> courseMap = new HashMap<>();
    static Map<Integer, Integer> countMap = new HashMap<>();
    static List<String> answer = new ArrayList<>();

    public String[] solution(String[] orders, int[] course) {
        for (int c : course) {
            N = c;
            countMap.put(c, 0);
            for (String order : orders) {
                dfs(0, order, new StringBuilder());
            }
        }

        courseMap.entrySet().stream()
            .sorted((e1, e2) -> e1.getKey().compareTo(e2.getKey()))
            .sorted((e1, e2) -> e2.getValue() - e1.getValue())
            .forEach(map -> {
                // System.out.println("[DEBUG]: Key-" + map.getKey() + ", Value-" + map.getValue());
                for (int c : course) {
                    if (map.getKey().length() == c && map.getValue() > 1 && map.getValue() >= countMap.get(c)) {
                        countMap.put(c, map.getValue());
                        answer.add(map.getKey());
                    }
                }
            });
        
        return answer.stream().sorted().map(String::valueOf).toArray(String[]::new);
    }

    private static void dfs(int idx, String order, StringBuilder target) {
        if (target.length() == N) {
            String key = "";
            char[] targets = target.toString().toCharArray();
            Arrays.sort(targets);
            for (char c : targets) {
                key += c;
            }
            courseMap.put(key, courseMap.getOrDefault(key, 0) + 1);
        }

        for (int i = idx; i < order.length(); i++) {
            target.append(String.valueOf(order.charAt(i)));
            dfs(i + 1, order, target);
            target.deleteCharAt(target.length()-1);
        }
    }

    public static void main(String[] args) {
        Solution80 s80 = new Solution80();
        // String[] orders1 = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        // int[] course1 = {2,3,4};
        // String[] result1 = s80.solution(orders1, course1);
        // System.out.println(Arrays.toString(result1)); // ["AC", "ACDE", "BCFG", "CDE"]

        // s80 = new Solution80();
        // String[] orders2 = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
        // int[] course2 = {2,3,5};
        // String[] result2 = s80.solution(orders2, course2);
        // System.out.println(Arrays.toString(result2)); // ["ACD", "AD", "ADE", "CD", "XYZ"]

        s80 = new Solution80();
        String[] orders3 = {"XYZ", "XWY", "WXA"};
        int[] course3 = {2,3,4};
        String[] result3 = s80.solution(orders3, course3);
        System.out.println(Arrays.toString(result3)); // ["WX", "XY"]
    }
}
