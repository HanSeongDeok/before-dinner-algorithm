package repeat.brute_force;

import java.io.*;
import java.util.*;

public class Solution15649 {
    private static List<Integer> list = new ArrayList<>();
    private static StringBuilder sb = new StringBuilder(); 
    private static boolean[] state;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        state = new boolean[N+1];
        dfs(N, M);
        System.out.println(sb.toString());
    }

    private static void dfs(int N, int M) {
        if (list.size() == M) {
            list.forEach(n -> sb.append(n).append(" "));
            sb.append("\n");
            return;
        }
        for (int i=1; i < N+1; i++) {
            if (!state[i]) {
                state[i] = true;
                list.add(i);
                dfs(N, M);
                list.remove(list.size()-1);
                state[i] = false;
            }
        }
    }
}
