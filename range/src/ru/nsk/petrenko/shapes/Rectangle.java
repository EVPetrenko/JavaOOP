package ru.nsk.petrenko.shapes;

public class Rectangle implements Shapes {
    private double width;
    private double height;

    public Rectangle(double width, double height){
        this.width = width;
        this.height = height;
    }

    @Override
    public double getWidth(){
        return width;
    }

    @Override
    public  double getHeight(){
        return height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return (width + height) * 2;
    }
}

//3. Rectangle – прямоугольник
//Должен иметь конструктор, принимающий длины двух сторон