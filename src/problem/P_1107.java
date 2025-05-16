package problem;

import java.util.ArrayList;
import java.util.List;

import static problem.Read.readInt;

public class P_1107 implements Problem {

    /*
    문제
    수빈이는 TV를 보고 있다.
    수빈이는 채널을 돌리려고 했지만, 버튼을 너무 세게 누르는 바람에, 일부 숫자 버튼이 고장났다.

    리모컨에는 버튼이 0부터 9까지 숫자, +와 -가 있다.
    +를 누르면 현재 보고있는 채널에서 +1된 채널로 이동하고, -를 누르면 -1된 채널로 이동한다.
    채널 0에서 -를 누른 경우에는 채널이 변하지 않고, 채널은 무한대 만큼 있다.

    수빈이가 지금 이동하려고 하는 채널은 N이다.
    어떤 버튼이 고장났는지 주어졌을 때, 채널 N으로 이동하기 위해서 버튼을 최소 몇 번 눌러야하는지 구하는 프로그램을 작성하시오.

    수빈이가 지금 보고 있는 채널은 100번이다.

    입력
    첫째 줄에 수빈이가 이동하려고 하는 채널 N (0 ≤ N ≤ 500,000)이 주어진다.
    둘째 줄에는 고장난 버튼의 개수 M (0 ≤ M ≤ 10)이 주어진다.
    고장난 버튼이 있는 경우에는 셋째 줄에는 고장난 버튼이 주어지며, 같은 버튼이 여러 번 주어지는 경우는 없다.

    출력
    첫째 줄에 채널 N으로 이동하기 위해 버튼을 최소 몇 번 눌러야 하는지를 출력한다.

    예제 입력 1
    5457
    3
    6 7 8
    예제 출력 1
    6

    예제 입력 2
    100
    5
    0 1 2 3 4
    예제 출력 2
    0

    예제 입력 3
    500000
    8
    0 2 3 4 6 7 8 9
    예제 출력 3
    11117

    예제 입력 4
    100
    3
    1 0 5
    예제 출력 4
    0

    예제 입력 5
    14124
    0
    예제 출력 5
    5

    예제 입력 6
    1
    9
    1 2 3 4 5 6 7 8 9
    예제 출력 6
    2

    예제 입력 7
    80000
    2
    8 9
    예제 출력 7
    2228
     */





    public static List<String> input = List.of(
            "5457\n" +"3\n" +"6 7 8",
            "100\n" +"5\n" +"0 1 2 3 4",
            "500000\n" +"8\n" +"0 2 3 4 6 7 8 9",
            "100\n" +"3\n" +"1 0 5",
            "14124\n" +"0",
            "1\n" +"9\n" +"1 2 3 4 5 6 7 8 9",
            "80000\n" +"2\n" +"8 9");
    public static List<String> output = List.of(
            "6",
            "0",
            "11117",
            "0",
            "5",
            "2",
            "2228");

//    public static List<String> input = List.of(
//            "5457\n" +"3\n" +"6 7 8");
//    public static List<String> output = List.of(
//            "6");

    static int currentChannel = 100;
    static int targetChannel, nearestMinChannel, nearestMaxChannel;
    static int unavailableButtonNumber;

