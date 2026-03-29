package brute_force.baekjoon;

import java.util.*;
import java.io.*;
public class Solution15664 {
    private static boolean[] state;
    private static StringBuilder sb = new StringBuilder();
    private static List<Integer> list = new ArrayList<>();
    private static Set<String> set = new HashSet<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        List<Integer> targets = new ArrayList<>();
        
        for (int i=0; i<N; i++) {
            targets.add(Integer.parseInt(st.nextToken()));
        }

        state = new boolean[N];
        Collections.sort(targets);
        dfs(N, M, 0, targets);

        System.out.println(sb.toString());
    }
    private static void dfs(int N, int M, int idx, List<Integer> targets) {
        if (list.size() == M) {
            if (set.add(list.toString())) {
                list.forEach(n -> sb.append(n).append(" "));
                sb.append("\n");
            }
            return;
        }
        
        for (int i =idx; i< N; i++) {
            if (!state[i]) {
                state[i] = true;
                list.add(targets.get(i));
                dfs(N, M, i, targets);
                list.remove(list.size()-1);
                state[i] = false;
            }
        }
    }
}
