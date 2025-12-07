package brute_force.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BAEKJOON
 * 1182. 부분수열의 합
 * 
 * 부분 수열 문제는 순열 탐색이기에 중복 되는 조합의 dfs로 풀이하면 시간 오버된다. 주의하도록 하자
 */
public class Solution1182 {
    static int answer = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()), S = Integer.parseInt(st.nextToken());
        
        // System.out.println("[DEBUG] N: " + N);
        // System.out.println("[DEBUG] S: " + S);

        int[] numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i =0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken()); 
        }

        // System.out.println("[DEBUG] numbers: " + Arrays.toString(numbers));
        dfs(numbers,0, 0, S);
        if (S == 0) {
            System.out.println(answer-1);
        } else {
            System.out.println(answer);
        }
        
    } 
    
    private static void dfs(int[] numbers,int idx, int target, int S) {
        if (idx == numbers.length) {
            if (target == S) answer += 1;
            System.out.println("[DEBUG] target: " + target);
            return;
        }

        dfs(numbers, idx+1, target, S);
        dfs(numbers, idx+1, target + numbers[idx], S);
    }
}
