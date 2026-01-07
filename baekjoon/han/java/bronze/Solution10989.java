package bronze;

import java.io.*;
import  java.util.*;

public class Solution10989 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        List<Long> box = new ArrayList<>();
        for (long i=0; i <N; i++) {
            st = new StringTokenizer(br.readLine());
            long value = Long.parseLong(st.nextToken());
            box.add(value);
        }
        box.stream().sorted().forEach(System.out::println);
    }
}
