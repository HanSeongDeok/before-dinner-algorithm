import java.io.*;
import java.util.*;

public class 6288_week2 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        ArrayList<int[]> metals = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            metals.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        Collections.sort(metals, (o1, o2) -> o2[1] - o1[1]);

        int answer = 0;

        for(int[] metal: metals) {
            if(W <= metal[0]) {
                answer += W * metal[1];
                break;
            } else {
                answer += metal[0] * metal[1];
                W -= metal[0];
            }
        }

        System.out.println(answer);
    }
}