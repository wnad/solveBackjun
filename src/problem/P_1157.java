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

            int count = countAlphabet[i];

            if (count==0)
                continue;

            if (max == count)
                isMaxAlone = false;

            if (max < count) {
                max = count;
                isMaxAlone = true;
                maxAlphabetNumber = i;
            }

        }

        if (isMaxAlone) {
            char charMax = (char) (maxAlphabetNumber + 'A');
            System.out.println(charMax);
        } else {
            System.out.println("?");
        }



    }

    public static int[] createAlphabetArray (String inputString){

        int[] countAlphabet = new int['z'-'a'+1];

        for ( int count=0; count<('z'-'a'+1); count++) {
            countAlphabet[count] = 0;
        }

        int stringLength = inputString.length();
        int isa = 'a';
        int isA = 'A';

        for (int count=0; count<stringLength; count++) {
            int charToInt = inputString.charAt(count);
            int position = 0;

            if (97 <= charToInt)
                position = charToInt-isa;

            if (charToInt < 97)
                position = charToInt-isA;

            countAlphabet[position] = countAlphabet[position] + 1;
        }

        return countAlphabet;

    }


}
