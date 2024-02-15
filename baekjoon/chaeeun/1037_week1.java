import java.io.*;
import java.util.*;

public class 1037_week1 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int count = Integer.parseInt(br.readLine());    // N의 약수 개수
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[count];

        for(int i = 0; i < count; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        System.out.println(arr[0] * arr[count - 1]);
    }
}
