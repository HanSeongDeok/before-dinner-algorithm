package bronze;

import java.time.*;

/**
 * BAEKJOON
 * 16170. 오늘의 날짜는?
 */
public class Solution16170 {
    public static void main(String[] args) {
        ZonedDateTime utcNow = ZonedDateTime.now(ZoneOffset.UTC);
        // System.out.println(utcNow);
        System.out.println(utcNow.getYear());
        System.out.println(String.format("%02d", utcNow.getMonthValue()));
        System.out.println(String.format("%02d", utcNow.getDayOfMonth()));
    }
}
