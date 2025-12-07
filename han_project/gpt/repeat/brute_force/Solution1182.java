package repeat.brute_force;

import java.io.*;
import java.util.*;

public class Solution1182 {
    static int answer = 0;
    static int N = -1;
    static int S = -1;
    static int[] numbers;
    public static void main(String[] args) throws IOException{
        //5 0
        //-7 -3 -2 5 8
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        numbers = new int[N];
        for (int i=0; i< N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        // System.out.println("[DEBUG]: " + Arrays.toString(numbers));
        dfs(0, 0);

        if (S == 0) {
            System.out.println(answer - 1);
            return;
        }
        System.out.println(answer);
        
    }

    private static void dfs(int idx, int target) {
        if (idx == N) {
            if (target == S) {
                // System.out.println("[DEBUG][ADD ANSWER]: " + target);
                answer ++;
            }
            // System.out.println("[DEBUG]: " + target);
            return;
        }

        dfs(idx + 1, target + numbers[idx]);
        dfs(idx + 1, target);
    }
}
