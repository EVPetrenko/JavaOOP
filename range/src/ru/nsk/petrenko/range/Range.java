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

    public double[] getLength() {
        return new double[]{to - from};
    }

    public boolean isInside(double number) {
        return number >= from && number <= to;
    }

    public double[] intersection(Range rangeTwo) { // пересечение
        if ((rangeTwo.from < this.to && rangeTwo.from >= this.from) || (this.from < rangeTwo.to && this.from >= rangeTwo.from)) {
            return new double[]{Math.max(this.from, rangeTwo.from), Math.min(this.to, rangeTwo.to)};
        }
        return null; // Соответстует заданию
    }

    public double[][] combine(Range rangeTwo) { // Объединение интервалов
        if ((rangeTwo.from >= this.from && rangeTwo.from <= this.to) || (this.to >= rangeTwo.from && rangeTwo.to <= this.to)) {
            return new double[][]{{Math.min(this.from, rangeTwo.from), Math.max(this.to, rangeTwo.to)}, {}};
        }
        return new double[][]{{this.from, this.to}, {rangeTwo.from, rangeTwo.to}};
    }

    public double[][] getDifference(Range rangeTwo) { // Получение разности
        if (rangeTwo.from <= this.from && this.from <= rangeTwo.to && rangeTwo.to <= this.to) {
            return new double[][]{{rangeTwo.to, this.to}, {}};
        } else if (rangeTwo.from >= this.from && this.to >= rangeTwo.from && rangeTwo.to >= this.to) {
            return new double[][]{{this.from, rangeTwo.from}, {}};
        } else if (rangeTwo.from < this.from && this.to < rangeTwo.to) {
            return new double[][]{{rangeTwo.from, this.from}, {this.to, rangeTwo.to}};
        } else if (this.from < rangeTwo.from && rangeTwo.to < this.to) {
            return new double[][]{{this.from, rangeTwo.from}, {rangeTwo.to, this.to}};
        }
        return new double[][]{{}, {}};
    }
}