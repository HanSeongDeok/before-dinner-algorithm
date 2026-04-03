package dfs;

public class Solution38 {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean state[] = new boolean[n];

        for (int i=0; i< computers.length; i++) {
            if (!state[i]) {
                answer++;
                dfs(i, state, computers);
            }
        }
        return answer;
    }

    private void dfs(int idx, boolean state[], int[][] computers) {
        state[idx] = true;
        for (int i=0; i<computers.length; i++) {
            if (!state[i] && computers[idx][i] == 1) {
                dfs(i, state, computers);
            }
        }












        
    }
}
