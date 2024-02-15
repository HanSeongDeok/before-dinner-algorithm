import java.io.*;
import java.util.*;

public class 6254_week2 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int result = 0;
        for(int i = 1; i <= 5; i++) {
            st = new StringTokenizer(br.readLine());
            String start = st.nextToken();
            String end = st.nextToken();

            String[] startArr = start.split(":");
            String[] endArr = end.split(":");

            int hour = Integer.parseInt(endArr[0]) - Integer.parseInt(startArr[0]);
            int minute = Integer.parseInt(endArr[1]) - Integer.parseInt(startArr[1]);

            result += hour * 60 + minute;
        }
        System.out.println(result);
    }
}