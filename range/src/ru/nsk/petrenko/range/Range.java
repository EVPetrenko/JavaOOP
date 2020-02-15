package ru.nsk.petrenko.range;

public class Range {
    private double from;
    private double to;

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

    public Range getIntersection(Range range) { // Пересечение
        if (from < range.to && to > range.from) {
            return new Range(Math.max(from, range.from), Math.min(to, range.to));
        }

        return null;
    }

    public Range[] getUnion(Range range) { // Объединение
        if (range.to < from || to < range.from) {
            if (from < range.from) {
                return new Range[]{new Range(from, to), new Range(range.from, range.to)};
            }

            return new Range[]{new Range(range.from, range.to), new Range(from, to)};
        }

        return new Range[]{new Range(Math.min(from, range.from), Math.max(to, range.to))};
    }

    public Range[] getDifference(Range range) { // Разность
        if (range.to <= from || to <= range.from) {
            return new Range[]{new Range(from, to)};
        }

        if (range.from <= from && range.to < to) {
            return new Range[]{new Range(range.to, to)};
        }

        if (range.from > from && range.to >= to) {
            return new Range[]{new Range(from, range.from)};
        }

        if (range.from < from && to < range.to) {
            return new Range[]{new Range(range.from, from), new Range(to, range.to)};
        }

        return new Range[]{new Range(from, range.from), new Range(range.to, to)};
    }

    public void makePrint(Range intersection, Range[] union, Range[] difference) {
        System.out.println("Пересечение диапазонов:");
        System.out.print("[");

        if (intersection != null) {
            System.out.print("(" + intersection.getFrom() + "; " + intersection.getTo() + ")");
        } else {
            System.out.print("null");
        }

        System.out.println("]");
        System.out.println("Объединение диапазонов:");
        System.out.print("[");

        for (Range range : union) {
            System.out.print("(" + range.getFrom() + "; " + range.getTo() + ")");
        }

        System.out.println("]");
        System.out.println("Получение разности диапазонов:");
        System.out.print("[");

        for (Range range : difference) {
            System.out.print("(" + range.getFrom() + "; " + range.getTo() + ")");
        }

        System.out.println("]");
    }
}