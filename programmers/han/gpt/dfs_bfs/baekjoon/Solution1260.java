package baekjoon.han.java.silver;

import java.io.*;
import java.util.*;

/**
 * 1260. DFS와 BFS
 * 
 * 유형: DFS, BFS 
 */
public class Solution1260 {

    List<List<Integer>> graphLists = new ArrayList<>();
    boolean[] memo;

    public void solution(int N, int M, int V, BufferedReader br)throws IOException {
        for (int i=0; i <= N; i++) {
            graphLists.add(new ArrayList<>());
        }

        for (int i=0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graphLists.get(start).add(end);
            graphLists.get(end).add(start);
        }

        for (List<Integer> list : graphLists) {
            list.sort(Comparator.naturalOrder());
        }
        memo = new boolean[N+1];
        memo[V] = true;
        System.out.println(dfs(V, memo, new StringBuilder()));
    
        memo = new boolean[N+1];
        memo[V] = true;
        System.out.println(bfs(V, memo, new StringBuilder()));
    }

    private String dfs(int V, boolean[] memo, StringBuilder br) {
        br.append(V).append(" ");
        for (int end : graphLists.get(V)) {
            if (!memo[end]) {
                memo[end] = true;
                dfs(end, memo, br);
            }
        }
        return br.toString();
    }
    
    private String bfs(int V, boolean[] memo, StringBuilder br) {
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(V);
        while (!dq.isEmpty()) {
            int start = dq.poll();
            br.append(start).append(" ");
            for (int end : graphLists.get(start)) {
                if (!memo[end]) {
                    memo[end] = true;
                    dq.offer(end);
                }
            }
        }
        return br.toString();
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        Solution1260 s1260 = new Solution1260();
        s1260.solution(N, M, V, br);
    }
}
