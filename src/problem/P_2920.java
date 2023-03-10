package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_2920 implements Problem {

    /*
    문제
    다장조는 c d e f g a b C, 총 8개 음으로 이루어져있다.
    이 문제에서 8개 음은 다음과 같이 숫자로 바꾸어 표현한다. c는 1로, d는 2로, ..., C를 8로 바꾼다.

    1부터 8까지 차례대로 연주한다면 ascending, 8부터 1까지 차례대로 연주한다면 descending, 둘 다 아니라면 mixed 이다.

    연주한 순서가 주어졌을 때, 이것이 ascending인지, descending인지, 아니면 mixed인지 판별하는 프로그램을 작성하시오.

    입력
    첫째 줄에 8개 숫자가 주어진다. 이 숫자는 문제 설명에서 설명한 음이며, 1부터 8까지 숫자가 한 번씩 등장한다.

    출력
    첫째 줄에 ascending, descending, mixed 중 하나를 출력한다.
     */

    @Override
    public void exec() throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String inputString = bufferedReader.readLine();
        StringTokenizer scaleTokenizer = new StringTokenizer(inputString);

        boolean isascending = true;
        boolean isdescending = true;
        boolean ismixed = true;
        int cursorNote = Integer.parseInt(scaleTokenizer.nextToken());

        for (int i=0; i<7; i++) {
            int note = Integer.parseInt(scaleTokenizer.nextToken());

            if (cursorNote<note) isdescending = false;
            if (note<cursorNote) isascending = false;

            cursorNote = note;

        }

        if (isascending || isdescending)    ismixed = false;

        if (isascending)
            System.out.println("ascending");

        if (isdescending)
            System.out.println("descending");

        if (ismixed)
            System.out.println("mixed");

    }
}
