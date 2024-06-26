package by.itstep.javatraining.revision.task;

/*	Task 05. Chess & Bishop [шахматный слон]
 *
 *	Шахматный слон (chess bishop) ходит только по диагоналям.
 *	Даны две различные клетки шахматной доски, определите,
 *	может ли слон попасть с первой клетки на вторую одним ходом.
 *
 *	Примечание
 *	1) Чтобы увидеть решение и разработать алгоритм, нарисуйте себе шахматную доску
 *	и поставьте в клетках соответствующие координаты x и y.
 *	2) Не забудьте "защиту от дурака". Если пользователь задаёт неверные коориднаты клеток,
 *	то функция должна возвратить булевское значение false.
 *	3) Для решения достаточно использовать арифметические операции, операции отношения,
 *	логические операции и условную операцию (?:).
 *
 *  Формат входных данных [input]
 *	Метод принимает на вход четыре числа от 1 до 8 каждое, задающие номер столбца
 *  и номер строки сначала для первой клетки (x1, y1), а потом для второй клетки (x2, y2).
 *
 *	Формат выходных данных [output]
 *	Метод должен возвратить булевское значение - результат решения.
 *
 *	[ input 1]: 4 4 5 5
 *	[output 1]: true
 *
 *	[ input 2]: 4 4 4 8
 *	[output 2]: false
 */

public class Task05 {
    public static final int CHESS_MAX_SIZE = 8;
    public static final int CHESS_MIN_SIZE = 1;

    public static boolean start(int x1, int y1, int x2, int y2) {
        if (x1 > CHESS_MAX_SIZE || x1 < CHESS_MIN_SIZE ||
                x2 > CHESS_MAX_SIZE || x2 < CHESS_MIN_SIZE ||
                y1 > CHESS_MAX_SIZE || y1 < CHESS_MIN_SIZE ||
                y2 > CHESS_MAX_SIZE || y2 < CHESS_MIN_SIZE) {
            return false;
        }


        return (x1 != x2 && y1 != y2);
    }
}
