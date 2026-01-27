package brute_force.baekjoon;

import java.util.*;
import java.io.*;

/**
 * BAEKJOON
 * 15652. N과 M(4)
 */
public class Solution15652 {
    static int N;
    static int M;
    static List<List<Integer>> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dfs(1, new ArrayList<>());
        for (List<Integer> a : answer) {
            for (int n : a) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }

    private static void dfs(int idx, List<Integer> targets) {
        if (targets.size() == M) {
            answer.add(new ArrayList<>(targets));
            return;
        }

        for (int i = idx; i <= N; i++) {
            targets.add(i);
            dfs(i, targets);
            targets.remove(targets.size() - 1);
        }
    }
}