package dfs_bfs;

import java.util.*;
/**
 * 73. 아이템 줍기
 */
public class Solution73 {
    /**
     * @Day 1
     * @param rectangle
     * @param characterX
     * @param characterY
     * @param itemX
     * @param itemY
     * @return
     */
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        int[][] map =  new int[102][102];

        for (int[] rec : rectangle) {
            int x1 = rec[0] * 2, x2 = rec[2] * 2, y1 = rec[1] * 2, y2 = rec[3] * 2;
            for (int y = y1; y <= y2; y++) {
                for (int x = x1; x <= x2; x++) {
                    map[y][x] = 1;
                }
            }
        }
        
        for (int[] rec : rectangle) {
            int x1 = rec[0] * 2, x2 = rec[2] * 2, y1 = rec[1] * 2, y2 = rec[3] * 2;
            for (int y = y1+1; y <= y2-1; y++) {
                for (int x = x1+1; x <= x2-1; x++) {
                    map[y][x] = 0;
                }
            }
        }

        // for (int i = map.length-1; i >= 0; i--) {
        //     System.out.println(Arrays.toString(map[i]));
        // }

        int[] mapY = {1, -1, 0, 0};
        int[] mapX = {0, 0, 1, -1};

        boolean[][] memo = new boolean[102][102];
        memo[characterY * 2][characterX * 2] = true;
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{characterY * 2, characterX * 2, 1});

        while (!dq.isEmpty()) {
            int[] infos = dq.poll();  
            int curY = infos[0], curX = infos[1], dist = infos[2];

            if (curY == itemY * 2 && curX == itemX * 2) {
                answer = dist / 2;
                break;
            }
            
            for (int i=0; i < 4; i++) {
                int nextY = curY + mapY[i];
                int nextX = curX + mapX[i];
                if (-1 < nextY && nextY < 102 && -1 < nextX && nextX < 102 &&
                    !memo[nextY][nextX] && map[nextY][nextX] == 1) {
                        memo[nextY][nextX] = true;
                        dq.offer(new int[]{nextY, nextX, dist+1});
                }
            }
        }
        
        // System.out.println(answer);
        return answer;
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






