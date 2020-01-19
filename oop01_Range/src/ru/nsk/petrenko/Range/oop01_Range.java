package ru.nsk.petrenko.Range;

public class oop01_Range {
    private double from;
    private double to;

    public oop01_Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double getLength() {
        return Math.abs(to - from);
    }

    public boolean isInside(double number) {
        return number >= Math.min(from, to) && number <= Math.max(from, to);
    }
}
/*
• Создать свой класс Range (числовой диапазон). В нём:
1. Объявить два вещественных поля from, to
2. Описать конструктор, при помощи которого
заполняются поля from, to
3. Функция для вычисления длины интервала
4. Создать метод isInside, который принимает
вещественное число и возвращает boolean – результат
проверки того, принадлежит ли число диапазону
• После этого написать небольшую программу с
использованием этого класса
 */