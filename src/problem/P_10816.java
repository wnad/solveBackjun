package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P_10816 implements Problem {

    /*

문제
숫자 카드는 정수 하나가 적혀져 있는 카드이다.
상근이는 숫자 카드 N개를 가지고 있다.
 정수 M개가 주어졌을 때, 이 수가 적혀있는 숫자 카드를 상근이가 몇 개 가지고 있는지 구하는 프로그램을 작성하시오.

입력
첫째 줄에 상근이가 가지고 있는 숫자 카드의 개수 N(1 ≤ N ≤ 500,000)이 주어진다.
둘째 줄에는 숫자 카드에 적혀있는 정수가 주어진다.
숫자 카드에 적혀있는 수는 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다.

셋째 줄에는 M(1 ≤ M ≤ 500,000)이 주어진다.
넷째 줄에는 상근이가 몇 개 가지고 있는 숫자 카드인지 구해야 할 M개의 정수가 주어지며, 이 수는 공백으로 구분되어져 있다.
이 수도 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다.

출력
첫째 줄에 입력으로 주어진 M개의 수에 대해서, 각 수가 적힌 숫자 카드를 상근이가 몇 개 가지고 있는지를 공백으로 구분해 출력한다.

예제 입력 1
10
6 3 2 10 10 10 -10 -10 7 3
8
10 9 -5 2 3 4 5 -10

예제 출력 1
3 0 0 1 2 0 0 2
     */

    @Override
    public void exec() throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        // 1. 상근이가 가지고있는 카드 입력
        int cardAmount = Integer.parseInt(bufferedReader.readLine());


        // 2. 상근이가 가지고있는 카드를 저장할 배열 선언
        int[] skCardArray = new int[20000001];


        // 3. 상근이가 가지고있는 카드를 배열에 카운트
        StringTokenizer skCardInput = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < cardAmount; i++) {
            skCardArray[Integer.parseInt(skCardInput.nextToken()) + 10000000]++;
        }


        // 4. 찾고싶은 카드 입력
        int findCardAmount = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer findCardString = new StringTokenizer(bufferedReader.readLine());

        bufferedReader.close();

        // 5. 찾고싶은 카드 개수 찾기
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < findCardAmount; i++) {
            output.append(skCardArray[Integer.parseInt(findCardString.nextToken()) + 10000000]).append(" ");
        }


        // 6. 카드 수 출력
        System.out.println(output);

    }
}
