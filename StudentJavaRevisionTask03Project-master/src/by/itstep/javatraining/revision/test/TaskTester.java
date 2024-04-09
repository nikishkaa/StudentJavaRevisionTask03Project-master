package by.itstep.javatraining.revision.test;

import by.itstep.javatraining.revision.task.*;

import java.util.Random;

public class TaskTester {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 8;

    public static final String RIGHT = "completed successfully. Well DONE!!!";
    public static final String WRONG = "was not running successfully. Something was WRONG!";

    private interface ChessMethod {
        boolean execute(int x1, int y1, int x2, int y2);
    }

    private static String getResult(String task, boolean result) {
        return task + " " + (result ? RIGHT : WRONG);
    }

    private static boolean checkBasicFoolProof(ChessMethod method) {
        return !(method.execute(0, 2, 2, 2)
                || method.execute(2, 0, 2, 2)
                || method.execute(2, 2, 0, 2)
                || method.execute(2, 2, 2, 0)
                || method.execute(-1, 3, 3, 3)
                || method.execute(3, -1, 3, 3)
                || method.execute(3, 3, -1, 3)
                || method.execute(3, 3, 3, -1)
                || method.execute(9, 5, 5, 5)
                || method.execute(5, 9, 5, 5)
                || method.execute(5, 5, 9, 5)
                || method.execute(5, 5, 5, 9)
                || method.execute(5, 5, 5, 5)
                || method.execute(5, 3, 5, 3));
    }


    public static String testingTask01() {
        boolean result = !Task01.start(0, 2)
                && !Task01.start(2, 0)
                && !Task01.start(-1, 3)
                && !Task01.start(3, -1)
                && !Task01.start(9, 5)
                && !Task01.start(5, 9);

        label1:
        for (int x = MIN_NUMBER; x <= MAX_NUMBER; x += 2) {
            for (int y = MIN_NUMBER; y <= MAX_NUMBER; y += 2) {
                if (!Task01.start(x, y)) {
                    result = false;
                    break label1;
                }
            }
        }

        if (result) {
            label2:
            for (int x = MIN_NUMBER + 1; x <= MAX_NUMBER; x += 2) {
                for (int y = MIN_NUMBER + 1; y <= MAX_NUMBER; y += 2) {
                    if (!Task01.start(x, y)) {
                        result = false;
                        break label2;
                    }
                }
            }
        }

        if (result) {
            label3:
            for (int x = MIN_NUMBER; x <= MAX_NUMBER; x += 2) {
                for (int y = MIN_NUMBER + 1; y <= MAX_NUMBER; y += 2) {
                    if (Task01.start(x, y)) {
                        result = false;
                        break label3;
                    }
                }
            }
        }

        if (result) {
            label4:
            for (int x = MIN_NUMBER + 1; x <= MAX_NUMBER; x += 2) {
                for (int y = MIN_NUMBER; y <= MAX_NUMBER; y += 2) {
                    if (Task01.start(x, y)) {
                        result = false;
                        break label4;
                    }
                }
            }
        }

        return getResult("Task 01", result);
    }


    public static String testingTask02() {
        boolean result = checkBasicFoolProof(Task02::start);

        label1:
        for (int x = MIN_NUMBER; x <= MAX_NUMBER; x++) {
            for (int y = MIN_NUMBER; y < MAX_NUMBER; y++) {
                if (!Task02.start(x, y, x, y + 1)) {
                    result = false;
                    break label1;
                }
            }
        }

        if (result) {
            Random random = new Random();

            label2:
            for (int x = MIN_NUMBER; x <= MAX_NUMBER; x++) {
                for (int y = MIN_NUMBER; y < MAX_NUMBER; y++) {
                    int d1 = random.nextInt(MAX_NUMBER + 1 - MIN_NUMBER) + MIN_NUMBER;
                    int d2 = random.nextInt(MAX_NUMBER + 1 - MIN_NUMBER) + MIN_NUMBER;

                    if (Task02.start(x, y, x + d1, y + d2)) {
                        result = false;
                        break label2;
                    }
                }
            }
        }

        return getResult("Task 02", result);
    }

    public static String testingTask03() {
        boolean result = checkBasicFoolProof(Task03::start)
                && !Task03.start(4, 4, 5, 5)
                && !Task03.start(4, 4, 3, 3)
                && !Task03.start(4, 4, 3, 5)
                && !Task03.start(4, 4, 5, 3)
                && !Task03.start(4, 4, 7, 1)
                && !Task03.start(4, 4, 1, 7)
                && !Task03.start(4, 4, 1, 1)
                && !Task03.start(4, 4, 7, 7)
                && Task03.start(4, 4, 4, 1)
                && Task03.start(4, 4, 4, 2)
                && Task03.start(4, 4, 4, 3)
                && Task03.start(4, 4, 4, 5)
                && Task03.start(4, 4, 4, 6)
                && Task03.start(4, 4, 4, 7)
                && Task03.start(4, 4, 4, 8)
                && Task03.start(4, 4, 1, 4)
                && Task03.start(4, 4, 2, 4)
                && Task03.start(4, 4, 3, 4)
                && Task03.start(4, 4, 5, 4)
                && Task03.start(4, 4, 6, 4)
                && Task03.start(4, 4, 7, 4)
                && Task03.start(4, 4, 8, 4);

        return getResult("Task 03", result);
    }

