package dfs_bfs.baekjoon.dfs;

import java.io.*;
import java.util.*;

/**
 * BAEKJOON
 * 14502. 연구소 
 * 
 * DFS (조합) + BFS 문제 유형 판단이 바로 불가능 -> 힌트 참고 함.. 
 * 구현은 쉬우나 처음 문제 유형 판단이 힘듬.. (복습 필요)
 */
public class Solution14502 {
    private static int N, M;
    private static List<int[]> virus, emptys;
    private static int[][] box;
    private static int[] mapN = {1, -1, 0, 0};
    private static int[] mapM = {0, 0, 1, -1};
    private static int answer = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        box = new int[N][M];
        virus = new ArrayList<>();
        emptys = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 2) {
                    virus.add(new int[]{i, j});
                }
                if (box[i][j] == 0) {
                    emptys.add(new int[]{i, j});
                }
            }
        }

        dfs(0);
        System.out.println(answer);
    }

    private static void dfs(int count) {
        if (count == 3) {
            answer = Math.max(bfs(), answer);
            return;
        }

        for (int[] infos : emptys) {
            if (box[infos[0]][infos[1]] == 0) {
                box[infos[0]][infos[1]] = 1;
                dfs(count + 1);
                box[infos[0]][infos[1]] = 0;
            }
        }
    }

    private static int bfs() {
        Deque<int[]> dq = new ArrayDeque<>();
        dq.addAll(virus);
        
        int[][] copyBox = new int[N][M];
        for (int i=0; i < N; i++) copyBox[i] = Arrays.copyOf(box[i], M);

        while(!dq.isEmpty()) {
            int[] infos = dq.poll();
            int curN = infos[0], curM = infos[1];
            for (int i=0; i < 4; i++) {
                int nextN = curN + mapN[i];
                int nextM = curM + mapM[i];
                if (-1 < nextN &&  nextN < N && -1 < nextM && nextM < M &&
                    copyBox[nextN][nextM] == 0) {
                        copyBox[nextN][nextM] = 2;
                        dq.add(new int[] {nextN, nextM});
                }
            }
        }

        int count = 0;
        for (int i=0; i< N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyBox[i][j] == 0) count++;
            }
        }
        return count;
    }
}
