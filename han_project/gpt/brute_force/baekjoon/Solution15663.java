package brute_force.baekjoon;

import java.io.*;
import java.util.*;

/**
 * BAEKJOON
 * 15663. N과 M (9) 
 */
public class Solution15663 {
    private static int[] box;
    private static boolean[] state;
    private static StringBuilder sb = new StringBuilder();
    private static Set<String> set = new HashSet<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        box = new int[N];
        state = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) box[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(box);

        dfs(new ArrayList<>(), N, M);
        System.out.println(sb.toString());
    }

    private static void dfs(List<Integer> temp, int n, int m) {
        if (temp.size() == m) {
            if(set.add(temp.toString())) {
                temp.forEach(v -> sb.append(v).append(" "));
                sb.append("\n");
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!state[i]) {
                state[i] = true;
                temp.add(box[i]);
                dfs(temp,  n, m);
                temp.remove(temp.size()-1);
                state[i] = false;
            }
        }
    }
}
