package repeat.dfs;

import java.io.*;
import java.util.*;

/**
 * BAEKJOON
 * 1987. 알파벳
 */
public class Solution1987 {
    private static int R, C, answer;
    private static String[][] box;
    private static Map<String, Boolean> stateMap = new HashMap<>();
    private static int[] mapR = {1, -1, 0, 0};
    private static int[] mapC = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        box = new String[R][C];

        for (int i=0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            String value = st.nextToken();
            for (int j=0; j < C; j++) {
                box[i][j] = String.valueOf(value.charAt(j));
                stateMap.put(box[i][j], false);
            }
        }
        stateMap.put(box[0][0], true);

        dfs(new int[] {0, 0, 1});
        System.out.println(answer);
    }

    private static void dfs(int[] infos) {
        int curR = infos[0], curC = infos[1], count = infos[2];
        answer = Math.max(count, answer);
        for (int i=0; i < 4; i++) {
            int nextR = curR + mapR[i];
            int nextC = curC + mapC[i];
            if (-1 < nextR && nextR < R && -1 < nextC && nextC < C &&
                !stateMap.get(box[nextR][nextC])) {
                    stateMap.put(box[nextR][nextC], true);
                    dfs(new int[] {nextR, nextC, count + 1});
                    stateMap.put(box[nextR][nextC], false);
            }
        }
    }
}
