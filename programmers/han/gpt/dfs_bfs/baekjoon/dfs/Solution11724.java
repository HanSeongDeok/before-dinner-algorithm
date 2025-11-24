package dfs_bfs.baekjoon.dfs;

import java.util.*;
import java.io.*;
/**
 * BAEKJOON
 * 11724. 연결 요소의 개수
 * 
 */
public class Solution11724 {
    static boolean[] memo;
    static Map<Integer, List<Integer>> networkMap = new HashMap<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;

        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        memo= new boolean[N+1];

        for (int i=1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken());
            networkMap.computeIfAbsent(u, ArrayList::new).add(v); 
            networkMap.computeIfAbsent(v, ArrayList::new).add(u); 
        }

        // for (int key : networkMap.keySet()) {
        //     System.out.println(key + ": " + networkMap.get(key).toString());
        // }

        for (int i=1; i <=N; i++) {
            if (!memo[i]) {
                memo[i] = true;
                // System.out.println("v: " + i);
                dfs(N, i);
                answer += 1;
                // System.out.println("network: " + answer);
            }
        } 
        System.out.println(answer);
    }

    static private void dfs(int N, int idx) {
        if (!networkMap.containsKey(idx)) {
            return;
        }
        for (int v : networkMap.get(idx)){
            if (!memo[v]) {
                // System.out.println("v: " + v);
                memo[v] = true;
                dfs(N, v);
            }
        }
    }
}
