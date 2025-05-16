package problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class P_11723 implements Problem {

    /*
    문제
    비어있는 공집합 S가 주어졌을 때, 아래 연산을 수행하는 프로그램을 작성하시오.

    add x: S에 x를 추가한다. (1 ≤ x ≤ 20) S에 x가 이미 있는 경우에는 연산을 무시한다.
    remove x: S에서 x를 제거한다. (1 ≤ x ≤ 20) S에 x가 없는 경우에는 연산을 무시한다.
    check x: S에 x가 있으면 1을, 없으면 0을 출력한다. (1 ≤ x ≤ 20)
    toggle x: S에 x가 있으면 x를 제거하고, 없으면 x를 추가한다. (1 ≤ x ≤ 20)
    all: S를 {1, 2, ..., 20} 으로 바꾼다.
    empty: S를 공집합으로 바꾼다.

    입력
    첫째 줄에 수행해야 하는 연산의 수 M (1 ≤ M ≤ 3,000,000)이 주어진다.

    둘째 줄부터 M개의 줄에 수행해야 하는 연산이 한 줄에 하나씩 주어진다.

    출력
    check 연산이 주어질때마다, 결과를 출력한다.
     */

    public static List<String> input = List.of(
            "26\n" +
                    "add 1\n" +
                    "add 2\n" +
                    "check 1\n" +
                    "check 2\n" +
                    "check 3\n" +
                    "remove 2\n" +
                    "check 1\n" +
                    "check 2\n" +
                    "toggle 3\n" +
                    "check 1\n" +
                    "check 2\n" +
                    "check 3\n" +
                    "check 4\n" +
                    "all\n" +
                    "check 10\n" +
                    "check 20\n" +
                    "toggle 10\n" +
                    "remove 20\n" +
                    "check 10\n" +
                    "check 20\n" +
                    "empty\n" +
                    "check 1\n" +
                    "toggle 1\n" +
                    "check 1\n" +
                    "toggle 1\n" +
                    "check 1"
    );
    public static List<String> output = List.of(
            "1\n" +
                    "1\n" +
                    "0\n" +
                    "1\n" +
                    "0\n" +
                    "1\n" +
                    "0\n" +
                    "1\n" +
                    "0\n" +
                    "1\n" +
                    "1\n" +
                    "0\n" +
                    "0\n" +
                    "0\n" +
                    "1\n" +
                    "0");


    static boolean[] S;
    static StringBuilder result;

    @Override
    public void exec() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());

        String[] cmdLine;

        S = new boolean[20];

        result = new StringBuilder();

        for (int i=0; i<M; i++) {
            cmdLine = br.readLine().split(" ");

            switch (cmdLine[0]) {
                case "add":
                    add(Integer.parseInt(cmdLine[1]));
                    break;
                case "remove":
                    remove(Integer.parseInt(cmdLine[1]));
                    break;
                case "check":
                    check(Integer.parseInt(cmdLine[1]));
                    break;
                case "toggle":
                    toggle(Integer.parseInt(cmdLine[1]));
                    break;
                case "all":
                    all();
                    break;
                case "empty":
                    empty();
                    break;
            }
        }

        result.deleteCharAt(result.length()-1);

        System.out.print(result);
    }

    private static void add(int element) {
        S[element-1] = true;
    }

    private static void remove(int element) {
        S[element-1] = false;
    }

    private static void check(int element) {
        if (S[element-1]) {
            result.append(1).append("\n");
        } else {
            result.append(0).append("\n");
        }
    }

    private static void toggle(int element) {
        S[element-1] = !S[element - 1];
    }

    private static void all() {
        for (int i=0; i<20; i++) {
            S[i] = true;
        }
    }

    private static void empty() {
        for (int i=0; i<20; i++) {
            S[i] = false;
        }
    }
}
