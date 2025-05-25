import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    private static PriorityQueue<Integer> lowerHip = new PriorityQueue<>(Collections.reverseOrder());
    private static PriorityQueue<Integer> upperHip = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder output = new StringBuilder();

        while(N-->0) {
            // 입력받은 숫자 힙에 넣기
            add(Integer.parseInt(br.readLine()));

            // 중간값 출력
            output.append(getMedian()).append("\n");
        }

        output.deleteCharAt(output.length() -1);

        System.out.print(output);

    }

    public static void add(int x) {

        // 입력받은 숫자 힙에 넣기
        if (lowerHip.isEmpty() || x<= lowerHip.peek()) {
            lowerHip.add(x);
        } else {
            upperHip.add(x);
        }

        // 힙 크기 조정 (중간값을 위해)
        if (lowerHip.size() > upperHip.size() + 1) {
            upperHip.add(lowerHip.poll());
        }

        if (upperHip.size() > lowerHip.size() + 1) {
            lowerHip.add(upperHip.poll());
        }

    }

    public static int getMedian() {

        // upper 가 많은 경우 upper 의 최솟값 출력
        if (lowerHip.size()<upperHip.size()) {
            return upperHip.peek();
        }

        // 그 외에는 lower 의 최댓값 출력
        return lowerHip.peek();
    }
}