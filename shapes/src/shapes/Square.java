package shapes;

public class Square implements Shapes {
    private double length;

    public Square(double length){
        this.length = length;
    }

    @Override
    public double getWidth() {
        return length;
    }

    @Override
    public double getHeight() {
        return length;
    }

    @Override
    public  double getArea(){
        return Math.pow(length, 2);
    }

    @Override
    public  double getPerimeter(){
        return  length * 4;
    }
}

//1. Square – квадрат
//Должен иметь конструктор, принимающий длину стороны