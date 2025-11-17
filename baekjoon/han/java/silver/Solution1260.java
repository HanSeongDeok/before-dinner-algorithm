package baekjoon.han.java.silver;

import java.io.*;
import java.util.*;

/**
 * 1260. DFS와 BFS
 */
public class Solution1260 {
    List<List<Integer>> graphList = new ArrayList<>();
    public void solution(int N, int M, int V, BufferedReader br) throws IOException{ 
        for (int i = 0; i <= N; i++) {
            graphList.add(new ArrayList<>());
        }

        for (int i=0; i <M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            graphList.get(idx).add(value);
            graphList.get(value).add(idx);
        }
        
        for (List<Integer> list : graphList) {
            list.sort(Comparator.naturalOrder());
        }

        boolean[] memo = new boolean[N+1];
        memo[V] = true;
        System.out.println(dfs(V, new StringBuilder(), memo)); 
        System.out.println(bfs(V, new StringBuilder(), new boolean[N+1])); 
    }

    private String dfs(int V, StringBuilder sb, boolean[] memo) {
        sb.append(V).append(" ");
        for (int idx : graphList.get(V)) {
            if (!memo[idx]) {
                memo[idx] = true;
                dfs(idx, sb, memo);
            }
        }
        return sb.toString();
    }

    private String bfs(int V, StringBuilder sb, boolean[] memo) {
        Deque<Integer> dq = new ArrayDeque<Integer>();
        dq.offer(V);
        memo[V] = true;
        
        while (!dq.isEmpty()) {
            int idx = dq.poll();
            sb.append(idx).append(" ");

            for (int i : graphList.get(idx)){
                if (!memo[i]) {
                    memo[i] = true;
                    dq.offer(i);
                }
            }
        }
        return sb.toString();
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
