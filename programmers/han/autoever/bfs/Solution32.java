package solution.autoever.bfs;

import java.util.*;

/**
 * 32. 게임 맵 최단거리
 * 알고리즘 유형: 너비 우선 탐색(BFS)
 */
public class Solution32 {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        int[] dx = { 1, -1, 0, 0 };
        int[] dy = { 0, 0, 1, -1 };

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { 0, 0, 1 }); // x, y, distance
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int dist = current[2];

            if (x == n - 1 && y == m - 1) {
                return dist;
            }

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (maps[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.add(new int[] { nx, ny, dist + 1 });
                    }
                }
            }
        }

        return -1;
    }

    /**
     * @Day 2
     * @param maps
     * @return
     */
    public int solution2(int[][] maps) {
        int n = maps.length, m = maps[0].length;
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[] { 0, 0, 1 });

        boolean[][] memo = new boolean[n][m];
        memo[0][0] = true;

        int[] arrN = { 1, -1, 0, 0 };
        int[] arrM = { 0, 0, 1, -1 };

        while (!dq.isEmpty()) {
            int[] infos = dq.poll();
            int currentN = infos[0], currentM = infos[1], dist = infos[2];

            if (currentN == n - 1 && currentM == m - 1) {
                return dist;
            }

            for (int i = 0; i < 4; i++) {
                int nextN = currentN + arrN[i];
                int nextM = currentM + arrM[i];
                if (-1 < nextN && nextN < n && -1 < nextM && nextM < m &&
                        !memo[nextN][nextM] && maps[nextN][nextM] != 0) {
                    dq.offer(new int[] { currentN + arrN[i], currentM + arrM[i], dist + 1 });
                    memo[currentN + arrN[i]][currentM + arrM[i]] = true;
                }
            }
        }

        return -1;
    }

    /**
     * @Day 3
     * @param maps
     * @return
     */
    public int solution3(int[][] maps) {
        int n = maps.length, m = maps[0].length;
        Deque<int[]> dq = new ArrayDeque<>();
        boolean[][] memo = new boolean[n][m];
        dq.add(new int[] {0, 0, 1});

        int[] mapN = {1, -1, 0, 0};
        int[] mapM = {0, 0, 1, -1};

        while (!dq.isEmpty()) {
            int[] infos = dq.poll();
            int curN = infos[0], curM = infos[1], dist = infos[2];

            if (curN == n - 1 && curM == m - 1){
                return dist;
            }

            for (int i = 0; i < 4; i++) {
                int nextN = curN + mapN[i];
                int nextM = curM + mapM[i];
                if (-1 < nextN && nextN < n && -1 < nextM && nextM < m &&
                    !memo[nextN][nextM] && maps[nextN][nextM] != 0) {
                        memo[nextN][nextM] = true;
                        dq.offer(new int[]{nextN, nextM, dist + 1});
                    }
            }
        }

        return -1;
    } 

    public static void main(String[] args) {
        // 예시 맵
        int[][] maps = {
                { 1, 0, 1, 1, 1 },
                { 1, 0, 1, 0, 1 },
                { 1, 0, 1, 1, 1 },
                { 1, 1, 1, 0, 1 },
                { 0, 0, 0, 0, 1 }
        };

        Solution32 sol = new Solution32();
        int resultBFS = sol.solution2(maps);
        System.out.println("answer::" + resultBFS);
    }
}
