package dfs_bfs.baekjoon.bfs;

import java.util.*;
import java.io.*;

public class Solution7569 {
    static int N;
    static int M;
    static int H;
    static boolean[][][] state;
    static int[][][] box;
    static int[] mapH = new int[] {1, -1, 0, 0, 0, 0};
    static int[] mapN = new int[] {0, 0, 1, -1, 0, 0};
    static int[] mapM = new int[] {0, 0, 0, 0, 1, -1};
    static int answer = 0;
    static Deque<int[]> dq = new ArrayDeque<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        
        box = new int[H][N][M];
        state = new boolean[H][N][M];
        int[] startInfo = new int[3];

        for (int h=0; h < H; h++) {
            for (int n=0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m=0; m < M; m++) {
                    box[h][n][m] = Integer.parseInt(st.nextToken());
                    if (box[h][n][m] == 1) {
                        dq.offer(new int[] {h, n, m, 0});
                        state[h][n][m] = true;
                    }
                }
            }
        }
        // for (int[] b : box[0]) {
        //     System.out.println(Arrays.toString(b));
        // }
        // System.out.println("[DEBUG-StartIndex]: " + Arrays.toString(startInfo));
        bfs(dq);
        
        boolean isValid = true;
        for (int h=0; h < H; h++) {
            for (int n=0; n < N; n++) {
                for (int m=0; m < M; m++) {
                    if (box[h][n][m] == 0 && !state[h][n][m]) {
                        isValid = false;
                        break;
                    }
                }
            }
        }
        if (isValid) {
            System.out.println(answer);
        }  else {
            System.out.println(-1);
        }
        
    }

    private static void bfs(Deque<int[]> dq) {
        while (!dq.isEmpty()) {
           int[] infos = dq.poll();
           int curH= infos[0], curN= infos[1], curM= infos[2], day = infos[3];
            
           for (int i=0; i< 6; i++) {
                int nextH = curH + mapH[i];
                int nextN = curN + mapN[i];
                int nextM = curM + mapM[i];
                if (-1< nextH && nextH < H && -1 < nextN && nextN < N && -1 < nextM && nextM < M &&
                    !state[nextH][nextN][nextM] && box[nextH][nextN][nextM] == 0) {
                        state[nextH][nextN][nextM] = true;
                        int nextDay = box[nextH][nextN][nextM] == 0 ? day + 1 : day;
                        answer = Math.max(nextDay, answer);
                        dq.offer(new int[] {nextH, nextN, nextM, nextDay});
                }
            }
        }
    }
}
