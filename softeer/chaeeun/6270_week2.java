import java.io.*;
import java.util.*;

public class 6270_week2 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] limitArr = new int[101];
        int curr = 1;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int section = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            for (int j = curr; j < curr + section; j++) {
                limitArr[j] = speed;
            }
            curr = curr + section;
        }

        int result = 0;
        curr = 1;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int section = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            for (int j = curr; j < curr + section; j++) {
                result = Math.max(result, speed - limitArr[j]);
            }
            curr = curr + section;
        }

        System.out.println(result);
    }
}