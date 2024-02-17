import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        Long A;
        int n;

        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            A = Long.parseLong(st.nextToken());
            n = Integer.parseInt(st.nextToken());

            String str = Long.toString(A, n);
            int len = str.length();
            boolean isPalindrome = true;
            for(int i = 0; i <= len/2; i++) {
                if(str.charAt(i) != str.charAt(len - i - 1)) {
                    isPalindrome = false;
                    break;
                }
            }
            sb.append(isPalindrome ? 1 : 0).append("\n");
        }
        System.out.print(sb);
    }
}
