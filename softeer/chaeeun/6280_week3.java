import java.io.*;
import java.util.*;

public class 6280_week3 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int row = 2;
        for(int i = 1; i <= N; i++) {
            row = row + (row - 1);
        }

        System.out.println(row * row);
    }
}