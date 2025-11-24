package dfs_bfs;

/**
 * 37. 네트워크
 */
public class Solution37 {
    int answer = 0;
    public int solution(int n, int[][] computers) {
        boolean[] memo = new boolean[n];
        for (int i =0; i < computers.length; i++) {
            if (!memo[i]) {
                dfs(i, computers, memo);
                answer += 1;
            }
        }
        System.out.println(answer);
        return answer;
    }
    private void dfs(int idx, int[][] computers, boolean[] memo) {
        memo[idx] = true;
        for (int i=0; i < computers[idx].length; i++) {
            if (!memo[i] && computers[idx][i] == 1) {
                dfs(i, computers, memo);
            }
        }
    }
    public static void main(String[] args) {
        Solution37 s37 = new Solution37();
        s37.solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}});
    }
}
