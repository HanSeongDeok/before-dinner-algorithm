import java.util.*;
import java.io.*;

public class 14561_week1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        boolean[] isPrimeArr = new boolean[N + 1];
        Arrays.fill(isPrimeArr, true);
        isPrimeArr[1] = false;

        for(int i = 2; i <= Math.sqrt(N); i++) {
            if(!isPrimeArr[i]) continue;
            for(int j = i * i; j <= N; j = j + i) {
                isPrimeArr[j] = false;
            }
        }

        for(int i = M; i <= N; i++) {
            if(isPrimeArr[i]) {
                System.out.println(i);
            }
        }
    }
}