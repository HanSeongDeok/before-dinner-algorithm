package dfs_bfs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 32. 게임 맵 최단거리리
 */
public class Solution32 {
    boolean[][] memo;
    int answer = -1;
    Deque<int[]> dq = new ArrayDeque<>();
    
    public int solution(int[][] maps) { 
        int N = maps.length, M = maps[0].length;
        memo = new boolean[N][M];
        memo[0][0] = true;
        bfs(N, M, maps);
        System.out.println(answer);
        return answer;
    }

    private void bfs(int N, int M, int[][] maps) {
        int[] mapInfos = {0, 0, 1};
        dq.offer(mapInfos);

        int [] mapN = {1, -1, 0, 0};
        int [] mapM = {0, 0, 1, -1};

        while (!dq.isEmpty()) {
            int [] mapInfo = dq.poll();
            int curN = mapInfo[0], curM = mapInfo[1], dist = mapInfo[2];

            if (curN == N-1 && curM == M-1) {
                answer = dist;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nextN = curN + mapN[i];
                int nextM = curM + mapM[i];
                if (-1 < nextN && nextN < N && -1 < nextM && nextM < M &&
                    !memo[nextN][nextM] && maps[nextN][nextM] == 1) {
                        memo[nextN][nextM] = true;
                        dq.offer(new int[]{nextN, nextM, dist + 1});
                    }
            }
        }
    }

    public static void main(String[] args) {
        Solution32 s32 = new Solution32();
        s32.solution(new int[][]{
            {1,0,1,1,1},
            {1,0,1,0,1},
            {1,0,1,1,1},
            {1,1,1,0,1},
            {0,0,0,0,1}
        });
    }
}
