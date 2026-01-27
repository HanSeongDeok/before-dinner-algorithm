package bronze;
import java.io.*;
import java.math.BigInteger;

/**
 * 분할정복 곱셈(Product Tree)
 */
public class Solution27434 {
    static BigInteger product(int l, int r) {
        if (l > r) return BigInteger.ONE;
        if (l == r) return BigInteger.valueOf(l);
        if (r - l == 1) return BigInteger.valueOf(l).multiply(BigInteger.valueOf(r));

        int m = (l + r) >>> 1;
        return product(l, m).multiply(product(m + 1, r));
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        if (n == 0) {
            System.out.print(1);
            return;
        }

        System.out.print(product(1, n));
    }
}
