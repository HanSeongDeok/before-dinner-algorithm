package dfs_bfs.baekjoon.dfs;

import java.io.*;
import java.util.*;

/**
 * BAEKJOON
 * 4963. 섬의 개수
 */
public class Solution4963 {
    static List<int[][]> boxs = new ArrayList<>();
    static boolean[][] state;
    static int H, W;
    static int[][] box;
    static int[] mapH = new int[] {1, -1, 0, 0, 1, -1, 1, -1};
    static int[] mapW = new int[] {0, 0, 1, -1, 1, -1, -1, 1};
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int M = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken());  
    
        while (N != 0 && M != 0) {
            box = new int[N][M];
            for (int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j=0; j<M; j++) {
                    box[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            boxs.add(box);
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
        }
        
        // for (int[][] b: boxs) {
        //     for (int[] n : b) {
        //         System.out.println("[DEBUG]: " + Arrays.toString(n));
        //     }
        //     System.out.println("----------------");
        // }
        
        for (int[][] b: boxs) {
            box = b;
            H = b.length;
            W = b[0].length;
            state = new boolean[H][W];      
                  
            int answer = 0;
            for (int i = 0; i < H; i++) {
                for (int j =0; j < W; j++) {
                    if (!state[i][j] && box[i][j] == 1) {
                        state[i][j] = true;
                        answer += 1;
                        dfs(i, j);
                    }
                } 
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void dfs(int curH, int curW) {
        for (int i = 0; i < 8; i++) {
            int nextH = curH + mapH[i];
            int nextW = curW + mapW[i];
            if(-1 < nextH && nextH < H && -1 < nextW && nextW < W &&
                !state[nextH][nextW] && box[nextH][nextW] == 1) {
                    state[nextH][nextW] = true;
                    dfs(nextH, nextW);
            }
        }
    }
}
