package ru.nsk.petrenko.range;

public class Range {
    private double from;
    private double to;
    private int rangeOverlayType = 0;

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

    public double[] getLength(double from, double to) {
        return new double[]{this.to - this.from, to - from};
    }

    private void rangeOverlay(double from, double to) {
        double epsilon = 1.0e-10;

        if (from >= this.from && from <= this.to) {
            if (to > this.to) {
                this.rangeOverlayType = 1;
            } else if (to <= this.to + epsilon && to >= this.to - epsilon) {
                this.to = to; // для корректности
                this.rangeOverlayType = 1;
            } else {
                this.rangeOverlayType = 2;
            }
        } else if (this.to >= from && to <= this.to) {
            if (this.from < from) {
                this.rangeOverlayType = 1;
            } else if (this.from <= from + epsilon && this.to >= from - epsilon) {
                this.from = from; // для корректности
                this.rangeOverlayType = 1;
            } else {
                this.rangeOverlayType = 2;
            }
        }
    }

    public double[] rangeInterval(double from, double to) { // Интервал пересечения
        rangeOverlay(from, to);

        if (rangeOverlayType == 0) {
            return null;
        }
        return new double[]{Math.max(this.from, from), Math.min(this.to, to)};
    }

    public double[] combiningIntervals(double from, double to) { // Объединение интервалов
        if (rangeOverlayType == 0) {
            return new double[]{this.from, this.to, from, to};
        }
        return new double[]{Math.min(this.from, from), Math.max(this.to, to)};
    }

    public double[] intervalDifference(double from, double to, double[] getLength) { // Получение разности
        if (rangeOverlayType == 1) {
            if (this.from < from) {
                return new double[]{this.from, Math.min(from, this.to)};
            } else if (to > this.to) {
                return new double[]{Math.max(this.to, from), to};
            }
        } else if (rangeOverlayType == 2) {
            if (getLength[0] >= getLength[1]) {
                return new double[]{this.from, from, to, this.to};
            } else {
                return new double[]{from, this.from, this.to, to};
            }
        }
        return null;
    }

    public boolean isInside(double number) {
        return number >= from && number <= to;
    }
}