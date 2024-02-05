package han.softeer.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class KwangWoo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] infos = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] values = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        boolean[] visited = new boolean[infos[0]];
        int[] permutationValues = new int[infos[0]];
        int result = Integer.MAX_VALUE;
        System.out.println(dfs(0, infos, permutationValues, values, visited, result));

    }
    private static int dfs (int count, int[] infos, int[] permutationValues, int[] values, boolean[] visited, int result){
        int N = infos[0],   M = infos[1],   K = infos[2];
        int box = 0,   index = 0,  sum = 0;
        if (count == N) {
            for (int i=0; i< K; i++) {
                while (box <= M) {
                    if (index == N) index = 0;
                    box += permutationValues[index++];
                }
                box -= permutationValues[--index];
                sum += box;
                box = 0;
            }
            return sum;
        }

        for (int i=0; i<N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                permutationValues[count] = values[i];
                result = Math.min(dfs(count+1, infos, permutationValues, values, visited, result), result);
                visited[i] = false;
            }
        }
        return result;
    }
}
