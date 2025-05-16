package problem;

import java.util.Arrays;
import java.util.List;

import static problem.Read.*;


public class P_18110 implements Problem {

    /*
    문제
    solved.ac는 Sogang ICPC Team 학회원들의 알고리즘 공부에 도움을 주고자 만든 서비스이다.
    지금은 서강대뿐만 아니라 수많은 사람들이 solved.ac의 도움을 받아 알고리즘 공부를 하고 있다.



    ICPC Team은 백준 온라인 저지에서 문제풀이를 연습하는데,
    백준 온라인 저지의 문제들에는 난이도 표기가 없어서,
    지금까지는 다양한 문제를 풀어 보고 싶더라도 난이도를 가늠하기 어려워 무슨 문제를 풀어야 할지 판단하기 곤란했기 때문에 solved.ac가 만들어졌다.
    solved.ac가 생긴 이후 전국에서 200명 이상의 기여자 분들께서 소중한 난이도 의견을 공유해 주셨고, 지금은 약 7,000문제에 난이도 표기가 붙게 되었다.

    어떤 문제의 난이도는 그 문제를 푼 사람들이 제출한 난이도 의견을 바탕으로 결정한다.
    난이도 의견은 그 사용자가 생각한 난이도를 의미하는 정수 하나로 주어진다.
    solved.ac가 사용자들의 의견을 바탕으로 난이도를 결정하는 방식은 다음과 같다.

    아직 아무 의견이 없다면 문제의 난이도는 0으로 결정한다.
    의견이 하나 이상 있다면, 문제의 난이도는 모든 사람의 난이도 의견의 30% 절사평균으로 결정한다.
    절사평균이란 극단적인 값들이 평균을 왜곡하는 것을 막기 위해 가장 큰 값들과 가장 작은 값들을 제외하고 평균을 내는 것을 말한다.
    30% 절사평균의 경우 위에서 15%, 아래에서 15%를 각각 제외하고 평균을 계산한다.
    따라서 20명이 투표했다면, 가장 높은 난이도에 투표한 3명과 가장 낮은 난이도에 투표한 3명의 투표는 평균 계산에 반영하지 않는다는 것이다.

    제외되는 사람의 수는 위, 아래에서 각각 반올림한다.
    25명이 투표한 경우 위, 아래에서 각각 3.75명을 제외해야 하는데,
    이 경우 반올림해 4명씩을 제외한다.

    마지막으로, 계산된 평균도 정수로 반올림된다.
    절사평균이 16.7이었다면 최종 난이도는 17이 된다.

    사용자들이 어떤 문제에 제출한 난이도 의견 목록이 주어질 때, solved.ac가 결정한 문제의 난이도를 계산하는 프로그램을 작성하시오.

    입력
    첫 번째 줄에 난이도 의견의 개수 n이 주어진다. (0 ≤ n ≤ 3 × 105)
    이후 두 번째 줄부터 1 + n번째 줄까지 사용자들이 제출한 난이도 의견 n개가 한 줄에 하나씩 주어진다.
    모든 난이도 의견은 1 이상 30 이하이다.

    출력
    solved.ac가 계산한 문제의 난이도를 출력한다.

    예제 입력 1
    5
    1
    5
    5
    7
    8

    예제 출력 1
    6

    5명의 15%는 0.75명으로, 이를 반올림하면 1명이다.
    따라서 solved.ac는 가장 높은 난이도 의견과 가장 낮은 난이도 의견을 하나씩 제외하고, {5, 5, 7}에 대한 평균으로 문제 난이도를 결정한다.

    예제 입력 2
    10
    1
    13
    12
    15
    3
    16
    13
    12
    14
    15

    예제 출력 2
    13
     */

    public static List<String> input = List.of("5\n" + "1\n" + "5\n" + "5\n" + "7\n" + "8",
            "10\n" + "1\n" + "13\n" + "12\n" + "15\n" + "3\n" + "16\n" + "13\n" + "12\n" + "14\n" + "15");
    public static List<String> output = List.of("6","13");

    @Override
    public void exec() throws Exception {
        int N = readInt();
        int score;
        int sum = 0;

        int[] difficulties = new int[N];

        for (int i=0; i<N; i++) {
            score = readInt();
            difficulties[i] = score;
            sum += score;
        }

        Arrays.sort(difficulties);

        // 15%의 절사 평균할 난이도 개수
        int exclude = (int) Math.round(N * 0.15);

        // 절사 평균될 난이도 제외
        for (int j=0; j<exclude; j++) {
            sum -= difficulties[j]+difficulties[N-1-j];
        }

        int average = Math.round((float) sum / (N - 2 * exclude));

        System.out.print(average);
    }
}
