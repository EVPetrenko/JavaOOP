package ru.nsk.petrenko.range.rangeMain;

import ru.nsk.petrenko.range.Range;

import java.util.Scanner;

public class RangeMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Укажи граничные значения первого диапазона: ");
        Range range1 = new Range(scanner.nextDouble(), scanner.nextDouble()); // Если единственное/однократное задание значений без Сеттеров являеться плохим стилем, дайте знать
        /*
        range1.setFrom(scanner.nextDouble());
        range1.setTo(scanner.nextDouble());
         */

        System.out.printf("%nПервого диапазона (%.2f; %.2f), длина составляет: %.2f%n", range1.getFrom(), range1.getTo(), range1.getLength());
        System.out.println("Введи число для проверки его принадлежности к первому диапазону: ");
        double number = scanner.nextDouble();

        if (range1.isInside(number)) {
            System.out.printf("число %.2f принадлежит диапазону%n%n", number);
        } else {
            System.out.printf("число %.2f не принадлежит диапазону%n%n", number);
        }

        System.out.println("Укажи граничные значения второго диапазона: ");
        Range range2 = new Range(scanner.nextDouble(), scanner.nextDouble());

        System.out.printf("%nВторого диапазона (%.2f; %.2f), длина составляет: %.2f%n%n", range2.getFrom(), range2.getTo(), range2.getTo() - range2.getFrom());

        Range intersection = range1.getIntersection(range2);
        System.out.println("Пересечение диапазонов:");

        System.out.print("[");

        if (intersection != null) {
            System.out.print("(" + intersection.getFrom() + "; " + intersection.getTo() + ")");
        } else {
            System.out.print("null");
        }

        System.out.println("]");

        Range[] union = range1.getUnion(range2);
        System.out.println("Объединение диапазонов:");

        System.out.print("[");
        for (Range range : union) {
            System.out.print("(" + range.getFrom() + "; " + range.getTo() + ")");
        }

        System.out.println("]");

        System.out.println("Получение разности диапазонов:");
        Range[] difference = range1.getDifference(range2);

        System.out.print("[");

        for (Range range : difference) {
            System.out.print("(" + range.getFrom() + "; " + range.getTo() + ")");
        }

        System.out.println("]");
    }
}
