package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P_2108 implements Problem{


    /*

    문제
    수를 처리하는 것은 통계학에서 상당히 중요한 일이다. 통계학에서 N개의 수를 대표하는 기본 통계값에는 다음과 같은 것들이 있다. 단, N은 홀수라고 가정하자.

    1. 산술평균 : N개의 수들의 합을 N으로 나눈 값
    2. 중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
    3. 최빈값 : N개의 수들 중 가장 많이 나타나는 값
    4. 범위 : N개의 수들 중 최댓값과 최솟값의 차이
    N개의 수가 주어졌을 때, 네 가지 기본 통계값을 구하는 프로그램을 작성하시오.

    입력
    첫째 줄에 수의 개수 N(1 ≤ N ≤ 500,000)이 주어진다. 단, N은 홀수이다. 그 다음 N개의 줄에는 정수들이 주어진다. 입력되는 정수의 절댓값은 4,000을 넘지 않는다.

    출력
    첫째 줄에는 산술평균을 출력한다. 소수점 이하 첫째 자리에서 반올림한 값을 출력한다.

    둘째 줄에는 중앙값을 출력한다.

    셋째 줄에는 최빈값을 출력한다. 여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력한다.

    넷째 줄에는 범위를 출력한다.
     */

    public static List<String> input = List.of( "5\n" + "1\n" + "3\n" + "8\n" + "-2\n" + "2",
                                                "1\n" + "4000\n",
                                                "5\n" + "-1\n" + "-2\n" + "-3\n" + "-1\n" + "-2\n",
                                                "3\n" + "0\n" + "0\n" + "-1\n");
    public static List<String> output = List.of("2\n" + "2\n" + "1\n" + "10",
                                                "4000\n" + "4000\n" + "4000\n" + "0",
                                                "-2\n" + "-2\n" + "-1\n" + "2",
                                                "0\n" + "0\n" + "0\n" + "1");

    public static int MEDIAN = 0;
    public static int MODE = 0;

    @Override
    public void exec() throws IOException {

        // 수의 개수 N 입력 받기
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());

        // 입력 받을 숫자 카운트 배열 생성

        int[] counter = new int[8001];

        // 입력받은 수의 총합 변수 선언
        int sum = 0;

        int number;

        int max = -4001;
        int min = 4001;

        // 입력 받은 수 리스트에 추가
        for (int i=0; i<N; i++) {
            number = Integer.parseInt(bufferedReader.readLine());

            // number 를 sum 에 저장
            sum += number;

            // 입력된 숫자 counter 배열 크기 증가
            counter[number + 4000] ++;

            // 최대값 업데이트
            if (number > max) {
                max = number;
            }

            // 최소값 업데이트
            if (number < min) {
                min = number;
            }
        }

        bufferedReader.close();

        // 산술평균 계산
        int avg = Math.round((float) sum / N);

        // 범위 찾기
        int range = max - min;

        // mode, median 계산
        setModeAndMedian(counter, min, max, N);

        // 결과 출력
        System.out.print(avg + "\n" + MEDIAN + "\n" + MODE + "\n" + range);

    }


    // 최빈값 찾는 함수
    public static void setModeAndMedian(int[] counter, int min, int max, int N) {

        // 입력된 숫자의 개수, 0으로 초기화
        int count = 0;

        // 중앙값 선언, 4001로 초기화
        int median = 4001;

        // 최빈값 선언
        int mode = -4001;

        // 최빈값이 입력된 횟수
        int modeCount = 0;

        // 최빈값이 중복이 되었는지 확인
        boolean modeDuplicated = false;

        // min 에서 max 까지 반복
        for (int i=min + 4000; i < max + 4001; i++) {
            // 입력받은 숫자만 계산
            if (counter[i] > 0) {

                count += counter[i];

                // median 이 초기값이고 count 가 입력받은 개수보다 넘었을 때의 숫자가 중앙값
                if (median == 4001 && count > N/2) {
                    median = i - 4000;
                }

                // 최빈값의 횟수보다 많은 경우 i를 mode 로 업데이트
                if (counter[i] > modeCount) {
                    mode = i - 4000;
                    modeCount = counter[i];
                    modeDuplicated = false;

                    // 최빈값의 횟수가 동일하고 modeDuplicated가 거짓일 때
                    // 두번째로 작은 값을 mode 로 업데이트후 modeDuplicated 를 참으로 변경
                } else if (counter[i] == modeCount && !modeDuplicated){
                    mode = i - 4000;
                    modeDuplicated = true;
                }
            }
        }

        MODE = mode;
        MEDIAN = median;

    }

}