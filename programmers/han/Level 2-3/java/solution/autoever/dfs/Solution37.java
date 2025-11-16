package solution.autoever.dfs;

/**
 * 37. 네트워크
 * 알고리즘 유형: 깊이 우선 탐색(DFS)
 */
public class Solution37 {
    boolean[] memo;
    /**
     * @Day2
     * @param n
     * @param computers
     * @return
     */
    public int solution(int n, int[][] computers) {
        int answer = 0;
        memo = new boolean[computers.length];
        for (int i=0; i < n; i++) {
            if (!memo[i]){
                dfs(i, computers);
                answer += 1;
            }
        }
        System.out.println(answer);
        return answer;
    }

    private void dfs(int i, int[][] computers) {
        memo[i] = true;
        for (int j = 0; j < computers.length; j++) {
            if (!memo[j] && computers[i][j] == 1){
                dfs(j, computers);
            }
        }
    }
    public static void main(String[] args) {
        Solution37 s37 = new Solution37();
        s37.solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}});
    }
}











