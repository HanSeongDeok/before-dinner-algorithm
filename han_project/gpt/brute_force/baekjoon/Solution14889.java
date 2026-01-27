package brute_force.baekjoon;

import java.io.*;
import java.util.*;

/**
 * BAEKJOON
 * 14889. 스타트와 링크
 * 
 */
public class Solution14889 {
    static int answer = Integer.MAX_VALUE;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int[][] box = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                box[i][j] = Integer.valueOf(st.nextToken());
            }
        }

        for (int[] b : box) {
            System.out.println("[DEBUG]: " + Arrays.toString(b));
        }

        dfs(box, 0, new ArrayList<>());
        System.out.println(answer);
    }

    private static void dfs(int[][] box, int idx, List<Integer> idxs) {
        if (idxs.size() == N / 2) {
            int S = 0, L = 0;
            
            // 스타트 팀과 링크 팀 능력치 계산
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i == j) continue;
                    if (idxs.contains(i) && idxs.contains(j)) {
                        S += box[i][j];
                    } else if (!idxs.contains(i) && !idxs.contains(j)) {
                        L += box[i][j];
                    }
                }
            }
            
            answer = Math.min(Math.abs(S - L), answer);
            return;
        }

        for (int i = idx; i < N; i++) {
            idxs.add(i);
            dfs(box, i + 1, idxs);
            idxs.remove(idxs.size()-1);
        }
    }
}
