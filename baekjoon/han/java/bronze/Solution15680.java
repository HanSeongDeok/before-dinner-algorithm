package bronze;
import java.io.*;

/**
 * BAEKJOON
 * 15680. 연세대학교
 */
public class Solution15680 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(N == 0 ? "YONSEI" : "Leading the Way to the Future");
    }
}