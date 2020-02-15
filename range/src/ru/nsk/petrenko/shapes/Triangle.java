package ru.nsk.petrenko.shapes;

public class Triangle implements Shapes {
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private double x3;
    private double y3;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    @Override
    public double getWidth() {
        return Math.max(x1, Math.max(x2, x3)) - Math.min(x1, Math.min(x2, x3)); //Значит паралельно оси X
    }

    @Override
    public double getHeight() {
        return Math.max(y1, Math.max(y2, y3)) - Math.min(y1, Math.min(y2, y3)); //Значит паралельно оси Y, вывод, треугольник имеет прямой угол
    }

    @Override
    public double getArea() {
        return getWidth() * getHeight() / 2; //Площадь треугольника с прямым углом
    }

    @Override
    public double getPerimeter() {
        return Math.sqrt(Math.pow(getWidth(), 2) + Math.pow(getHeight(), 2)); //Гипотенуза всегда противоположна прямому углу
    }
}

//2. Triangle – треугольник
//Должен иметь конструктор, принимающий x1, y1, x2, y2, x3, y3 – шесть координат. В качестве ширины возвращать
// max(x1, x2, x3) – min(x1, x2, x3) В качестве высоты возвращать max(y1, y2, y3) – min(y1, y2, y3)
