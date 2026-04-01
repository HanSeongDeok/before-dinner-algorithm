package repeat.brute_force;

import java.io.*;
import java.util.*;

public class Solution15650 {
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        dfs(N, M, new boolean[N+1], new ArrayList<>(), 1);
        System.out.println(sb.toString());
    }

    private static void dfs(int N, int M,  boolean[] state, List<Integer> list, int idx) {
        if (list.size() == M) {
            list.forEach(n -> sb.append(n).append(" "));
            sb.append("\n");
            return;
        }

        for (int i=idx; i < N+1; i++){
            if (!state[i]) {
                state[i] = true;
                list.add(i);
                dfs(N, M, state, list, i);
                list.remove(list.size()-1);
                state[i] = false;
            }
        }        
    }
}
