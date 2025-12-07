package brute_force.baekjoon;

import java.io.*;
import java.util.*;

/**
 * BAEKJOON
 * 연산자 끼워넣기
 * 
 * 핵심 아이디어:
 * - N개의 숫자 사이에 N-1개의 연산자를 배치
 * - 모든 연산자를 사용해서 계산
 * - DFS로 모든 경우의 수 탐색
 */
public class Solution14888 {
    static List<Integer> answer = new ArrayList<>();
    static int[] numbers;
    static int[] operators = new int[4]; 
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        // System.out.println("[DEBUG] N = " + N);
        // System.out.println("[DEBUG] numbers = " + Arrays.toString(numbers));
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        // System.out.println("[DEBUG] operators = " + Arrays.toString(operators));
        
        dfs(1, numbers[0]);

        int min = answer.stream().sorted(Comparator.naturalOrder()).findFirst().get();
        int max = answer.stream().sorted(Comparator.reverseOrder()).findFirst().get();
        
        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(int idx, int value) {
        if (idx == numbers.length) {
            // System.out.println("[DEBUG] ADD::" + value);
            answer.add(value);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i] -= 1;
                int calValue = calculate(value, numbers[idx], i);
                // System.out.println("[DEBUG] cal value::" + calValue);
                dfs(idx + 1, calValue);
                operators[i] += 1; 
            }
        }
    }

    private static int calculate(int a, int b, int operator) {
        if (operator == 0) return a + b;
        else if (operator == 1) return a - b;
        else if (operator == 2) return a * b;
        else return a / b;
    }
}
