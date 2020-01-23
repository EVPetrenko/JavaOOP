package ru.nsk.petrenko.range.rangeMain;

import ru.nsk.petrenko.range.Range;

import java.util.Arrays;
import java.util.Scanner;

public class RangeMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Range range = new Range(0, 0);

        System.out.println("Укажи граничные значения первого диапазона: ");
        range.setFrom(scanner.nextDouble());
        range.setTo(scanner.nextDouble());

        System.out.println("Укажи граничные значения второго диапазона: ");
        double from = scanner.nextDouble();
        double to = scanner.nextDouble();

        System.out.printf("%nИнтервал первого диапазона, %.2f - %.2f, составляет: %.2f%n", range.getFrom(), range.getTo(), range.getLength(from, to)[0]);
        System.out.printf("%nИнтервал второго диапазона, %.2f - %.2f, составляет: %.2f%n%n", from, to, range.getLength(from, to)[1]);

        System.out.println("Интервал пересечения диапазонов:");
        double[] rangeInterval = range.rangeInterval(from, to);
        System.out.println(Arrays.toString(rangeInterval));

        System.out.println("Объединение диапазонов:");
        double[] combiningIntervals = range.combiningIntervals(from, to);
        System.out.println(Arrays.toString(combiningIntervals));

        System.out.println("Получение разности диапазонов:");
        double[] intervalDifference = range.intervalDifference(from, to, rangeInterval);
        System.out.println(Arrays.toString(intervalDifference));

        System.out.println("Введи число для проверки его принадлежности к диапазону: ");
        double number = scanner.nextDouble();

        if (range.isInside(number)) {
            System.out.printf("число %.2f принадлежит диапазону", number);
        } else {
            System.out.printf("число %.2f не принадлежит диапазону", number);
        }
    }
}