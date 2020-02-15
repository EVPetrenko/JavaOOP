package ru.nsk.petrenko.range.rangeMain;

import ru.nsk.petrenko.range.Range;

import java.util.Scanner;

public class RangeMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Укажи граничные значения первого диапазона: ");
        Range range1 = new Range(0, 0);

        System.out.println("Начало диапазона: ");
        range1.setFrom(scanner.nextDouble());

        System.out.println("Конец диапазона: ");
        range1.setTo(scanner.nextDouble());

        System.out.printf("%nПервого диапазона (%.2f; %.2f), длина составляет: %.2f%n", range1.getFrom(), range1.getTo(), range1.getLength());
        System.out.println("Введи число для проверки его принадлежности к диапазону: ");
        double number = scanner.nextDouble();

        if (range1.isInside(number)) {
            System.out.printf("число %.2f принадлежит диапазону%n%n", number);
        } else {
            System.out.printf("число %.2f не принадлежит диапазону%n%n", number);
        }

        System.out.println("Укажи граничные значения второго диапазона: ");
        Range range2 = new Range(0, 0);

        System.out.println("Начало диапазона: ");
        range2.setFrom(scanner.nextDouble());

        System.out.println("Конец диапазона: ");
        range2.setTo(scanner.nextDouble());

        System.out.printf("%nВторого диапазона (%.2f; %.2f), длина составляет: %.2f%n%n", range2.getFrom(), range2.getTo(), range2.getTo() - range2.getFrom());

        Range intersection = range1.getIntersection(range2);
        Range[] union = range1.getUnion(range2);
        Range[] difference = range1.getDifference(range2);

        range1.makePrint(intersection, union, difference);
    }
}