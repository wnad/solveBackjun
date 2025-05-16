package problem;

import java.io.*;
import java.util.*;

public class P_2751 implements Problem {

    /*
    문제
    N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

    입력
    첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다. 이 수는 절댓값이 1,000,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.

    출력
    첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.

    예제 입력 1
5
5
4
3
2
1

    예제 출력 1
1
2
3
4
5

     */

    @Override
    public void exec() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        // 1. 수의 개수 입력
        int size = Integer.parseInt(bufferedReader.readLine());

        // 2. 숫자 리스트 선언
        List<Integer> numberList = new ArrayList<>();

        // 3. 입력받은 수를 리스트에 저장
        for (int i=0; i< size; i++) {
            numberList.add(Integer.parseInt(bufferedReader.readLine()));
        }

        bufferedReader.close();

        // 4. 리스트를 오름차순으로 정렬
        Collections.sort(numberList);

        // 5. 정렬된 리스트를 출력
        StringBuilder output = new StringBuilder();
        numberList.forEach(num -> output.append(num).append("\n"));
        System.out.println(output);
    }
}
