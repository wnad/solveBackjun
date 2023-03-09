package problem;

import java.io.*;

public class P_1316 implements Problem {

    /*
    문제
    그룹 단어란 단어에 존재하는 모든 문자에 대해서, 각 문자가 연속해서 나타나는 경우만을 말한다.
    예를 들면, ccazzzzbb는 c, a, z, b가 모두 연속해서 나타나고, kin도 k, i, n이 연속해서 나타나기 때문에 그룹 단어이지만,
    aabbbccb는 b가 떨어져서 나타나기 때문에 그룹 단어가 아니다.

    단어 N개를 입력으로 받아 그룹 단어의 개수를 출력하는 프로그램을 작성하시오.

    입력
    첫째 줄에 단어의 개수 N이 들어온다. N은 100보다 작거나 같은 자연수이다.
    둘째 줄부터 N개의 줄에 단어가 들어온다. 단어는 알파벳 소문자로만 되어있고 중복되지 않으며, 길이는 최대 100이다.

    출력
    첫째 줄에 그룹 단어의 개수를 출력한다.
     */

    @Override
    public void exec() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int countGroupWord = 0;

        for (int count=0; count<N; count++) {
            String word = bufferedReader.readLine();
            if (isGroupWord(word)) {
                countGroupWord++;
            }

        }

        String countGroup = String.valueOf(countGroupWord);

        bufferedWriter.write(countGroup);
        bufferedWriter.flush();
    }

    public static boolean isGroupWord(String word) {
        int[] alphabets = resetAlphabet();
        boolean isGroup = true;

        char currentChar = 0;

        for (int i=0; i<word.length(); i++) {
            if (i==0 || word.charAt(i) != currentChar){
                currentChar = word.charAt(i);
                alphabets[((word.charAt(i) - 'a'))] += 1;
            }

        }

        for ( int count : alphabets) {
            if ( count > 1 ) {
                isGroup = false;
                break;
            }
        }

        return isGroup;
    }

    public static int[] resetAlphabet() {
        int[] alphabets = new int[26];

        for (int i=0; i<26; i++) {
            alphabets[i] = 0;
        }

        return alphabets;
    }
}
