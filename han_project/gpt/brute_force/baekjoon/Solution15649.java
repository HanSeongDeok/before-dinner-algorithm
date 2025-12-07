package brute_force.baekjoon;

import java.io.*;
import java.util.*;

/**
 * BAEKJOON
 * 15649. N과 M(1)
 * 
 * 조합 문제 -> DFS 활용
 */
public class Solution15649 {
    static List<String> answer = new ArrayList<>();
    static boolean[] memo;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        memo = new boolean[N+1];
        // 1. 입력값 확인
        // System.out.println("[DEBUG] - N: " + N);
        // System.out.println("[DEBUG] - M: " + M);

        dfs(new ArrayList<>(), N, M);
        
        // 정답
        answer.stream().forEach(System.out::println);
    }
    private static void dfs(List<Integer> values, int N, int M) {
        if (values.size() == M) {
            StringBuilder sb = new StringBuilder();
            for (int value : values) {
                sb.append(value).append(" ");
            }
            // 2. 정답에 추가되는 값들
            // System.out.println("[DEBUG] ADD Answer: " + sb.toString());
            answer.add(sb.toString());
            return;
        }

        for (int i=1; i < N+1; i++) {
            if (!memo[i]) {
                memo[i] = true;
                values.add(i);
                dfs(values, N, M);
                values.remove(values.size()-1);
                memo[i] = false;
            }
        }
    }
}
