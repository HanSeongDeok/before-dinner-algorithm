package dfs_bfs.baekjoon.dfs;

import java.util.*;
import java.io.*;

public class Solution2468 {
    static int N;
    static int[][] box;
    static int maxRainValue = Integer.MIN_VALUE;
    static boolean[][] state;
    static int answer = 1;
    static int[] mapN = new int[] {1, -1, 0, 0};
    static int[] mapM = new int[] {0, 0, 1, -1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        box = new int[N][N];

        for (int i=0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j < N; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                maxRainValue = Math.max(box[i][j], maxRainValue);
            }
        }

        // for(int[] b : box) {
        //     System.out.println("[DEBUG]:" + Arrays.toString(b));
        // }
        // System.out.println(maxRainValue);
        
        for (int rain=1; rain < maxRainValue; rain++) {
            int count = 0;
            state = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j= 0; j < N; j++) {
                    if (!state[i][j] && box[i][j] > rain) {
                        state[i][j] = true;
                        count += 1;
                        dfs(rain, i, j);
                        //System.out.println("[DEBUG]: " + "rain-" + rain + ", n-" + i + ", m-" + j);
                    }
                }
            }
            //System.out.println("count: " + count);
            answer = Math.max(count, answer);
        }
        System.out.println(answer);
    }

    static private void dfs(int rain, int curN, int curM) {
        for (int i=0; i < 4; i++) {
            int nextN = curN + mapN[i];
            int nextM = curM + mapM[i];
            if (-1 < nextN && nextN < N && -1 < nextM && nextM < N &&
                !state[nextN][nextM] && box[nextN][nextM] > rain) {
                    state[nextN][nextM] = true;
                    dfs(rain, nextN, nextM);
            }
        }
    }
}
