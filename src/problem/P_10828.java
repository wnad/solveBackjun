package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;

public class P_10828 implements Problem {

    /*
문제
정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.

명령은 총 다섯 가지이다.

push X: 정수 X를 스택에 넣는 연산이다.
pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 스택에 들어있는 정수의 개수를 출력한다.
empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.

입력
첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다.
둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다.
주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다. 문제에 나와있지 않은 명령이 주어지는 경우는 없다.

출력
출력해야하는 명령이 주어질 때마다, 한 줄에 하나씩 출력한다.

예제 입력 1
14
push 1
push 2
top
size
empty
pop
pop
pop
size
empty
pop
push 3
empty
top

예제 출력 1
2
2
0
2
1
-1
0
1
-1
0
3

예제 입력 2
7
pop
top
push 123
top
pop
top
pop

예제 출력 2
-1
-1
123
123
-1
-1
     */

    private static final int[] EMPTY_ARRAY = {};    // 빈 배열

    private int[] array;    // 요소를 담을 배열
    private int size;    // 요소 개수

    public P_10828() {
        this.array = new int[10];
        this.size = 0;
    }

    // 정수 X를 스택에 넣는 연산
    public void push(int number) {
        resize();
        array[size++] = number;
    }

    // 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    public int pop() {

        // 스택이 비어있다면 -1 반환
        if (size == 0) {
            return -1;
        }

        return array[--size];
    }

    // 스택에 들어있는 정수의 개수를 출력한다.
    public int size() {
        return size;
    }

    // top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    public int top() {

        // 스택이 비어있다면 -1 반환
        if (size == 0) {
            return -1;
        }

        return array[size-1];
    }

    // empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
    public int empty() {
        return size==0 ? 1 : 0;
    }

    // 스택의 사이즈 변경
    private void resize() {
        if (size == array.length) {
            int[] newArray = new int[array.length * 2];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
    }

    @Override
    public void exec() throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        // 입력받을 명령어 수
        int N = Integer.parseInt(bufferedReader.readLine());

        String command;

        P_10828 stack = new P_10828();
        StringBuilder output = new StringBuilder();

        for (int i=0; i<N; i++) {
            StringTokenizer commandLine = new StringTokenizer(bufferedReader.readLine());
            command = commandLine.nextToken();

            if (Objects.equals(command, "push")) {
                stack.push(Integer.parseInt(commandLine.nextToken()));
            }

            if (Objects.equals(command, "pop")) {
                output.append(stack.pop()).append("\n");
            }

            if (Objects.equals(command, "size")) {
                output.append(stack.size()).append("\n");
            }

            if (Objects.equals(command, "empty")) {
                output.append(stack.empty()).append("\n");
            }

            if (Objects.equals(command, "top")) {
                output.append(stack.top()).append("\n");
            }
        }

        System.out.print(output);

        bufferedReader.close();

    }




}
