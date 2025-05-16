package problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class P_10989 implements Problem {

    /*
    문제
    N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

    입력
    첫째 줄에 수의 개수 N(1 ≤ N ≤ 10,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다. 이 수는 10,000보다 작거나 같은 자연수이다.

    출력
    첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
     */

    public static List<String> input = List.of("10\n" + "5\n" + "2\n" + "3\n" + "1\n" + "4\n" + "2\n" + "3\n" + "5\n" + "1\n" + "7");
    public static List<String> output = List.of("1\n" + "1\n" + "2\n" + "2\n" + "3\n" + "3\n" + "4\n" + "5\n" + "5\n" + "7");

    @Override
    public void exec() throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());

        // 입력받은 숫자를 카운트 해줄 배열
        int [] count = new int[10001];

        for (int i=0; i<N; i++) {
            count[Integer.parseInt(bufferedReader.readLine())] ++;
        }

        StringBuilder output = new StringBuilder();

        for (int i=1; i<10001; i++) {
            while(count[i] > 0) {
                output.append(i).append('\n');
                count[i]--;
            }
        }
        System.out.print(output.toString().trim());
    }
}
