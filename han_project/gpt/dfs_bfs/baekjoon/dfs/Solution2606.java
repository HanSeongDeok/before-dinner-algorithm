package dfs_bfs.baekjoon.dfs;

import java.io.*;
import java.util.*;

/**
 * BAEKJOON
 * 2606.  바이러스
 * 
 */
public class Solution2606 {
    private static boolean[] visited;
    private static int answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];
        visited[1] = true;

        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());

        Map<Integer,  List<Integer>> box = new HashMap<>();
        for (int i=0; i< K; i++) {
            st = new StringTokenizer(br.readLine());
            int key = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            box.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
            box.computeIfAbsent(value, k -> new ArrayList<>()).add(key);
        }

        // for(List<Integer> list : box.values()) {
        //     System.out.println(list.toString());
        // }
        if (box.containsKey(1)) {
            dfs(box, 1);
        }
        System.out.println(answer);
    }

    private static void dfs(Map<Integer,  List<Integer>> box, int index) {
        for (int b : box.get(index)) {
            if(!visited[b]) {
                visited[b] = true;
                answer++;
                dfs(box, b);
            }
        }
    }
}
