package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Objects;
import java.util.StringTokenizer;

public class P_10866 implements Problem {

    /*
    문제

    정수를 저장하는 덱(Deque)를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.

    명령은 총 여덟 가지이다.

    push_front X: 정수 X를 덱의 앞에 넣는다.
    push_back X: 정수 X를 덱의 뒤에 넣는다.
    pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    size: 덱에 들어있는 정수의 개수를 출력한다.
    empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
    front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.

    입력
    첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다.
    둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다.
    주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다.
    문제에 나와있지 않은 명령이 주어지는 경우는 없다.

    출력
    출력해야하는 명령이 주어질 때마다, 한 줄에 하나씩 출력한다.

    예제 입력 1
15
push_back 1
push_front 2
front
back
size
empty
pop_front
pop_back
pop_front
size
empty
pop_back
push_front 3
empty
front

    예제 출력 1
2
1
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
22
front
back
pop_front
pop_back
push_front 1
front
pop_back
push_back 2
back
pop_front
push_front 10
push_front 333
front
back
pop_back
pop_back
push_back 20
push_back 1234
front
back
pop_back
pop_back

    예제 출력 2
-1
-1
-1
-1
1
1
2
2
333
10
10
333
20
1234
1234
20
     */

    // 덱를 구현할 링크드리스트 생성
    private static final LinkedList<Integer> dequeList = new LinkedList<>();

    @Override
    public void exec() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        // 입력받을 명령어 수
        int N = Integer.parseInt(bufferedReader.readLine());

        String command;

        StringBuilder output = new StringBuilder();

        for (int i=0; i<N; i++) {
            StringTokenizer commandLine = new StringTokenizer(bufferedReader.readLine());
            command = commandLine.nextToken();

            if (Objects.equals(command, "push_front")) {
                pushFront(Integer.parseInt(commandLine.nextToken()));
            }

            if (Objects.equals(command, "push_back")) {
                pushBack(Integer.parseInt(commandLine.nextToken()));
            }

            if (Objects.equals(command, "pop_front")) {
                output.append(popFront()).append("\n");
            }

            if (Objects.equals(command, "pop_back")) {
                output.append(popBack()).append("\n");
            }

            if (Objects.equals(command, "size")) {
                output.append(size()).append("\n");
            }

            if (Objects.equals(command, "empty")) {
                output.append(empty()).append("\n");
            }

            if (Objects.equals(command, "front")) {
                output.append(front()).append("\n");
            }

            if (Objects.equals(command, "back")) {
                output.append(back()).append("\n");
            }

        }

        bufferedReader.close();

        System.out.println(output);
    }

    public static void pushFront(int number) {
        dequeList.addFirst(number);
    }

    public static void pushBack(int number) {
        dequeList.addLast(number);
    }

    public static int popFront() {
        if (dequeList.isEmpty()) {
            return -1;
        }

        return dequeList.removeFirst();
    }

    public static int popBack() {
        if (dequeList.isEmpty()) {
            return -1;
        }

        return dequeList.removeLast();
    }

    public static int size() {
        return dequeList.size();
    }

    public static int empty(){
        return dequeList.isEmpty() ? 1 : 0;
    }

    public static int front() {
        if (dequeList.isEmpty()) {
            return -1;
        }

        return dequeList.getFirst();
    }

    public static int back() {
        if (dequeList.isEmpty()) {
            return -1;
        }

        return dequeList.getLast();
    }

}
