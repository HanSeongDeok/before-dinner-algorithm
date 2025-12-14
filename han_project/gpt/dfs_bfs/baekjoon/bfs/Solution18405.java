package dfs_bfs.baekjoon.bfs;

import java.io.*;
import java.util.*;

/**
 * BEAKJOON
 * 18405. 경쟁적 전염
 */
public class Solution18405 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        int box[][] = new int[N][N];
        boolean[][] state = new boolean[N][N];
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a[2] != b[2]) return a[2] - b[2]; 
                return box[a[0]][a[1]] - box[b[0]][b[1]];
            }
        );

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] > 0) {
                    state[i][j] = true;
                    pq.add(new int[] {i, j, 0});
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken()), Y = Integer.parseInt(st.nextToken());

        int[] mapN = {1, -1, 0, 0};
        int[] mapM = {0, 0, 1, -1};

        while(!pq.isEmpty()) {
            int[] infos = pq.poll();
            int curN = infos[0], curM = infos[1], second = infos[2];
            
            if (second == S) break;

            for (int i=0; i<4; i++) {
                int nextN = curN + mapN[i];
                int nextM = curM + mapM[i];
                if (-1 < nextN && nextN < N && -1 < nextM && nextM < N &&
                    !state[nextN][nextM] && box[nextN][nextM] == 0) {
                        state[nextN][nextM] = true;
                        box[nextN][nextM] = box[curN][curM];
                        pq.add(new int[] {nextN, nextM, second + 1});
                }
            }
        }
        // for (int[] info : box) {
        //     System.out.println(Arrays.toString(info));
        // }

        System.out.println(box[X-1][Y-1]);
    }   
}
