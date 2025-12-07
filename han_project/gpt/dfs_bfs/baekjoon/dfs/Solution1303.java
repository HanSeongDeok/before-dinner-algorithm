package dfs_bfs.baekjoon.dfs;

import java.io.*;
import java.util.*;

/**
 * BAEKJOON
 * 1303. 전쟁 - 전투
 * 
 */
public class Solution1303 {
    static boolean[][] memo;
    static Map<String, Integer> answer = new HashMap<>();
    static int[] mapN = {1, -1, 0, 0};
    static int[] mapM = {0, 0, 1, -1};
    static int count = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int M = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken());
        String[][] box = new String[N][M];

        for (int i =0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String rows = st.nextToken();
            for (int j =0; j < rows.length(); j++) {
                box[i][j] = String.valueOf(rows.charAt(j));
            }
        }

        // for (String[] b : box) {
        //     System.out.println(Arrays.toString(b));
        // }

        memo = new boolean[N][M];
        for (int i =0; i < N; i++) {
            for (int j=0; j < M; j++) {
                if (!memo[i][j]) {
                    memo[i][j] = true;
                    String target = box[i][j];
                    count = 1;
                    dfs(N, M, new int[]{i, j}, box, target);
                    // System.out.println(target + ": " + value);
                    answer.put(target, answer.getOrDefault(target, 0) + (count * count));
                    count = 0;
                }
            }
        }
        System.out.println(answer.getOrDefault("W", 0) + " " + answer.getOrDefault("B", 0));
    }
    static void dfs(int N, int M, int infos[], String[][] box, String target) {
        int idxN = infos[0], idxM = infos[1]; 
        for (int i = 0; i < 4; i++) {
            int nextIdxN = mapN[i] + idxN;
            int nextIdxM = mapM[i] + idxM;
            if (-1 < nextIdxN && nextIdxN < N && -1 < nextIdxM && nextIdxM < M &&
                !memo[nextIdxN][nextIdxM] && target.equals(box[nextIdxN][nextIdxM])
            ) {
                memo[nextIdxN][nextIdxM] = true;
                // System.out.println("[DEBUG]: " + nextIdxN + ", " + nextIdxM);
                count += 1;
                dfs(N, M, new int[] {nextIdxN, nextIdxM}, box, target);
            }
        }
    }
}
