package solution;

import java.util.*;

/**
 * 64. 소수 찾기
 * 알고리즘 유형: 완전탐색, 백트래킹, 소수 판별
 */
public class Solution64 {
    /**
     * @Day 1
     */
    public int solution(String numbers) {
        Set<Integer> numSet = new HashSet<>();
        boolean[] memo = new boolean[numbers.length()];
        String currentStr = "";

        dfs(numSet, memo, currentStr, numbers);
        return (int)numSet.stream().filter(this::checkPrime).count();
    }

    private void dfs(Set<Integer> numSet, boolean[] memo, String currentStr, String numbers) {
        if (currentStr != "") {
            numSet.add(Integer.valueOf(currentStr));
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!memo[i]){
                memo[i] = true;
                dfs(numSet, memo, currentStr + numbers.substring(i, i + 1), numbers);
                memo[i] = false;
            }
        }
    }

    private boolean checkPrime(int value) {
        if (value < 2) return false; 
        for (int i = 2; i <= Math.sqrt(value); i++) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution64 s64 = new Solution64();
        System.out.println(s64.solution("17"));
    }
}