    public static String testingTask04() {
        boolean result = checkBasicFoolProof(Task04::start)
                && !Task04.start(5, 3, 5, 5)
                && !Task04.start(5, 3, 3, 3)
                && !Task04.start(5, 3, 3, 5)
                && !Task04.start(5, 3, 7, 1)
                && !Task04.start(5, 3, 1, 7)
                && !Task04.start(5, 3, 3, 1)
                && !Task04.start(5, 3, 7, 5)
                && !Task04.start(5, 3, 7, 3)
                && !Task04.start(1, 1, 0, 1)
                && !Task04.start(1, 1, 1, 0)
                && !Task04.start(2, 1, 1, -1)
                && !Task04.start(1, 2, -1, 1)
                && Task04.start(5, 3, 5, 4)
                && Task04.start(5, 3, 5, 2)
                && Task04.start(5, 3, 6, 3)
                && Task04.start(5, 3, 4, 3)
                && Task04.start(5, 3, 4, 2)
                && Task04.start(5, 3, 4, 4)
                && Task04.start(5, 3, 6, 2)
                && Task04.start(5, 3, 6, 4);


        return getResult("Task 04", result);
    }

    public static String testingTask05() {
        boolean result = checkBasicFoolProof(Task05::start)
                && !Task05.start(6, 4, 5, 4)
                && !Task05.start(6, 4, 6, 4)
                && !Task05.start(6, 4, 7, 4)
                && !Task05.start(6, 4, 6, 3)
                && !Task05.start(6, 4, 6, 5)
                && !Task05.start(-1, 4, 1, 6)
                && !Task05.start(3, -1, 1, 1)
                && !Task05.start(4, 1, 6, -1)
                && !Task05.start(1, 3, -1, 1)
                && Task05.start(6, 4, 8, 2)
                && Task05.start(6, 4, 7, 3)
                && Task05.start(6, 4, 4, 6)
                && Task05.start(6, 4, 3, 7)
                && Task05.start(6, 4, 2, 8)
                && Task05.start(6, 4, 3, 1)
                && Task05.start(6, 4, 4, 2)
                && Task05.start(6, 4, 5, 3)
                && Task05.start(6, 4, 7, 5)
                && Task05.start(6, 4, 8, 6)
                && Task05.start(6, 4, 5, 5);

        return getResult("Task 05", result);
    }

    public static String testingTask06() {
        boolean result = checkBasicFoolProof(Task06::start)
                && !Task06.start(4, 1, 4, 2)
                && !Task06.start(4, 2, 4, 3)
                && !Task06.start(-1, 7, -1, 8)
                && !Task06.start(0, 7, 0, 8)
                && !Task06.start(9, 7, 9, 8)
                && Task06.start(4, 7, 4, 8)
                && Task06.start(1, 7, 1, 8)
                && Task06.start(8, 7, 8, 8);

        return getResult("Task 06", result);
    }

    public static String testingTask07() {
        boolean result = checkBasicFoolProof(Task07::start)
                && !Task07.start(6, 4, 5, 2)
                && !Task07.start(6, 4, 6, 4)
                && !Task07.start(6, 4, 2, 6)
                && !Task07.start(6, 4, 1, 1)
                && !Task07.start(6, 4, 8, 8)
                && !Task07.start(6, 4, 3, 6)
                && !Task07.start(6, 4, 4, 5)
                && !Task07.start(6, 4, 5, 7)
                && !Task07.start(6, 4, 8, 3)
                && Task07.start(6, 4, 8, 2)
                && Task07.start(6, 4, 7, 3)
                && Task07.start(6, 4, 5, 5)
                && Task07.start(6, 4, 4, 6)
                && Task07.start(6, 4, 3, 7)
                && Task07.start(6, 4, 2, 8)
                && Task07.start(6, 4, 3, 1)
                && Task07.start(6, 4, 4, 2)
                && Task07.start(6, 4, 5, 3)
                && Task07.start(6, 4, 7, 5)
                && Task07.start(6, 4, 8, 6)
                && Task07.start(6, 4, 5, 4)
                && Task07.start(6, 4, 4, 4)
                && Task07.start(6, 4, 3, 4)
                && Task07.start(6, 4, 2, 4)
                && Task07.start(6, 4, 1, 4)
                && Task07.start(6, 4, 7, 4)
                && Task07.start(6, 4, 8, 4)
                && Task07.start(6, 4, 6, 3)
                && Task07.start(6, 4, 6, 2)
                && Task07.start(6, 4, 6, 1)
                && Task07.start(6, 4, 6, 6)
                && Task07.start(6, 4, 6, 7)
                && Task07.start(6, 4, 6, 8)
                && Task07.start(6, 4, 6, 5);

        return getResult("Task 07", result);
    }

    public static String testingTaskX() {
        boolean result = checkBasicFoolProof(TaskX::start)
                && !TaskX.start(3, 6, 5, 3)
                && !TaskX.start(3, 6, 3, 6)
                && !TaskX.start(3, 6, 7, 5)
                && !TaskX.start(3, 6, 8, 6)
                && !TaskX.start(3, 6, 5, 4)
                && !TaskX.start(3, 6, 7, 4)
                && !TaskX.start(3, 6, 6, 3)
                && !TaskX.start(3, 6, 6, 5)
                && !TaskX.start(-1, 6, 1, 5)
                && !TaskX.start(6, -1, 5, 1)
                && !TaskX.start(1, 6, -1, 5)
                && !TaskX.start(6, 1, 5, -1)
                && TaskX.start(3, 6, 1, 5)
                && TaskX.start(3, 6, 2, 4)
                && TaskX.start(3, 6, 4, 4)
                && TaskX.start(3, 6, 5, 5)
                && TaskX.start(3, 6, 5, 7)
                && TaskX.start(3, 6, 4, 8)
                && TaskX.start(3, 6, 2, 8)
                && TaskX.start(3, 6, 1, 7);

        return getResult("Task X ", result);
    }
}