import java.io.*;
import java.util.*;

public class 2609_week1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int gcd = a > b ? getGCD(a, b) : getGCD(b, a);
        int lcm = getLCM(a, b ,gcd);

        System.out.println(gcd);
        System.out.println(lcm);
    }

    // 최대공약수
    static int getGCD(int a, int b) {
        while(b > 0) {
            int temp = a;
            a = b;
            b = temp % b;
        }

        return a;
    }

    // 최소공배수
    static int getLCM(int a, int b, int gcd) {
        return a * b / gcd;
    }
}