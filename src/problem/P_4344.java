package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_4344 implements Problem {

    /*
    문제
    대학생 새내기들의 90%는 자신이 반에서 평균은 넘는다고 생각한다.
    당신은 그들에게 슬픈 진실을 알려줘야 한다.

    입력
    첫째 줄에는 테스트 케이스의 개수 C가 주어진다.

    둘째 줄부터 각 테스트 케이스마다 학생의 수 N(1 ≤ N ≤ 1000, N은 정수)이 첫 수로 주어지고, 이어서 N명의 점수가 주어진다.
    점수는 0보다 크거나 같고, 100보다 작거나 같은 정수이다.

    출력
    각 케이스마다 한 줄씩 평균을 넘는 학생들의 비율을 반올림하여 소수점 셋째 자리까지 출력한다.
     */

    @Override
    public void exec() throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int C = Integer.parseInt(bufferedReader.readLine());

        for (int test = 0; test<C; test++) {
            StringTokenizer gradeTokenizer = new StringTokenizer(bufferedReader.readLine());
            int students = Integer.parseInt(gradeTokenizer.nextToken());

            execPercent(students, gradeTokenizer);

        }

    }

    public static void execPercent(int numberStudent, StringTokenizer stringGrade) {

        int[] grades = new int[numberStudent];

        float sumGrade = 0;

        for (int count = 0; count<numberStudent; count++) {
            int grade = Integer.parseInt(stringGrade.nextToken());
            grades[count] = grade;
            sumGrade += grade;
        }

        execAvg(numberStudent, sumGrade, grades);

    }

    public static void execAvg (int numberStudent, float sumGrade, int[] grades) {

        float avgGrade = sumGrade/numberStudent;

        int overAvgStudent = 0;

        for (int grade : grades) {
            if (avgGrade<grade)
                overAvgStudent += 1;
        }

        Double percentage = (double)overAvgStudent/numberStudent*100;

        System.out.println(String.format("%.3f", percentage)+"%");

    }
}
