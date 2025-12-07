package brute_force.baekjoon;

import java.io.*;
import java.util.*;

/**
 * BAEKJOON
 * 15623. N과 M(5) 
 * 
 */
public class Solution15653 {
    static int N, M;
    static boolean[] state;
    static StringBuilder sb = new StringBuilder();
    static int[] box;
    static List<Integer> target = new ArrayList<>(); 
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        box = new int[N];
        state = new boolean[N];

        for (int i=0; i < N; i++) {
            box[i] = Integer.parseInt( st.nextToken());
        }

        Arrays.sort(box);
        dfs();
        System.out.println(sb.toString());
    }

    private static void dfs() {
        if (target.size() == M) {
            target.forEach(v -> sb.append(v).append(" "));
            sb.append("\n");
            return;
        }

        for (int i=0; i < box.length; i++) {
            if (!state[i]) {
                state[i] = true;
                target.add(box[i]);   
                dfs();
                target.remove(target.size()-1);
                state[i] = false;             
            }
        }
    }
}
