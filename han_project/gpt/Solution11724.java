import java.io.*;
import java.util.*;

/**
 * BAEKJOON
 * 11724. 연결 요소의 개수
 * 
 * DFS 
 */
public class Solution11724 {
    private static boolean[] visited; 
    private static int answer; 
    public static void main(String[] args)  throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        Map<Integer, List<Integer>> box = new HashMap<>(); 

        for (int i=0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            
            box.computeIfAbsent(start, s -> new ArrayList<>()).add(end);
            box.computeIfAbsent(end, e -> new ArrayList<>()).add(start);
        }

        visited = new boolean[N+1];
        for (int i=1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                answer++;
                if (box.containsKey(i)) dfs(box, i);
            }
        }
        System.out.println(answer);
    }

    private static void dfs(Map<Integer, List<Integer>> box, int index) {
        for (int b : box.get(index)) {
            if (!visited[b]) {
                visited[b] = true;
                dfs(box, b);
            }
        }
    }
}
