import problem.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

public class Execute {

    public static final String PROBLEM_CLASS_NAME = "P_11005";

    public static void main(String[] args) throws Exception {

        Problem p = loadProblemInstance();

        List<String> input = getField(p, "input");
        List<String> output = getField(p, "output");

        // 1. 백준 예시 입력으로 아웃풋 확인
        if (input != null && output != null) {
            execSample(p, input, output);
        }

        // 2. 직접 예시를 입력해서 아웃풋 확인
        if (input == null || output == null) {
            System.out.println("====================================");
            System.out.println("직접 입력하세요.");
            System.out.println("====================================");
            p.exec();
        }
    }

    // 문제 인스턴스 생성
    private static Problem loadProblemInstance() throws Exception {
        try {
            return (Problem) Class.forName("problem." + PROBLEM_CLASS_NAME)
                    .getDeclaredConstructor()
                    .newInstance();
        } catch (ReflectiveOperationException e) {
            throw new Exception("해당 문제 class 를 찾을 수 없습니다.", e);
        }
    }

    static List<String> getField(Problem p, String fieldname) throws NoSuchFieldException, IllegalAccessException {
        try {
            return (List<String>) p.getClass().getField(fieldname).get(p);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            return null;
        }
    }

    // 문제 인스턴스의 예시 입력으로 예시 출력이 나오는지 확인하는 메소드
    static void execSample(Problem p, List<String> input, List<String> output) throws Exception {

        for (int i = 0; i < input.size(); i++) {
            // 표준 입력 지정
            String inputData = input.get(i);
            System.setIn(new ByteArrayInputStream(inputData.getBytes()));

            // 콘솔 출력을 임시 저장할 ByteArrayOutputStream 생성
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            PrintStream printStream = new PrintStream(outputStream);

            // 콘솔 출력을 임시 저장할 ByteArrayOutputStream으로 재지정
            PrintStream originalOut = System.out;
            System.setOut(printStream);

            long startTime = System.currentTimeMillis();

            // 문제 해결 실행
            p.exec();

            // 콘솔 출력을 문자열로 변환하여 저장
            String actualOutput = outputStream.toString();

            // 원래의 콘솔 출력으로 복원
            System.setOut(originalOut);

            // 결과 평가
            String expectedOutput = output.get(i);
            printOutput(expectedOutput, actualOutput, i, startTime);

        }

    }

    // 결과 출력
    static void printOutput(String expectedOutput, String actualOutput, int i, long startTime) {

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        long memory = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024;

        boolean success = expectedOutput.equals(actualOutput);

        System.out.println("\nTest " + (i + 1) + ":");
        System.out.println("Expected Output:\n" + expectedOutput);
        System.out.println("Actual Output:\n" + actualOutput);

        System.out.println("Execution Time: " + executionTime + " ms");
        System.out.println("Memory Used: " + memory + " KB");

        if (success) {
            System.out.println("Test Passed: Success!");
        } else {
            System.out.println("Test Failed: Output Mismatch!");
        }

        System.out.println("====================================");
    }


}
