package ru.nsk.petrenko.range.rangeMain;

import ru.nsk.petrenko.range.Range;

import java.util.Arrays;
import java.util.Scanner;

public class RangeMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Range rangeOne = new Range(0, 0);
        Range rangeTwo = new Range(0, 0);

        System.out.println("Укажи граничные значения первого диапазона: ");
        rangeOne.setFrom(scanner.nextDouble());
        rangeOne.setTo(scanner.nextDouble());

        System.out.printf("%nДлина первого диапазона, %.2f - %.2f, составляет: %.2f%n", rangeOne.getFrom(), rangeOne.getTo(), rangeOne.getLength()[0]);
        System.out.println("Введи число для проверки его принадлежности к первому диапазону: ");
        double number = scanner.nextDouble();

        if (rangeOne.isInside(number)) {
            System.out.printf("число %.2f принадлежит диапазону%n%n", number);
        } else {
            System.out.printf("число %.2f не принадлежит диапазону%n%n", number);
        }

        System.out.println("Укажи граничные значения второго диапазона: ");
        rangeTwo.setFrom(scanner.nextDouble());
        rangeTwo.setTo(scanner.nextDouble());

        System.out.printf("%nДлина второго диапазона, %.2f - %.2f, составляет: %.2f%n%n", rangeTwo.getFrom(), rangeTwo.getTo(), rangeTwo.getTo() - rangeTwo.getFrom());

        double[] intersection = rangeOne.intersection(rangeTwo);
        System.out.println("Пересечение диапазонов:");
        System.out.println(Arrays.toString(intersection));

        double[][] combine = rangeOne.combine(rangeTwo);
        System.out.println("Объединение диапазонов:");
        System.out.print(Arrays.toString(combine[0]));
        System.out.println(Arrays.toString(combine[1]));

        System.out.println("Получение разности диапазонов:");
        double[][] difference = rangeOne.getDifference(rangeTwo);
        System.out.print(Arrays.toString(difference[0]));
        System.out.println(Arrays.toString(difference[1]));
    }
}