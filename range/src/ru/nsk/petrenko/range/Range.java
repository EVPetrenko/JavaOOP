package ru.nsk.petrenko.range;

public class Range {
    private double from;
    private double to;
    private String name;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public double getTo() {
        return to;
    }

    public double getLength() {
        return to - from;
    }

    public boolean isInside(double number) {
        return number >= from && number <= to;
    }

    //    10. Общее по пересечению и т.д. - можно сильно упростить условие пересечения - Не нашёл решения
    public Range getIntersection(Range range2) { // пересечение
        if ((range2.from < this.to && range2.from >= this.from) || (this.from < range2.to && this.from >= range2.from)) {
            return new Range(Math.max(this.from, range2.from), Math.min(this.to, range2.to));
        }

        return null;
    }

    public Range[] getUnion(Range range2) { // Объединение интервалов
        if ((range2.from >= this.from && range2.from <= this.to) || (this.to >= range2.from && this.to <= range2.to)) {
            return new Range[]{new Range(Math.min(this.from, range2.from), Math.max(this.to, range2.to))};
        }

        return new Range[]{new Range(this.from, this.to), new Range(range2.from, range2.to)};
    }

    public Range[] getDifference(Range range2) { // Получение разности
        if (range2.from < this.from && this.from < range2.to && range2.to < this.to) {
            return new Range[]{new Range(range2.to, this.to)};
        } else if (range2.from > this.from && this.to > range2.from && range2.to > this.to) {
            return new Range[]{new Range(this.from, range2.from)};
        } else if (range2.from < this.from && this.to < range2.to) {
            return new Range[]{new Range(range2.from, this.from), new Range(this.to, range2.to)};
        } else if (this.from < range2.from && range2.to < this.to) {
            return new Range[]{new Range(this.from, range2.from), new Range(range2.to, this.to)};
        }

        return new Range[]{new Range(this.from, this.to)};
    }
}