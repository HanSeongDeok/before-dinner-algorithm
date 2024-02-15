import java.io.*;
import java.util.*;

public class 6273_week3 {
    static int[] rails;
    static int[] input;
    static boolean[] visited;
    static int result = Integer.MAX_VALUE;
    static int N, M, K;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        result = M * K;

        st = new StringTokenizer(br.readLine());

        rails = new int[N + 1];
        input = new int[N + 1];
        visited = new boolean[N + 1];

        for(int i = 1; i <= N; i++) {
            rails[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);
        System.out.println(result);

    }

    public static void dfs(int count) {
        if (count == N) {
            int index = 0;
            int bucket = 0;
            int sum = 0;

            for(int work = 0; work < K; work++) {
                while(input[index] + bucket <= M) {
                    bucket += input[index];
                    index = (index + 1) % N;
                }

                sum += bucket;
                bucket = 0;
            }

            result = Math.min(sum, result);
            return;
        }

        for(int i = 1; i <= N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                input[count] = rails[i];
                dfs(count + 1);
                visited[i] = false;
            }
        }
    }
}