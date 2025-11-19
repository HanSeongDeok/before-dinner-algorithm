package solution.gpt.brute_force;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 74. 모의고사
 */
public class Solution74 {
    /**
     * @Day1
     * @param answers
     * @return
     */
    public int[] solution(int[] answers) {
        Map<Integer, Integer> answer = new HashMap<>();
        List<Integer> pattern1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        List<Integer> pattern2 = new ArrayList<>(Arrays.asList(2, 1, 2, 3, 2, 4, 2, 5));
        List<Integer> pattern3 = new ArrayList<>(Arrays.asList(3, 3, 1, 1, 2, 2, 4, 4, 5, 5));

        for (int i = 0; i < answers.length; i++) {
            if (pattern1.get(i % 5) == answers[i])
                answer.put(1, answer.getOrDefault(1, 0) + 1);
            if (pattern2.get(i % 8) == answers[i])
                answer.put(2, answer.getOrDefault(2, 0) + 1);
            if (pattern3.get(i % 10) == answers[i])
                answer.put(3, answer.getOrDefault(3, 0) + 1);
        }

        int maxValue = answer.values().stream().sorted(Comparator.reverseOrder()).findFirst().get();
        List<Integer> result = new ArrayList<>();
        for (int key : answer.keySet()) {
            if (answer.get(key) == maxValue) {
                result.add(key);
            }
        }

        return result.stream().sorted().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
        Solution74 s74 = new Solution74();
        // s74.solution(new int[] { 1, 2, 3, 4, 5 });
        s74.solution(new int[] { 1, 3, 2, 4, 2 });
    }
}
