package bfs;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution48 {
    private final int[] mapN = {1, -1, 0, 0};
    private final int[] mapM = {0, 0, 1, -1};
    public int solution(int[][] maps) {
        int answer = -1;
        int N = maps.length;
        int M = maps[0].length;

        boolean[][] state = new boolean[N][M];
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[] {0, 0, 1});

        while (!dq.isEmpty()) {
            int[] infos = dq.poll();
            int curN = infos[0], curM = infos[1], count = infos[2];
            
            if (curN == N-1 && curM == M-1) {
                answer = count;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nextN = mapN[i] + curN;
                int nextM = mapM[i] + curM;
                if (-1 < nextN && nextN < N && -1 < nextM && nextM < M
                    && !state[nextN][nextM] && maps[nextN][nextM] == 1
                ) {
                    state[nextN][nextM] = true;
                    dq.add(new int[]{nextN, nextM, count+1});
                }
            }
        }
        return answer;
    }
}
