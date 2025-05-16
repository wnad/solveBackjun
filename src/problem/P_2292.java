package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_2292 implements Problem{


    /*

    문제

    위의 그림과 같이 육각형으로 이루어진 벌집이 있다. 
    그림에서 보는 바와 같이 중앙의 방 1부터 시작해서 이웃하는 방에 돌아가면서 1씩 증가하는 번호를 주소로 매길 수 있다. 
    숫자 N이 주어졌을 때, 벌집의 중앙 1에서 N번 방까지 최소 개수의 방을 지나서 갈 때 몇 개의 방을 지나가는지(시작과 끝을 포함하여)를 계산하는 프로그램을 작성하시오. 
    예를 들면, 13까지는 3개, 58까지는 5개를 지난다.

    입력
    첫째 줄에 N(1 ≤ N ≤ 1,000,000,000)이 주어진다.

    출력
    입력으로 주어진 방까지 최소 개수의 방을 지나서 갈 때 몇 개의 방을 지나는지 출력한다.

    예제 입력 13
    예제 출력 3 

     */


    @Override
    public void exec() throws IOException {


        // 방번호 N 입력 받기
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int roomNumber = Integer.parseInt(bufferedReader.readLine());

        bufferedReader.close();


        /**
         * 
         *  1 = 1
         *  2 = ~7  (6)
         *  3 = ~19 (12)
         *  4 = ~37 (18)
         *  5 = ~61 (24)
         *  6 = ~91 (30)
         * 
         *  ...
         * 
         *  N = (1 + 6*1 + 6*2 + ... + 6*(N-2)) ~ (1 + 6*1 + 6*2 + ... + 6*(N-1))
         * 
         *  방번호 N 을 받았을 떄 1 부터 6의 배수만큼 더해준다.
         * 
         *  1, 7, 19, 37, 61, 91, ...
         *  
         */

        int count = 0;
        int endNumber = 1;

        do {
            endNumber += 6 * count;
            count++;
        } while (endNumber < roomNumber);

        System.out.println(count);

    }


}
