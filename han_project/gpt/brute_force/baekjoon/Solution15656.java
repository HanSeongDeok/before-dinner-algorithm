package brute_force.baekjoon;

import java.io.*;
import java.util.*;

/**
 * BAEKJOON
 * 15656. N과 M (7)
 */
public class Solution15656 {
    private static int N, M;
    private static int[] box;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        box = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            box[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(box);

        dfs(0, new ArrayList<>());
        System.out.println(sb.toString());
    }

    private static void dfs(int idx, List<Integer> target) {
        if (M == idx) {
            for (int t : target) sb.append(t).append(" ");
            sb.append("\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            target.add(box[i]);
            dfs(idx + 1, target);
            target.remove(target.size()-1);
        }
    }
}
