package dfs_bfs;

import java.util.*;

/**
 * 33. 타겟 넘버
 */
public class Solution33 {
    List<List<Integer>> answer = new ArrayList<>();
    static int TARGET; 
    public int solution(int[] numbers, int target) {
        TARGET = target;
        dfs(new ArrayList<>(), numbers, 0);

        System.out.println(answer.size());
        return answer.size();
    }

    private void dfs(List<Integer> memo, int[] numbers, int idx) {
        if (memo.size() == numbers.length) {
            if ((int)memo.stream().mapToInt(i->i).sum() == TARGET) {
                answer.add(memo);
            }
            return;
        }
        memo.add(numbers[idx]);
        dfs(memo, numbers, idx+1);
        memo.remove(idx);

        memo.add(-numbers[idx]);
        dfs(memo, numbers, idx+1);
        memo.remove(idx);
    }
    public static void main(String[] args) {
        Solution33 s33 = new Solution33();
        s33.solution(new int[]{4, 1, 2, 1}, 2);
    }
}

