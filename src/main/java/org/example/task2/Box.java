package org.example.task2;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    private void setLength(double length) {
        if (length <= 0) {
            System.out.println("Неправильна довжина, встановлено 1");
            this.length = 1;
        } else {
            this.length = length;
        }
    }

    private void setWidth(double width) {
        if (width <= 0) {
            System.out.println("Неправильна ширина, встановлено 1");
            this.width = 1;
        } else {
            this.width = width;
        }
    }

    private void setHeight(double height) {
        if (height <= 0) {
            System.out.println("Неправильна висота, встановлено 1");
            this.height = 1;
        } else {
            this.height = height;
        }
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getSurfaceArea() {
        return 2 * (length * width + length * height + width * height);
    }

    public double getLateralSurfaceArea() {
        return 2 * height * (length + width);
    }

    public double getVolume() {
        return length * width * height;
    }
}
