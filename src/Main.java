import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer input = new StringTokenizer(br.readLine());


        // 주어진 숫자
        int N = Integer.parseInt(input.nextToken());

        // B 진법
        int B = Integer.parseInt(input.nextToken());

        StringBuilder result = new StringBuilder();


        // 1. N이 0이 될때까지 반복
        while (0<N) {

            // 2. N 을 B로 나누기
            int remain = N%B;

            // 0~9 사이라면
            if (remain<10) {
                result.append(remain);
            } else {
                // 10 이상이라면
                // 10 -> 'A' = 65
                result.append((char) (remain+55));
            }

            N/=B;

        }

        System.out.print(result.reverse());

    }
}