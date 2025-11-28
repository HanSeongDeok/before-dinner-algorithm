package dfs_bfs.baekjoon.dfs;

import java.io.*;
import java.util.*;

public class Solution1987 {
    static int N;
    static int M;
    static Map<String, Boolean> stateMap = new HashMap<>();
    static String[][] box;
    static int answer = 0;
    static int[] mapN = new int[] {1, -1, 0, 0};
    static int[] mapM = new int[] {0, 0, 1, -1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        box = new String[N][M];
        for (int i=0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String value = st.nextToken();
            for (int j=0; j < M; j++) {
                box[i][j] = String.valueOf(value.charAt(j));
                stateMap.put(box[i][j], false);
            }
        }

        for(String[] b : box) {
            System.out.println(Arrays.toString(b));
        }

        System.out.println(stateMap.toString());
        // stateMap.put(box[0][0], true);
        dfs(0, 0, 1);
        System.out.println(answer);
    }

    private static void dfs(int curN, int curM, int count) {
        answer = Math.max(count, answer);
        for (int i=0; i< 4; i++) {
            int nextN = curN + mapN[i];
            int nextM = curM + mapM[i];
            if (-1 < nextN && nextN < N && -1 < nextM && nextM < M &&
                !stateMap.get(box[nextN][nextM]) && !box[nextN][nextM].equals(box[0][0])) {
                    stateMap.put(box[nextN][nextM], true);
                    dfs(nextN, nextM, count + 1);
                    stateMap.put(box[nextN][nextM], false);
            }
        }
    }
}

// 3 6
// HFDFFB
// AJHGDH
// DGAGEH

// 2 4
// CAAB
// ADCB