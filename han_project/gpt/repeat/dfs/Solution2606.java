package repeat.dfs;

import java.io.*;
import java.util.*;

/**
 * 2606. 바이러스
 */
public class Solution2606 {
    private static Map<Integer, List<Integer>> map;
    private static boolean state[];
    private static int answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        state = new boolean[N+1];

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        map = new HashMap<>();

        for (int i=0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            
            int key = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            map.computeIfAbsent(key , f -> new ArrayList<>()).add(value);
            map.computeIfAbsent(value, f -> new ArrayList<>()).add(key);
        }
        
        if (M > 0) dfs(1);
        System.out.println(answer);
    }

    public static void dfs(int number) {
        state[number] = true;
        for (int n : map.get(number)) {
            if (!state[n]) {
                answer++;
                dfs(n);
            }
        }
    }
}
