package ru.nsk.petrenko.shapes;

public class Circle implements Shapes {
    private double radius;
    private double diameter = radius * 2;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getWidth() {
        return diameter;
    }

    @Override
    public double getHeight() {
        return diameter;
    }

    @Override
    public double getArea() {
        return Math.pow(radius, 2) * Math.PI;
    }

    @Override
    public double getPerimeter() {
        return diameter * Math.PI;
    }
}

//4. Circle – окружность
//Должна иметь конструктор, принимающий радиус. В качестве ширины и высоты должен выдаваться диаметр