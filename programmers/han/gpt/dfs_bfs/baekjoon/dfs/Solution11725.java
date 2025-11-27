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

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int node = Integer.parseInt(st.nextToken());

            // 이거 메서드 레퍼런스로 구현 시 초기 list 할당량이 parent, node 즉 k 만큼 넘어간다..
            //@@ 메모리 초과가 발생함으로 주의해야 한다. k -> new ArrayList<>()로 변경해야한다.
            graphMap.computeIfAbsent(parent, ArrayList::new).add(node);
            graphMap.computeIfAbsent(node, ArrayList::new).add(parent);
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