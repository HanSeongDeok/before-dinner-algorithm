package solution.gpt.dfs_bfs.baekjoon;

/**
 * BAEKJOON 
 * 2667.단지번호붙이기
 */
import java.io.*;
import java.util.*;

public class Solution2667 {

    private static List<Integer> answer = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        
        int[][] box = new int[N][N]; 
        for (int i=0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j=0; j < line.length(); j++) {
                box[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }

        for (int[] b : box) {
            System.out.println("[DEBUG] " + Arrays.toString(b));    
        }
        
        Deque<int[]> dq = new ArrayDeque<>();
        boolean[][] memo = new boolean[N][N];
        
        // ========== [단계 2] BFS 탐색 시작 ==========
        int complexCount = 0; // 단지 번호 추적용
        for (int n=0; n < N; n++) {
            for (int m=0; m < N; m++) {
                if (!memo[n][m] && box[n][m] == 1) {
                    complexCount++;
                    
                    memo[n][m] = true;
                    dq.offer(new int[]{n, m});
                    int complexSize = bfs(dq, box, memo);
                    answer.add(complexSize);
                }
            }
        }
        
        // ========== [단계 5] 최종 결과 출력 ==========
        System.out.println(answer.size());
        answer.stream().sorted(Comparator.naturalOrder())
            .forEach(System.out::println);
        
    }

    private static int bfs(Deque<int[]> dq, int[][] box, boolean[][] memo) {
        int[] mapN = {1, -1, 0, 0};
        int[] mapM = {0, 0, 1, -1};
        int maxValue = 1;
        while (!dq.isEmpty()) {
            int[] info = dq.poll();
            int curN = info[0], curM = info[1];
            
            for (int i=0; i < 4; i++) {
                int nextN = curN + mapN[i];
                int nextM = curM + mapM[i];
                
                if (-1 < nextN && nextN < box.length && -1 < nextM && nextM < box.length &&
                    !memo[nextN][nextM] && box[nextN][nextM] == 1) {
                        memo[nextN][nextM] = true;
                        dq.offer(new int[]{nextN, nextM});
                        maxValue += 1;
                        
                        System.out.println("[DEBUG-BFS] 새로운 집 발견: (" + nextN + ", " + nextM + "), 단지 크기: " + maxValue);
                } 
            }
        }
        return maxValue;
    }
}