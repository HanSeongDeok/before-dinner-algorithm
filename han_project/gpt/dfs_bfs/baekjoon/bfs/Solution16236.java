package dfs_bfs.baekjoon.bfs;

import java.io.*;
import java.util.*;

/**
 * BAEKJOON
 * 16236. 아기 상어 - 오답 다시 풀기
 *
 */
public class Solution16236 {
    private static int[] mapN = {-1, 0, 0, 1}; // 위, 왼쪽 우선
    private static int[] mapM = {0, -1, 1, 0};
    private static int N;
    private static int[][] box;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        box = new int[N][N];

        int[] start = new int[2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 9) {
                    start[0] = i;
                    start[1] = j;
                    box[i][j] = 0; // 초기 위치를 0으로
                }
            }
        }

        int answer = 0;
        int size = 2;
        int eat = 0;
        int[] current = {start[0], start[1]};

        while (true) {
            int[] fish = findNearestFish(current, size);
            if (fish == null) break; // 먹을 수 있는 물고기가 없음

            // 물고기 먹기
            answer += fish[2]; // 거리(시간) 추가
            current[0] = fish[0];
            current[1] = fish[1];
            box[fish[0]][fish[1]] = 0;
            eat++;

            // 크기 증가
            if (eat == size) {
                size++;
                eat = 0;
            }
        }

        System.out.println(answer);
    }

    private static int[] findNearestFish(int[] start, int size) {
        // BFS로 가장 가까운 물고기 찾기
        // [row, col, distance]

        boolean[][] visited = new boolean[N][N];
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;

        List<int[]> candidates = new ArrayList<>(); // 같은 거리의 물고기들

        while (!dq.isEmpty()) {
            int[] current = dq.poll();
            int curN = current[0], curM = current[1], dist = current[2];

            // 먹을 수 있는 물고기를 찾았고, 같은 거리의 후보가 있으면 비교
            if (!candidates.isEmpty() && dist > candidates.get(0)[2]) {
                break; // 더 먼 거리는 탐색 중단
            }

            // 먹을 수 있는 물고기인지 확인
            if (box[curN][curM] > 0 && box[curN][curM] < size) {
                candidates.add(new int[]{curN, curM, dist});
            }

            for (int i = 0; i < 4; i++) {
                int nextN = curN + mapN[i];
                int nextM = curM + mapM[i];

                if (nextN >= 0 && nextN < N && nextM >= 0 && nextM < N &&
                    !visited[nextN][nextM] && box[nextN][nextM] <= size) {
                    visited[nextN][nextM] = true;
                    dq.offer(new int[]{nextN, nextM, dist + 1});
                }
            }
        }

        if (candidates.isEmpty()) return null;

        // 위쪽, 그 다음 왼쪽 우선 정렬
        candidates.sort((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]); // 행(위쪽)
            return Integer.compare(a[1], b[1]); // 열(왼쪽)
        });

        return candidates.get(0);
    }
}
