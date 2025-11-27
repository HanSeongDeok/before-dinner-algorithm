package dfs_bfs.baekjoon.dfs;

import java.io.*;
import java.util.*;

/**
 * 11725. 트리의 무보 찾기
 */
public class Solution11725 {
    static int N;
    static Map<Integer, List<Integer>> graphMap = new HashMap<>();
    static boolean[] state;
    static int[] answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));    
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        state = new boolean[N+1];
        answer = new int[N+1];

        for (int i = 1; i <= N; i++) {
            graphMap.put(i, new ArrayList<>());
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int node = Integer.parseInt(st.nextToken());

            graphMap.get(parent).add(node);
            graphMap.get(node).add(parent);
        }

        dfs(1);
        for(int i=2; i<=N; i++) {
            System.out.println(answer[i]); 
        } 
    }

    private static void dfs(int parent) {
        for (int node : graphMap.get(parent)) {
            if (!state[node]) {
                state[node] = true;
                answer[node] = parent;
                dfs(node);
            }
        }
    }
}