package bronze;
import java.io.*;
public class Solution8393 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine().trim());
        int answer = 0;
        for (int i=1; i <= N; i++) {
            answer += i;
        }
        System.out.println(answer);
    }
}
