import java.io.*;
import java.util.*;

public class 2960_week1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[] isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);

        int count = 0;
        int result = 0;
        boolean flag = true;
        for(int i = 2; flag && i <= N ; i++) {
            if(!isPrime[i]) continue;
            for(int j = i; j <= N; j += i) {
                if(!isPrime[j]) continue;

                count++;
                isPrime[j] = false;
                if(count == K) {
                    result = j;
                    flag = false;
                    break;
                }
            }
        }
        System.out.println(result);
    }
}
