import java.io.*;
import java.util.*;

public class 6266_week2 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());// 회의실의 수
        int M = Integer.parseInt(st.nextToken());// 예약된 회의의 수

        Map<String, boolean[]> reservation = new HashMap<>();

        List<String> meetingRooms = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            meetingRooms.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String meetingRoom = st.nextToken();
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            boolean[] timeUsed = reservation.getOrDefault(meetingRoom, new boolean[19]);
            for (int j = start; j < end; j++) {
                timeUsed[j] = true;
            }

            reservation.put(meetingRoom, timeUsed);
        }

        Collections.sort(meetingRooms);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String meetingRoom = meetingRooms.get(i);
            boolean[] time = reservation.getOrDefault(meetingRoom, new boolean[19]);
            List<String> availableHours = new ArrayList<>();

            int last = 0;

            for (int j = 9; j <= 18; j++) {
                if (last == 0 && !time[j]) {
                    last = j;
                    continue;
                }

                if (last != 0 && time[j]) {
                    availableHours.add(String.format("%02d-%02d", last, j));
                    last = 0;
                }
            }

            if (last != 0 && last != 18) {
                availableHours.add(String.format("%02d-18", last));
            }

            sb.append("Room ").append(meetingRoom).append(":").append("\n");
            sb.append(availableHours.isEmpty() ? "Not available" : availableHours.size() + " available:").append("\n");
            for (String hourRange : availableHours) {
                sb.append(hourRange).append("\n");
            }
            if (i < N - 1) {
                sb.append("-----").append("\n");
            }
        }

        System.out.println(sb);
    }
}