    @Override
    public void exec() throws Exception {

        boolean[] unavailableButtons = new boolean[10];

        targetChannel = readInt();
        unavailableButtonNumber = readInt();

        ArrayList<Integer> availableButtons = new ArrayList<>(10-unavailableButtonNumber);

        if (unavailableButtonNumber != 0) {
            for (int i=0; i<unavailableButtonNumber; i++) {
                unavailableButtons[readInt()] = true;
            }
        }

        for (int i=0; i<10; i++) {
            if (!unavailableButtons[i]) {
                availableButtons.add(i);
            }
        }

        ArrayList<Integer> possibleNumbers = availableNumbers(targetChannel, availableButtons);

        // possibleNumbers 에서 targetChannel 과 가장 근접한 작은수와 가장 근접한 큰 수 찾기
        int nearestNumber = findNearestNumber(possibleNumbers, targetChannel);

        if (nearestNumber == -1) {
            System.out.print(Math.abs(currentChannel - targetChannel));
        }

        else if (nearestNumber==targetChannel) {

            // 1. 100 과 targetChannel 의 절대값 차이
            int diff1 = Math.abs(currentChannel - targetChannel);

            // 2. nearestNumber.toString.length()
            int diff2 = Integer.toString(nearestNumber).length();

            // 1, 2 값 중 작은 값을 출력
            System.out.print(Math.min(diff1, diff2));
        }

        else if(nearestNumber<targetChannel) {

            nearestMinChannel = nearestNumber;

            // possibleNumbers 에서 nearestNumber 다음 수를 nearestMaxChannel 로
            int index = possibleNumbers.indexOf(nearestNumber);
            nearestMaxChannel = possibleNumbers.get(index + 1);

            // 1. 100 과 targetChannel 의 절대값 차이
            int diff1 = Math.abs(currentChannel - targetChannel);

            // 2. nearestMinChannel 과 targetChannel 의 절대값 차이 + nearestMinChannel.toString.length()
            int diff2 = Math.abs(nearestMinChannel - targetChannel) + Integer.toString(nearestMinChannel).length();

            // 3. nearestMaxChannel 과 targetChannel 의 절대값 차이 + nearestMaxChannel.toString.length()
            int diff3 = Math.abs(nearestMaxChannel - targetChannel) + Integer.toString(nearestMaxChannel).length();

            // 1, 2, 3 결과 중 가장 작은 수를 출력
            System.out.print(Math.min(diff1, Math.min(diff2, diff3)));

        }

        else {

            nearestMaxChannel = nearestNumber;

            // possibleNumbers 에서 nearestNumber 이전 수를 nearestMinChannel 로
            int index = possibleNumbers.indexOf(nearestNumber);
            nearestMinChannel = possibleNumbers.get(index - 1);

            // 1. 100 과 targetChannel 의 절대값 차이
            int diff1 = Math.abs(currentChannel - targetChannel);

            // 2. nearestMinChannel 과 targetChannel 의 절대값 차이 + nearestMinChannel.toString.length()
            int diff2 = Math.abs(nearestMinChannel - targetChannel) + Integer.toString(nearestMinChannel).length();

            // 3. nearestMaxChannel 과 targetChannel 의 절대값 차이 + nearestMaxChannel.toString.length()
            int diff3 = Math.abs(nearestMaxChannel - targetChannel) + Integer.toString(nearestMaxChannel).length();

            // 1, 2, 3 결과 중 가장 작은 수를 출력
            System.out.print(Math.min(diff1, Math.min(diff2, diff3)));

        }

    }

    static ArrayList<Integer> availableNumbers(int number, ArrayList<Integer> buttons) {

        // 예외처리.
        // buttons 에 아무것도 없거나 0만 들어있는 경우 null 을 반환
        if (buttons.isEmpty() || (buttons.size() == 1 && buttons.contains(0))) {
            return null;
        }

        ArrayList<Integer> numbers = new ArrayList<>();

        int digit = Integer.toString(number).length();

        for (int i = 1; i <= digit + 1; i++) {
            generateNumbers(i, 0, 0, buttons, numbers);
        }

        return numbers;
    }

    static void generateNumbers(int targetDigit, int currentNumber, int currentDigit, ArrayList<Integer> buttons, ArrayList<Integer> numbers) {

        if (currentDigit == targetDigit) {
            numbers.add(currentNumber);
            return;
        }

        for (int btn : buttons) {
            if (currentDigit == 0 && btn == 0) // 첫 자리에 0은 올 수 없음
                continue;
            int newNumber = currentNumber * 10 + btn;
            generateNumbers(targetDigit, newNumber, currentDigit + 1, buttons, numbers);
        }
    }

    static int findNearestNumber(ArrayList<Integer> numbers, int target) {

        // 예외처리.
        // buttons 에 아무것도 없는경우 100 을 반환
        if (numbers == null) {
            return -1;
        }


        int left = 0;
        int right = numbers.size() - 1;
        int nearest = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midVal = numbers.get(mid);

            if (midVal == target) {
                return midVal;
            }

            if (midVal < target) {
                nearest = midVal;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return nearest;
    }


}
