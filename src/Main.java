import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> minHip = new PriorityQueue<>();

        StringBuilder result = new StringBuilder();

        // 연산 횟수
        int N = Integer.parseInt(br.readLine());

        // 입력 받는 자연수
        int num;

        while (N-- > 0) {
            num = Integer.parseInt(br.readLine());

            // 0이면 출력, 없을 경우 예외처리
            if (num==0) {
                if (minHip.isEmpty()) {
                    result.append(0).append("\n");
                } else {
                    result.append(minHip.poll()).append("\n");
                }
            } else {
                minHip.add(num);
            }
        }

        result.deleteCharAt(result.length() -1);

        System.out.print(result);
    }
}