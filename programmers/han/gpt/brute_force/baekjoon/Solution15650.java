package brute_force.baekjoon;

import java.io.*;
import java.util.*;
/**
 * BAEKJOON
 * 15650. N과 M (2)
 * 
 */
public class Solution15650 {
    static List<List<Integer>> answer = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        
        dfs(N, M, 1, new ArrayList<>());

        for (List<Integer> a : answer) {
            for (int n : a){
                System.out.print(n + " ");
            }
            System.out.println("");
        }
    }
    private static void dfs(int N, int M, int idx, List<Integer> numbers) {
        if (numbers.size() == M) { 
            answer.add(new ArrayList<>(numbers));
            return;
        }
        for (int i=idx; i <= N; i++){
            numbers.add(i);
            dfs(N, M, i + 1, numbers);
            numbers.remove(numbers.size()-1);
        }
    }
}
