import ru.nsk.petrenko.Range.oop02_Range_v2;

import java.util.Scanner;

public class oop02_RangeMain_v2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        oop02_Range_v2 range = new oop02_Range_v2(0, 0, 0, 0);

        System.out.println("Укажите граничные значения первого диапазона: ");
        range.setFrom1(scanner.nextDouble());
        range.setTo1(scanner.nextDouble());

        System.out.println("Укажите граничные значения второго диапазона: ");
        range.setFrom2(scanner.nextDouble());
        range.setTo2(scanner.nextDouble());

        System.out.printf("%nИнтервал диапазона1, от %.4f до %.4f составляет: %.4f%n", range.getFrom1(), range.getTo1(), range.getLength1());
        System.out.printf("Интервал диапазона2, от %.4f до %.4f составляет: %.4f%n", range.getFrom2(), range.getTo2(), range.getLength2());

        System.out.printf("%nНовый интервал диапазона %.4f%n%n", range.getNewLength());
        System.out.print("Введите число для проверки его принадлежности к диапазону: ");
        double number = scanner.nextDouble();

        if (range.isInside1(number)) {
            System.out.printf("Число %.4f принадлежит этому диапазону", number);
        } else {
            System.out.printf("Число %.4f не принадлежит этому диапазону", number);
        }
    }
}
/*
••• Доработать класс Range (числовой диапазон).
• Написать методы:
    1• Вычисление длины интервала ок
    2• Получение интервала-пересечения двух интервалов. ок
        Если пересечения нет, выдать null. Если есть, то выдать ок
        новый диапазон с соответствующими концами ок
    3• Получение объединения двух интервалов. ?
        Может получиться 1 или 2 отдельных куска
    4• Получение разности двух интервалов. ?
        Может получиться 1 или 2 отдельных куска
    5• В операциях где может получиться 2 куска выдавайте ?
        массив объектов Range
    6• Операции пересечения, объединения и разности – по ?
        смыслу такие же как для множеств, см. литературу по
        множествам
    7• Разность нужна несимметричная – из первого интервала ?
        вычитаем второй
*/