package problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class P_1764 implements Problem {

    /*
    문제
    김진영이 듣도 못한 사람의 명단과, 보도 못한 사람의 명단이 주어질 때, 듣도 보도 못한 사람의 명단을 구하는 프로그램을 작성하시오.

    입력
    첫째 줄에 듣도 못한 사람의 수 N, 보도 못한 사람의 수 M이 주어진다.
    이어서 둘째 줄부터 N개의 줄에 걸쳐 듣도 못한 사람의 이름과, N+2째 줄부터 보도 못한 사람의 이름이 순서대로 주어진다.
    이름은 띄어쓰기 없이 알파벳 소문자로만 이루어지며, 그 길이는 20 이하이다. N, M은 500,000 이하의 자연수이다.

    듣도 못한 사람의 명단에는 중복되는 이름이 없으며, 보도 못한 사람의 명단도 마찬가지이다.

    출력
    듣보잡의 수와 그 명단을 사전순으로 출력한다.
     */

    public static List<String> input = List.of(
            "3 4\n" +
                    "ohhenrie\n" +
                    "charlie\n" +
                    "baesangwook\n" +
                    "obama\n" +
                    "baesangwook\n" +
                    "ohhenrie\n" +
                    "clinton"
    );

    public static List<String> output = List.of(
            "2\n" +
                    "baesangwook\n" +
                    "ohhenrie");


    @Override
    public void exec() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");

        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        HashSet<String> notListens = new HashSet<>();

        String name;

        List<String> result = new ArrayList<>();

        while(N-->0) {
            notListens.add(br.readLine());
        }

        while(M-->0) {
            name = br.readLine();

            if (notListens.contains(name)) {
                result.add(name);
            }
        }

        Collections.sort(result);

        StringBuilder sb = new StringBuilder();

        sb.append(result.size()).append("\n");

        for (String e : result) {
            sb.append(e).append("\n");
        }

        sb.deleteCharAt(sb.length()-1);

        System.out.print(sb);
    }
}
