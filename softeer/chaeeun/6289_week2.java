import java.io.*;
import java.util.*;

public class 6289_week2 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] weights = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer>[] members = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            members[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            members[B].add(A);
            members[A].add(B);
        }

        int result = 0;

        for (int i = 1; i <= N; i++) {
            boolean isHighest = true;
            for (int j : members[i]) {
                if (weights[j - 1] >= weights[i - 1]) {
                    isHighest = false;
                    break;
                }
            }
            if (isHighest) {
                result++;
            }
        }

        System.out.println(result);
    }
}