package ru.nsk.petrenko.range.rangeMain;

import ru.nsk.petrenko.range.Range;

import java.util.Scanner;

public class RangeMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Range range1 = new Range(0, 0);
        Range range2 = new Range(0, 0);

        System.out.println("Укажи граничные значения первого диапазона: ");
        range1.setFrom(scanner.nextDouble());
        range1.setTo(scanner.nextDouble());

        System.out.printf("%nДлина первого диапазона, %.2f - %.2f, составляет: %.2f%n", range1.getFrom(), range1.getTo(), range1.getLength());
        System.out.println("Введи число для проверки его принадлежности к первому диапазону: ");
        double number = scanner.nextDouble();

        if (range1.isInside(number)) {
            System.out.printf("число %.2f принадлежит диапазону%n%n", number);
        } else {
            System.out.printf("число %.2f не принадлежит диапазону%n%n", number);
        }

        System.out.println("Укажи граничные значения второго диапазона: ");
        range2.setFrom(scanner.nextDouble());
        range2.setTo(scanner.nextDouble());

        System.out.printf("%nДлина второго диапазона, %.2f - %.2f, составляет: %.2f%n%n", range2.getFrom(), range2.getTo(), range2.getTo() - range2.getFrom());

        Range intersection = range1.getIntersection(range2);
        System.out.println("Пересечение диапазонов:");
        if (intersection != null) {
            System.out.println(intersection.getFrom() + " - " + intersection.getTo());
        } else {
            System.out.println(intersection);
        }

        Range[] combine = range1.getUnion(range2);
        System.out.println("Объединение диапазонов:");

        for (Range range : combine) {
            System.out.println(range.getFrom() + " - " + range.getTo());
        }

        System.out.println("Получение разности диапазонов:");
        Range[] difference = range1.getDifference(range2);
        for (Range range : difference) {
            System.out.println(range.getFrom() + " - " + range.getTo());
        }
    }
}