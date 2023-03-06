package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_1157 implements Problem {

    /*
    문제
    알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오.
    단, 대문자와 소문자를 구분하지 않는다.

    입력
    첫째 줄에 알파벳 대소문자로 이루어진 단어가 주어진다.
    주어지는 단어의 길이는 1,000,000을 넘지 않는다.

    출력
    첫째 줄에 이 단어에서 가장 많이 사용된 알파벳을 대문자로 출력한다.
    단, 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력한다.
     */

    @Override
    public void exec() throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int[] countAlphabet;
        int max = 0;
        boolean isMaxAlone = false;
        int maxAlphabetNumber = 0;

        String inputString = bufferedReader.readLine();

        countAlphabet = createAlphabetArray(inputString);

        for (int i=0; i<countAlphabet.length; i++) {
            int intoAlphabet = countAlphabet[i];

            if (max < intoAlphabet) {
                max = intoAlphabet;
                isMaxAlone = true;
                maxAlphabetNumber = i;
            }

            if (max == intoAlphabet)
                isMaxAlone = false;

        }

        if (isMaxAlone) {
            char c= Character.forDigit(maxAlphabetNumber, 10);
            char output = c;
            System.out.println();
        } else {
            System.out.println("?");
        }

    }

    public static int[] createAlphabetArray (String inputString){

        int[] countAlphabet = new int['z'-'a'+1];
        int stringLength = inputString.length();

        for (int count=0; count<stringLength; count++) {
            char stringToChar = inputString.charAt(count);
            int charToInt = stringToChar;

            if (97 <= charToInt)
                charToInt = charToInt-'a';

            if (charToInt < 97)
                charToInt = charToInt - 'A';

            countAlphabet[charToInt] += 1;
        }

        return countAlphabet;

    }
}
