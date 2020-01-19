package ru.nsk.petrenko.Range;

public class oop02_Range_v2 {
    private double from1;
    private double to1;
    private Double from2;
    private Double to2;

    public oop02_Range_v2(double from1, double to1, double from2, double to2) {
        this.from1 = from1;
        this.to1 = to1;
        this.from2 = from2;
        this.to2 = to2;
    }

    public void setFrom1(double from1) {
        this.from1 = from1;
    }

    public void setFrom2(Double from2) {
        this.from2 = from2;
    }

    public void setTo1(double to1) {
        this.to1 = to1;
    }

    public void setTo2(Double to2) {
        this.to2 = to2;
    }

    public double getFrom1() {
        return from1;
    }

    public double getFrom2() {
        return from2;
    }

    public Double getTo1() {
        return to1;
    }

    public Double getTo2() {
        return to2;
    }

    private void printNewRange() {
        System.out.printf("%nИзменение граничных значений после слияния: %.3f, %.3f", getFrom1(), getTo1());
    }

    public double getLength1() {
        return Math.abs(getTo1() - getFrom1());

    }

    public Double getLength2() {
        if (from2 == null | to2 == null) {
            return null;
        } else {
            return Math.abs(getTo2() - getFrom2());
        }
    }

    public Double getNewLength() {
        if ((to1 >= Math.min(from2, to2) && to1 <= Math.max(from2, to2)) || (from1 >= Math.min(from2, to2) && from1 <= Math.max(from2, to2))) {
            setFrom1(Math.min(Math.min(from1, from2), Math.min(to1, to2)));
            setTo1(Math.max(Math.max(to1, to2), Math.max(from1, from2)));
            setFrom2(null);
            setTo2(null);

            printNewRange();

            return Math.abs(getTo1() - getFrom1());
        } else {

            return null;
        }
    }

    public boolean isInside1(double number) {
        return number >= Math.min(from1, to1) && number <= Math.max(from1, to1);
    }
}

/*
••• Доработать класс Range (числовой диапазон).
• Написать методы:
    1• Вычисление длины интервала ok
    2• Получение интервала-пересечения двух интервалов. ok
        Если пересечения нет, выдать null. ok
        Если есть, то выдать новый диапазон с соответствующими концами      !!!!!!!!!!!!!?????????????
    3• Получение объединения двух интервалов.
        Может получиться 1 или 2 отдельных куска
    4• Получение разности двух интервалов.
        Может получиться 1 или 2 отдельных куска
    5• В операциях где может получиться 2 куска выдавайте
        массив объектов Range
    6• Операции пересечения, объединения и разности – по
        смыслу такие же как для множеств, см. литературу по
        множествам
    7• Разность нужна несимметричная – из первого интервала
        вычитаем второй
 */