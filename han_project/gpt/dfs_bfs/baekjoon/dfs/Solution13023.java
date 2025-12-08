package dfs_bfs.baekjoon.dfs;

import java.util.*;
import java.io.*;
/**
 * BAEKJOON
 * 13023. ABCDE
 */
public class Solution13023 {
    private static int N, M;
    private static boolean[] state;
    private static boolean answer = false;
    private static Map<Integer, List<Integer>> networks = new HashMap<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); 
        M = Integer.parseInt(st.nextToken());
        state = new boolean[N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int node = Integer.parseInt(st.nextToken());
            
            networks.computeIfAbsent(parent, k -> new ArrayList<>()).add(node);
            networks.computeIfAbsent(node, k -> new ArrayList<>()).add(parent);
        }
        for (int i = 0; i < N; i++) {
            if (answer) break;
            if (!state[i]){
                state[i] = true;
                dfs(i, 0);
                state[i] = false;
            }
        }
        
        System.out.println(answer ? 1 : 0);
    }

    private static void dfs(int idx, int depth) {
        if (depth == 4) {
            answer = true;
            return;
        }
        if (!networks.containsKey(idx)) {
            return;
        }
        for (int i : networks.get(idx)) {
            if (!state[i]) {
                state[i] = true;
                dfs(i, depth + 1);
                state[i] = false;
            }
        }
    }
}
