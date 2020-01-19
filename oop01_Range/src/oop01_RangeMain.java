import ru.nsk.petrenko.Range.oop01_Range;

import java.util.Scanner;

public class oop01_RangeMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        oop01_Range range = new oop01_Range(0, 0);

        System.out.println("Укажи граничные значения диапазона: ");
        range.setFrom(scanner.nextDouble());
        range.setTo(scanner.nextDouble());


        System.out.printf("%nИнтервал диапазона, от %.2f до %.2f составляет: %.2f%n", range.getFrom(), range.getTo(), range.getLength());

        System.out.print("Введи число для проверки его принадлежности к диапазону: ");
        double number = scanner.nextDouble();

        if (range.isInside(number)) {
            System.out.printf("число %.2f принадлежит этому диапазону", number);
        } else {
            System.out.printf("число %.2f не принадлежит этому диапазону", number);
        }
    }
}
/*
• Создать свой класс Range (числовой диапазон). В нём:
1. Объявить два вещественных поля from, to
2. Описать конструктор, при помощи которого
заполняются поля from, to
3. Геттеры и сеттеры для полей
4. Функция для получения длины
5. Создать метод isInside, который принимает
вещественное число и возвращает boolean – результат
проверки того, принадлежит ли число диапазону
• После этого написать небольшую программу с
использованием этого класса
 */