package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P_1152 implements Problem {

    /*
    문제
    영어 대소문자와 공백으로 이루어진 문자열이 주어진다. 이 문자열에는 몇 개의 단어가 있을까?
    이를 구하는 프로그램을 작성하시오. 단, 한 단어가 여러 번 등장하면 등장한 횟수만큼 모두 세어야 한다.

    입력
    첫 줄에 영어 대소문자와 공백으로 이루어진 문자열이 주어진다. 이 문자열의 길이는 1,000,000을 넘지 않는다.
    단어는 공백 한 개로 구분되며, 공백이 연속해서 나오는 경우는 없다. 또한 문자열은 공백으로 시작하거나 끝날 수 있다.

    출력
    첫째 줄에 단어의 개수를 출력한다.
     */
    @Override
    public void exec() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String inputString = bufferedReader.readLine();

        String noblankString = inputString.strip();

        StringTokenizer result = new StringTokenizer(noblankString);

        List<String> words = new ArrayList<>();
        while (result.hasMoreTokens()) {
            words.add(result.nextToken());
        }

        System.out.println(words.size());

    }
}
