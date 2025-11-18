package solution.gpt.dfs_bfs;

import java.util.*;
/**
 * 73. 아이템 줍기
 */
public class Solution73 {
    // 아이템 줍기 - 외곽만 따라 최단거리로 이동 (BFS)
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int MAX = 10; // 범위 제한(좌표 0~50)
        int[][] board = new int[MAX][MAX];
        boolean[][] visit = new boolean[MAX][MAX];

        // Step 1: 모든 사각형 내부 칠하고, 테두리는 1(이동 가능)로 표기
        // board[y][x] 형태: y가 행(row), x가 열(column)
        for (int[] rect : rectangle) {
            int x1 = rect[0], y1 = rect[1], x2 = rect[2], y2 = rect[3];
            for (int y = y1; y <= y2; y++) {
                for (int x = x1; x <= x2; x++) {
                    board[y][x] = 1;
                }
            }
        }
        // Step 2: 내부(테두리 아님) 0으로 변경
        for (int[] rect : rectangle) {
            int x1 = rect[0] + 1, y1 = rect[1] + 1, x2 = rect[2] - 1, y2 = rect[3] - 1;
            for (int y = y1; y <= y2; y++) {
                for (int x = x1; x <= x2; x++) {
                    board[y][x] = 0;
                }
            }
        }

        int[] dx = {1, -1, 0, 0}; // 오른쪽, 왼쪽, (x 변화 없음), (x 변화 없음)
        int[] dy = {0, 0, 1, -1}; // (y 변화 없음), (y 변화 없음), 아래, 위
        // Step 3: BFS 시작
        Queue<int[]> q = new ArrayDeque<>();
        int startX = characterX, startY = characterY;
        q.offer(new int[]{startX, startY, 0});
        visit[startY][startX] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0], cy = cur[1], cnt = cur[2];
            if (cx == itemX && cy == itemY) {
                return cnt;
            }
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i], ny = cy + dy[i];
                if (nx >= 0 && nx < MAX && ny >= 0 && ny < MAX && !visit[ny][nx] && board[ny][nx] == 1) {
                    visit[ny][nx] = true;
                    q.offer(new int[]{nx, ny, cnt + 1});
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        Solution73 s73 = new Solution73();
        int[][][] rectangles = {
            {{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}},
            {{1,1,8,4},{2,2,4,9},{3,6,9,8},{6,3,7,7}},
            {{1,1,5,7}},
            {{2,1,7,5},{6,4,10,10}},
            {{2,2,5,5},{1,3,6,4},{3,1,4,6}}
        };
        int[] characterX = {1, 9, 1, 3, 1};
        int[] characterY = {3, 7, 1, 1, 4};
        int[] itemX = {7, 6, 4, 7, 6};
        int[] itemY = {8, 1, 7, 10, 3};
        int[] expected = {17, 11, 9, 15, 10};

        for (int t = 0; t < rectangles.length; t++) {
            int result = s73.solution(rectangles[t], characterX[t], characterY[t], itemX[t], itemY[t]);
            System.out.println("Test case " + (t+1) + " result: " + result + " / expected: " + expected[t]);
        }
    }
}






