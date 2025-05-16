package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P_11866 implements Problem {

    /*

    문제
    요세푸스 문제는 다음과 같다.

    1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 양의 정수 K(≤ N)가 주어진다.
    이제 순서대로 K번째 사람을 제거한다.
    한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다.
    이 과정은 N명의 사람이 모두 제거될 때까지 계속된다.
    원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라고 한다.
    예를 들어 (7, 3)-요세푸스 순열은 <3, 6, 2, 7, 5, 1, 4>이다.

    N과 K가 주어지면 (N, K)-요세푸스 순열을 구하는 프로그램을 작성하시오.

    입력
    첫째 줄에 N과 K가 빈 칸을 사이에 두고 순서대로 주어진다. (1 ≤ K ≤ N ≤ 1,000)

    출력
    예제와 같이 요세푸스 순열을 출력한다.

    예제 입력 1
    7 3

    예제 출력 1
    <3, 6, 2, 7, 5, 1, 4>

     */

    public static List<String> input = List.of("7 3", "10 3");
    public static List<String> output = List.of("<3, 6, 2, 7, 5, 1, 4>", "<3, 6, 9, 2, 7, 1, 8, 5, 10, 4>");

    @Override
    public void exec() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        // 1. 자연수 N 과 정수 K 입력받기.
        StringTokenizer input = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(input.nextToken());
        int K = Integer.parseInt(input.nextToken());

        bufferedReader.close();

        // 2. 1~N 리스트 채워넣기
        LinkedList<Integer> circle = new LinkedList<>();
        for (int i=1; i<=N; i++) {
            circle.add(i);
        }

        StringBuilder output = new StringBuilder();

        output.append("<");
        int index = K - 1;
        while (!circle.isEmpty()) {
            output.append(circle.remove(index));

            if (!circle.isEmpty()) {
                output.append(", ");
                index = (index + K - 1) % circle.size();
            }
        }
        output.append(">");
        System.out.print(output);

    }
}
