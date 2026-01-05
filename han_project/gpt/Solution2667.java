import java.io.*;
import java.util.*;

public class Solution2667 {
    private static boolean[][] visited;
    private static int[] mapM = { 1, -1, 0, 0 };
    private static int[] mapN = { 0, 0, 1, -1 };
    private static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[][] box = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < N; j++) {
                box[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && box[i][j] == 1) {
                    cnt = 1;
                    dfs(box, N, i, j);
                    answer.add(cnt);
                }
            }
        }

        System.out.println(answer.size());
        answer.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);
    }

    private static void dfs(int[][] box, int N, int curM, int curN) {
        visited[curM][curN] = true;
        for (int i = 0; i < 4; i++) {
            int nextM = curM + mapM[i];
            int nextN = curN + mapN[i];
            if (-1 < nextM && nextM < N && -1 < nextN && nextN < N && 
                !visited[nextM][nextN] && box[nextM][nextN] == 1) {
                    cnt++;
                    dfs(box, N, nextM, nextN);
            }
        }
    }
}
