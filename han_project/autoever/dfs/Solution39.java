package dfs;

import java.util.ArrayList;
import java.util.List;

public class Solution39 {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, new ArrayList<>(), 0);
        return answer;
    }
    private void dfs(int[] numbers, int target, List<Integer> list, int idx) {
        if (list.size() == numbers.length) {
            if (list.stream().mapToInt(Integer::intValue).sum() == target) answer++;
            return;
        }
        list.add(numbers[idx]);
        dfs(numbers, target, list, idx + 1);
        list.remove(list.size()-1);

        list.add(-numbers[idx]);
        dfs(numbers, target, list, idx + 1);
        list.remove(list.size()-1);
    }
    public static void main(String[] args) {
        Solution39 solution = new Solution39();
        System.out.println(solution.solution(new int[] {1, 1, 1, 1, 1}, 3));
    }
}
